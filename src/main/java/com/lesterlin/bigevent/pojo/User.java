package com.lesterlin.bigevent.pojo;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDateTime;

// lombok 在編譯階段，為實體類自動生成getter,setter,toString...
// pom文件中引入依賴，在實體類上添加註解
@Data
public class User {
    @NotNull
    private Integer id; //主鍵ID
    private String username; //用戶名

    @JsonIgnore // 讓springmvc把當前對象轉換成json字串時忽略password，最終的json字串就沒有這個屬性了
    private String password; //密碼

    @NotEmpty
    @Pattern(regexp = "^\\S{1,10}$")
    private String nickname; //暱稱

    @NotEmpty
    @Email
    private String email; //信箱
    private String userPic; //用戶頭像地址
    private LocalDateTime createTime; //創建時間
    private LocalDateTime updateTime; //更新時間
}
