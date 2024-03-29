package com.lesterlin.bigevent.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.lesterlin.bigevent.anno.State;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.groups.Default;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDateTime;

@Data
public class Article {
    @NotNull(groups = Article.Update.class)
    private Integer id; //主鍵ID
    @NotEmpty
    @Pattern(regexp = "^\\S{1,20}$")
    private String title; //文章標題
    @NotEmpty
    private String content; //文章内容
    @NotEmpty
    @URL
    private String coverImg; //封面圖像
    @State
    private String state; //發布狀態 已發布|草稿
    @NotNull
    private Integer categoryId; //文章分類id
    private Integer createUser; //創建人ID
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime; //創建時間
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime; //更新時間

    public interface Add extends Default {

    }

    public interface Update extends Default{

    }
}
