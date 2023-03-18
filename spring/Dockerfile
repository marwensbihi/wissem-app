FROM openjdk:21-ea-13-jdk-oraclelinux8

COPY ./target/*jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]