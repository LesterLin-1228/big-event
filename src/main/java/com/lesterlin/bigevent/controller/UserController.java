package com.lesterlin.bigevent.controller;

import com.lesterlin.bigevent.pojo.Result;
import com.lesterlin.bigevent.pojo.User;
import com.lesterlin.bigevent.service.UserService;
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
    public Result register(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password) {
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
}
