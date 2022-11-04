FROM openjdk:8-jdk-alpine
MAINTAINER enes.acikoglu@gmail.com
VOLUME /tmp
ADD target/KotlinSpringBootApi-*.jar kotlin-api.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/kotlin-api.jar"]