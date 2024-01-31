package com.lesterlin.bigevent.controller;

import com.lesterlin.bigevent.pojo.Result;
import com.lesterlin.bigevent.utils.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @GetMapping("/list")
    public Result<String> list(/*@RequestHeader(name = "Authorization") String token, HttpServletResponse response*/) {
//        // 驗證token
//        try {
//            Map<String, Object> claims = JwtUtil.parseToken(token);
//            return Result.success("所有的文章數據...");
//        } catch (Exception e) {
//            // http狀態碼為401
//            response.setStatus(401);
//            return Result.error("未登入");
//        }
        return Result.success("所有的文章數據...");
    }
}
