FROM openjdk:11
ENV TZ America/Recife

COPY target/*.jar incluwed.jar

ENTRYPOINT ["java","-jar","incluwed.jar"]

