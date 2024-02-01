package com.lesterlin.bigevent.mapper;

import com.lesterlin.bigevent.pojo.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoryMapper {
    // 新增分類
    @Insert("insert into category(category_name,category_alias,create_user,create_time,update_time) " +
            "values(#{categoryName},#{categoryAlias},#{createUser},#{createTime},#{updateTime})")
    void add(Category category);
    // 查詢所有
    @Select("select * from category where create_user=#{userId}")
    List<Category> list(Integer userId);
    // 根據id查詢
    @Select("select * from category where id=#{id}")
    Category findById(Integer id);
    // 更新分類
    @Update("update category set category_name=#{categoryName},category_alias=#{categoryAlias},update_time=#{updateTime} where id=#{id}")
    void update(Category category);
    // 刪除文章分類
    @Delete("delete from category where id=#{id}")
    void deleteById(Integer id);
}
