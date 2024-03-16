FROM eclipse-temurin:17-jdk-focal

# 設定容器的工作目錄為 /app
WORKDIR /app

# 複製 Maven 相關的設定文件到容器中的 .mvn 目錄
COPY .mvn/ .mvn
# 複製 Maven Wrapper 和專案的 pom.xml 文件到容器中
COPY mvnw pom.xml ./
# 使用 Maven Wrapper 預先下載專案依賴的 jar 檔案
RUN ./mvnw dependency:go-offline
# 複製專案的源代碼到容器中的 src 目錄
COPY src ./src

# 設定容器的執行指令，運行 Spring Boot 應用程式
CMD ["./mvnw", "spring-boot:run"]
