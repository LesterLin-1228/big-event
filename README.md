# 大事件文章管理後台系統 (Big-event)

這是為文章創作者設計的文章管理後台系統，提供了簡單易用的界面來創建、編輯、刪除和管理文章。  
支持文章和文章分類的管理，並提供了基本的搜索功能及個人資料的修改功能。

## 功能特性

- 使用者註冊與登入系統
- 忘記密碼發信重設功能
- 文章分類的創建、編輯和刪除
- 文章的創建、編輯和刪除 (可依分類或發布狀態搜尋且可選每頁要顯示幾條項目)
- 個人基本資料修改
- 更換頭像功能 (單文件最大100MB)
- 重置密碼功能
- 表單參數校驗

## 技術棧

- 前端：Vue.js (Template : Element-Plus)
- 後端：Java、Spring Boot
- 數據庫：MySQL、Redis
- 驗證：JWT (JSON Web Tokens)
- 雲服務：Amazon S3 (用於圖片儲存)
- RESTfull API (SpringDoc)
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
- Springboot3
- MySQL (內嵌於IDEA)
- Redis

#### 1. 克隆此倉庫
   
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
