package com.lesterlin.bigevent.service;

import com.lesterlin.bigevent.pojo.Article;
import com.lesterlin.bigevent.pojo.PageBean;

public interface ArticleService {
    // 新增文章
    void add(Article article);
    // 條件分頁列表查詢
    PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state);
    // 根據文章id獲取文章詳情
    Article findById(Integer id);
    // 更新文章資料
    void update(Article article);
    // 根據id刪除文章
    void delete(Integer id);
}
