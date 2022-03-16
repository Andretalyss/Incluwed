FROM openjdk:11

COPY target/*.jar project.jar

ENTRYPOINT ["java","-jar","project.jar"]

