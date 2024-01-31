package com.lesterlin.bigevent.controller;

import com.lesterlin.bigevent.pojo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @GetMapping("/list")
    public Result<String> list(){
        return Result.success("所有的文章數據...");
    }
}
