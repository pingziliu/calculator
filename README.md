# Java + Spring + Maven

该模版基于 Spring Boot 搭建了单页应用。使用 CODING 持续集成构建模版可以快速将本应用打包，执行单元测试，收集测试报告，并推送到 CODING Maven 制品仓库。

## 快速开始

### 在开发环境运行本应用

```
mvn clean package
```

```
java -jar target/spring-boot-0.0.1-SNAPSHOT.jar
```

打开[http://localhost:8080](http://localhost:8080)浏览本应用。

## 其他命令

### 测试

```
mvn test
```

### 部署到 CODING Maven 制品仓库

推送前需要提前配置凭据信息，了解详情请见[帮助文档](https://help.coding.net/docs/ar/quick-start/maven.html)

```
mvn deploy
```
