package com.lesterlin.bigevent.controller;

import com.lesterlin.bigevent.pojo.Result;
import com.lesterlin.bigevent.pojo.User;
import com.lesterlin.bigevent.service.UserService;
import com.lesterlin.bigevent.utils.JwtUtil;
import com.lesterlin.bigevent.utils.Md5Util;
import com.lesterlin.bigevent.utils.ThreadLocalUtil;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @PostMapping("/register")
    public Result<String> register(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password) {
        // 查詢用戶
        User u = userService.findByUserName(username);
        if (u == null) {
            // 沒被占用
            // 註冊
            userService.register(username, password);
            return Result.success();
        } else {
            // 占用
            return Result.error("用戶名已被占用");
        }

    }

    @PostMapping("/login")
    public Result<String> login(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password) {
        // 根據用戶名查詢用戶
        User loginUser = userService.findByUserName(username);
        // 判斷用戶是否存在
        if (loginUser == null) {
            return Result.error("用戶名錯誤");
        }
        // 判斷密碼是否正確 login對象中的password是密文
        if (Md5Util.getMD5String(password).equals(loginUser.getPassword())) {
            // 登錄成功
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", loginUser.getId());
            claims.put("username", loginUser.getUsername());
            String token = JwtUtil.genToken(claims);
            // 把token儲存到redis中
            ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
            operations.set(token, token, 3, TimeUnit.HOURS);
            return Result.success(token);
        }
        return Result.error("密碼錯誤");
    }

    @GetMapping("/userInfo")
    public Result<User> userInfo(/*@RequestHeader(name = "Authorization") String token*/) {
        // 根據用戶名查詢用戶
//        Map<String, Object> map = JwtUtil.parseToken(token);
//        String username = (String) map.get("username");
        Map<String, Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");
        User user = userService.findByUserName(username);
        return Result.success(user);
    }

    @PutMapping("/update")
    public Result update(@RequestBody @Validated User user) {
        userService.update(user);
        return Result.success();
    }

    @PatchMapping("/updateAvatar")
    public Result updateAvatar(@RequestParam @URL String avatarUrl) {
        userService.updateAvatar(avatarUrl);
        return Result.success();
    }

    @PatchMapping("/updatePwd")
    public Result updatePwd(@RequestBody Map<String, String> params, @RequestHeader("Authorization") String token) {
        // 1. 校驗參數
        String oldPwd = params.get("old_pwd");
        String newPwd = params.get("new_pwd");
        String rePwd = params.get("re_pwd");

        if (!StringUtils.hasLength(oldPwd) || !StringUtils.hasLength(newPwd) || !StringUtils.hasLength(rePwd)) {
            return Result.error("缺少必要的參數");
        }

        // 校驗原密碼是否正確
        // 調用userService根據用戶名拿到原密碼，再和oldPwd比對
        Map<String, Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");
        User loginUser = userService.findByUserName(username);
        if (!loginUser.getPassword().equals(Md5Util.getMD5String(oldPwd))) {
            return Result.error("原密碼錯誤");
        }

        // 校驗newPwd不能和oldPwd一樣*
        if (oldPwd.equals(newPwd)) {
            return Result.error("新密碼不得和原密碼相同");
        }

        // 校驗newPwd和rePwd是否一樣
        if (!rePwd.equals(newPwd)) {
            return Result.error("兩次填寫的新密碼不同");
        }

        // 2. 調用userService完成密碼更新
        userService.updatePwd(newPwd);
        // 刪除redis中對應的token
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        operations.getOperations().delete(token);

        return Result.success();
    }

    // 發送忘記密碼信件
    @PostMapping("/sendMail")
    public Result sendMail(String email, String username) throws Exception {
        // 根據用戶名查詢用戶
        User userResetPwd = userService.findByUserName(username);
        // 判斷用戶是否存在
        if (userResetPwd == null) {
            return Result.error("用戶名錯誤");
        }
        // 判斷信箱是否符合
        if (email.equals(userResetPwd.getEmail())) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", userResetPwd.getId());
            claims.put("username", userResetPwd.getUsername());
            // 生成安全令牌
            String token = JwtUtil.genToken(claims);
            // 把token儲存到redis中
            ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
            operations.set(token, token, 1, TimeUnit.HOURS);
            // 發信
            userService.sendMail(userResetPwd.getEmail(), token);
            return Result.success(token);
        }
        return Result.error("信箱不符");
    }

    // 忘記密碼重設
    @PatchMapping("/resetPwd")
    public Result<String> resetPwd(@RequestHeader("Authorization") String token, @RequestBody Map<String, String> params) {
        // 從redis中獲取相同的token
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        String redisToken = operations.get(token);
        if(redisToken==null){
            // token已失效
            throw new RuntimeException();
        }
        // 解析安全令牌，提取用戶名
        Map<String, Object> claims = JwtUtil.parseToken(token);
        ThreadLocalUtil.set(claims);
        String username = (String) claims.get("username");
        // 根據用戶名查找用戶
        User user = userService.findByUserName(username);
        if (user == null) {
            return Result.error("用戶不存在");
        }
        // 檢查新密碼與確認新密碼是否一致
        String newPwd = params.get("new_pwd");
        String reNewPwd = params.get("re_pwd");
        if (!newPwd.equals(reNewPwd)) {
            return Result.error("新密碼與確認新密碼不一致");
        }
        //調用userService完成密碼更新
        userService.updatePwd(newPwd);
        // 刪除redis中對應的token
        operations.getOperations().delete(token);
        ThreadLocalUtil.remove();
        return Result.success("密碼已重新設定");
    }
}
