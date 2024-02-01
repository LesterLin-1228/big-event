package com.lesterlin.bigevent.controller;

import com.lesterlin.bigevent.pojo.Article;
import com.lesterlin.bigevent.pojo.Result;
import com.lesterlin.bigevent.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping
    public Result add(@RequestBody Article article){
        articleService.add(article);
        return Result.success();
    }
}
