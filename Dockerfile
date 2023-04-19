FROM openjdk:11

COPY target/spring-boot-mysql.jar  /usr/app/

WORKDIR /usr/app/

ENTRYPOINT ["java" , "-jar" , "spring-boot-mysql.jar"]
