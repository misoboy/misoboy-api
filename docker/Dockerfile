FROM openjdk:8-jdk-alpine
MAINTAINER Chiseok Song <misoboy.kor@gmail.com>

WORKDIR /usr/app
COPY ./api-0.0.1-SNAPSHOT.jar ./

ARG SPRING_PROFILES_ACTIVE

ENV SPRING_PROFILES_ACTIVE=$SPRING_PROFILES_ACTIVE

CMD ["java", "-jar", "api-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080
