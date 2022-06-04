FROM openjdk:11

RUN apt update && apt upgrade && apt install -y --no-cache curl openssl ca-certificates wget
RUN apt install -y --no-cache tzdata
ENV TZ America/Recife

COPY target/*.jar incluwed.jar

ENTRYPOINT ["java","-jar","incluwed.jar"]

