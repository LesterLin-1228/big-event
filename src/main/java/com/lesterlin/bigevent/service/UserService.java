package com.lesterlin.bigevent.service;

import com.lesterlin.bigevent.pojo.User;

public interface UserService {
    // 根據用戶名查詢用戶
    User findByUserName(String username);
    // 註冊
    void register(String username, String password);
    // 更新
    void update(User user);
    // 更新頭像
    void updateAvatar(String avatarUrl);
    // 更新密碼
    void updatePwd(String newPwd);
}
