package com.lesterlin.bigevent.pojo;



import lombok.Data;

import java.time.LocalDateTime;

// lombok 在編譯階段，為實體類自動生成getter,setter,toString...
// pom文件中引入依賴，在實體類上添加註解
@Data
public class User {
    private Integer id; //主鍵ID
    private String username; //用戶名
    private String password; //密碼
    private String nickname; //暱稱
    private String email; //信箱
    private String userPic; //用戶頭像地址
    private LocalDateTime createTime; //創建時間
    private LocalDateTime updateTime; //更新時間
}
