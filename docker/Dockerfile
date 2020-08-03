FROM openjdk:8-jdk-alpine
MAINTAINER Chiseok Song <misoboy.kor@gmail.com>

WORKDIR /usr/app
COPY ../target/api-0.0.1-SNAPSHOT.jar ./
COPY entry-point.sh ./

ENTRYPOINT["entry-point.sh"]
EXPOSE 8080
