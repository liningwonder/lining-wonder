1、IDEA  启动时需要勾选 Disable Launch optimization   Disable JMX agent

2、内置的tomcat于Java版本问题
Java 8 对应的tomcat版本为 9.0.x
Java 11 对应的tomcat版本为 10.1.x
Java 21 对应的tomcat版本为 11.0.x

3、切换成undertow
(1) POM
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
            <exclusions>
                <exclusion>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-tomcat</artifactId>
                </exclusion>
            </exclusions>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-undertow</artifactId>
        </dependency>

(2) 如果引入websocket，同事也需去除对应依赖

(3)核心配置

https://blog.csdn.net/z69183787/article/details/129020703

日志配置
https://undertow.io/undertow-docs/undertow-docs-2.0.0/index.html#access-log-handler


io.undertow.server.handlers.accesslog.AccessLogHandler


    private static String handleCommonNames(String formatString) {
        if (formatString.equals("common")) {
            return "%h %l %u %t \"%r\" %s %b";
        } else if (formatString.equals("combined")) {
            return "%h %l %u %t \"%r\" %s %b \"%{i,Referer}\" \"%{i,User-Agent}\"";
        } else if (formatString.equals("commonobf")) {
            return "%o %l %u %t \"%r\" %s %b";
        } else {
            return formatString.equals("combinedobf") ? "%o %l %u %t \"%r\" %s %b \"%{i,Referer}\" \"%{i,User-Agent}\"" : formatString;
        }
    }


