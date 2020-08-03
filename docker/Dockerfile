FROM openjdk:8-jdk-alpine
MAINTAINER Chiseok Song <misoboy.kor@gmail.com>

WORKDIR /usr/app
COPY ../target/api-0.0.1-SNAPSHOT.jar ./

CMD ["java", "-jar", "/usr/app/api-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080
