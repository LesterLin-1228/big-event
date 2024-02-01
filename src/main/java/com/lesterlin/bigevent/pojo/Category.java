package com.lesterlin.bigevent.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Category {
    @NotNull(groups = Update.class)
    private Integer id; //主鍵ID
    @NotEmpty
    private String categoryName; //分類名稱
    @NotEmpty
    private String categoryAlias; //分類别名
    private Integer createUser; //創建人ID
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime; //創建時間
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime; //更新時間

    // 如果某個校驗項沒有指定分組，默認屬於default分組
    // 分組間可以繼承，A extends B 那麼A中擁有B中所有的校驗項

    public interface Add extends Default {

    }

    public interface Update extends Default{

    }
}
