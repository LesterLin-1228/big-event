# 使用 Eclipse Temurin 提供的 Java 17 映像作為基礎
FROM eclipse-temurin:17-jdk-focal

# 設定容器的工作目錄為 /app，所有後續的指令都將在這個目錄下執行
WORKDIR /app

# 將本機的 .mvn/ 目錄複製到容器中的 .mvn 目錄下
COPY .mvn/ .mvn
# 複製 Maven Wrapper 和專案的 pom.xml 文件到容器中
COPY mvnw pom.xml ./
# 使用 Maven Wrapper 預先下載專案依賴的 jar 檔案，這樣在後續的建構過程中就不需要再下載依賴了
RUN ./mvnw dependency:go-offline
# 將本機的 src/ 目錄複製到容器中的 src/ 目錄下，這是專案的源代碼
COPY src ./src

# 設定容器的執行指令，在容器啟動時使用 Maven Wrapper 運行 Spring Boot 應用程序
CMD ["./mvnw", "spring-boot:run"]
