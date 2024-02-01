package com.lesterlin.bigevent.service;

import com.lesterlin.bigevent.pojo.Category;

import java.util.List;

public interface CategoryService {
    // 新增分類
    void add(Category category);
    // 列表查詢
    List<Category> list();
    // 根據id查詢分類訊息
    Category findById(Integer id);
}
