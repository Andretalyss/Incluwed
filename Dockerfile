FROM openjdk:11

COPY target/*.jar incluwed.jar

ENTRYPOINT ["java","-jar","incluwed.jar"]

