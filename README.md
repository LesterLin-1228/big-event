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

- 前端：Vue3 (Composition API)、pinia、vite、Element-Plus
- 後端：Java17、Spring Boot3
- 數據庫：MySQL、Redis
- 驗證：JWT (JSON Web Tokens)
- 雲服務：Amazon S3 (用於圖片儲存)
- RESTfull API ([API Doc](https://app.swaggerhub.com/apis-docs/NEWA5812763/BigEvent/1.0.0)
  )
- Axios

## 安裝指南

### 開發環境  
1. 前端
- Visual Studio
- Node.js
- Vue3
2. 後端
- IntelliJ IDEA
- Java17
- Spring Boot3
- MySQL (內嵌於IDEA)
- Redis

#### 1. 克隆
   
- 前端
```bash
git clone https://github.com/Lester-1228/big-event-vue.git
```

- 後端
```bash
git clone https://github.com/Lester-1228/big-event.git
```

#### 2. 安裝依賴

```bash
npm install
```

#### 3. 啟動前端應用

```bash
npm run dev
```

訪問 http://localhost:5173 查看應用。
#### 可以直接註冊或使用以下用戶名及密碼測試專案
用戶名 : Lester  
密碼 : 123456
