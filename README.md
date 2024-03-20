# 大事件文章管理後台系統 (Big-Event)

這是為文章創作者設計的文章管理後台系統，提供了簡單易用的界面來創建、編輯、刪除和管理文章。  
支持文章和文章分類的管理，並提供了基本的搜索功能及個人資料的修改功能。

## 功能特性

- 使用者註冊與登入系統 ![RegisterAndLogin](./src/main/resources/static/registerAndLogin.gif)
- 忘記密碼發信重設功能 ![ForgetPwd](./src/main/resources/static/forgetPwd.gif)
- 文章分類的創建、編輯和刪除 ![CategoryCRUD](./src/main/resources/static/categoryCRUD.gif)
- 文章的創建、編輯和刪除 (可依分類或發布狀態搜尋且可選每頁要顯示幾條項目) ![ArticleCRUD](./src/main/resources/static/articleCRUD.gif)
- 個人基本資料修改 ![UserInfoUpdate](./src/main/resources/static/userInfoUpdate.gif)
- 更換頭像功能 ![AvatarUpdate](./src/main/resources/static/avatarUpdate.gif)
- 重置密碼功能 ![PasswordUpdate](./src/main/resources/static/passwordUpdate.gif)
- 登出並跳轉登入畫面 ![Logout](./src/main/resources/static/logout.gif)

## 技術棧

- 前端：使用 Vue3 的 Composition API、pinia 狀態管理庫、vite 快速開發工具和 Element-Plus UI 框架，以及 Axios 用於發送 HTTP 請求
- 後端：使用 Java17 和 Spring Boot3 作為後端開發框架
- 數據庫：使用 MySQL 和 Redis 作為數據庫系統
- 驗證：使用 JWT (JSON Web Tokens) 來實現身份驗證
- 雲服務：使用 Amazon S3 作為圖片儲存服務
- RESTfull API ([API Doc](https://app.swaggerhub.com/apis-docs/NEWA5812763/BigEvent/1.0.0)
  )
- Docker & Docker Compose ([Docker Hub](https://hub.docker.com/repository/docker/lesterlinouo/big-event/general))

## 安裝指南

### Docker 部署
   
#### 1. 安裝Docker Desktop

- clone
```bash
git clone https://github.com/Lester-1228/big-event.git
```
- cd
```bash
cd big-event
```
- 啟動 Docker 容器
```bash
docker-compose up
```

#### 2. 訪問 http://localhost 查看應用。
可以直接註冊或使用以下用戶名及密碼測試專案  
用戶名 : Lester  
密碼 : 123456

#### 聯繫我 : newa5812763@gmail.com