package com.lesterlin.bigevent.controller;

import com.lesterlin.bigevent.pojo.Result;
import com.lesterlin.bigevent.pojo.User;
import com.lesterlin.bigevent.service.UserService;
import com.lesterlin.bigevent.utils.Md5Util;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

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
    public Result<String> login(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password){
        // 根據用戶名查詢用戶
        User loginUser = userService.findByUserName(username);
        // 判斷用戶是否存在
        if(loginUser==null){
            return Result.error("用戶名錯誤");
        }
        // 判斷密碼是否正確 login對象中的password是密文
        if(Md5Util.getMD5String(password).equals(loginUser.getPassword())){
            // 登錄成功
            return Result.success("jwt token");
        }
        return Result.error("密碼錯誤");
    }
}
