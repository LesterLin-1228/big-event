package com.lesterlin.bigevent.controller;

import com.lesterlin.bigevent.pojo.Article;
import com.lesterlin.bigevent.pojo.PageBean;
import com.lesterlin.bigevent.pojo.Result;
import com.lesterlin.bigevent.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping
    public Result add(@RequestBody @Validated(Article.Add.class) Article article){
        articleService.add(article);
        return Result.success();
    }

    @GetMapping
    public Result<PageBean<Article>> list(
            Integer pageNum,
            Integer pageSize,
            @RequestParam(required = false) Integer categoryId, // 前端非必要傳的參數
            @RequestParam(required = false) String state // 前端非必要傳的參數
    ){
        PageBean<Article> pb = articleService.list(pageNum,pageSize,categoryId,state);
        return Result.success(pb);
    }

    @GetMapping("/detail")
    public Result<Article> detail(@RequestParam Integer id){
        Article a = articleService.findById(id);
        return Result.success(a);
    }

    @PutMapping
    public Result update(@RequestBody @Validated(Article.Update.class) Article article){
        articleService.update(article);
        return Result.success();
    }

    @DeleteMapping
    public Result delete(@RequestParam Integer id){
        articleService.delete(id);
        return Result.success();
    }

}
