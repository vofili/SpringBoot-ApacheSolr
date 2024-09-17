FROM openjdk:17-jdk-alpine
MAINTAINER valentine-nubeero.com
COPY target/spring-base-google-photo-0.0.1-SNAPSHOT.jar spring-base-google-photo-0.0.1.jar
ENTRYPOINT ["java","-jar","/spring-base-google-photo-0.0.1.jar"]