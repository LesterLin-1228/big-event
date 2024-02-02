package com.lesterlin.bigevent.mapper;

import com.lesterlin.bigevent.pojo.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleMapper {
    // 新增文章
    @Insert("insert into article(title,content,cover_img,state,category_id,create_user,create_time,update_time) " +
            "values(#{title},#{content},#{coverImg},#{state},#{categoryId},#{createUser},#{createTime},#{updateTime})")
    void add(Article article);
    // 文章分類列表查詢條件分頁(導入配置文件(動態sql))
    List<Article> list(Integer userId, Integer categoryId, String state);
    // 根據id獲取文章詳情
    @Select("select * from article where id=#{id}")
    Article findById(Integer id);
    // 更新文章詳情
    @Update("update article set title=#{title},content=#{content},cover_img=#{coverImg},state=#{state},category_id=#{categoryId},update_time=#{updateTime} where id=#{id}")
    void update(Article article);
    // 根據id刪除文章
    @Delete("delete from article where id=#{id}")
    void delete(Integer id);
}
