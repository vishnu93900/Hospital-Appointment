FROM openjdk:8
EXPOSE 8080
ADD target\Hospital-App.jar Hospital-App.jar
ENTRYPOINT ["java","-jar","/Hospital-App.jar.jar"]