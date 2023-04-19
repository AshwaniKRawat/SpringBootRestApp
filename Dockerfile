FROM openjdk:11

COPY target/spring-boot-web-app.jar  /usr/app/

WORKDIR /usr/app/

ENTRYPOINT ["java" , "-jar" , "spring-boot-web-app.jar"]
