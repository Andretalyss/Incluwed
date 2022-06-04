FROM openjdk:11-alpine

RUN apk update && apk upgrade && apk add --no-cache curl openssl ca-certificates wget
RUN apk add --no-cache tzdata
ENV TZ America/Recife

COPY target/*.jar incluwed.jar

ENTRYPOINT ["java","-jar","incluwed.jar"]

