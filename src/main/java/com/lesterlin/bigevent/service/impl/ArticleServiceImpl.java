package com.lesterlin.bigevent.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lesterlin.bigevent.mapper.ArticleMapper;
import com.lesterlin.bigevent.pojo.Article;
import com.lesterlin.bigevent.pojo.PageBean;
import com.lesterlin.bigevent.service.ArticleService;
import com.lesterlin.bigevent.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public void add(Article article) {
        // 補充屬性值
        article.setCreateTime(LocalDateTime.now());
        article.setUpdateTime(LocalDateTime.now());

        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        article.setCreateUser(userId);
        articleMapper.add(article);
    }

    @Override
    public PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state) {
        // 1.創建PageBean對象
        PageBean<Article> pb = new PageBean<>();
        // 2.開啟分頁查詢(PageHelper)必須在pom中導入
        PageHelper.startPage(pageNum,pageSize);
        // 3.調用Mapper
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        List<Article> as = articleMapper.list(userId,categoryId,state);
        // Page提供了方法可以獲取PageHelper分頁查詢後得到的總紀錄條數和當前頁數據
        // 向下強制轉型才能調用子類別裡面特有的方法
        Page<Article> p = (Page<Article>) as;
        // 把數據填充到PageBean中
        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }

    @Override
    public Article findById(Integer id) {
        Article a = articleMapper.findById(id);
        return a;
    }

    @Override
    public void update(Article article) {
        article.setUpdateTime(LocalDateTime.now());
        articleMapper.update(article);
    }

    @Override
    public void delete(Integer id) {
        articleMapper.delete(id);
    }
}
