
## 目录结构
```
|--doc
    |--java -java 记录
    |--spring boot  -spring boot 记录
    |--Intellij idea tips.md -idea小技巧
|--logs -log4j2日志存放路径
|--src
    |--main
        |--java
            |--com/example
                |--DemoApplication.java
                |--controller - Controller 层
                |--service - 业务逻辑层
                |--dao - 数据操作层 DAO
                |--domain - 实体类
                |--annotation - 注解
                |--aspect - aop
                |--config - config(swagger2 等)
        |--resources
            |--application.properties -应用配置文件，应用启动会自动读取配置
            |--application-dev.properties
            |--application-prod.properties
            |--application.properties
            |--log4j2.xml -log4j2配置文件
    |--test
    
|--pom.xml
|--demo.sql - sql备份

```

* 自动化文档

```
http://localhost:8080/swagger-ui.html

```
