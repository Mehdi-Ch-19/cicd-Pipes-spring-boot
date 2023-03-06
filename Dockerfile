FROM openjdk:17-jdk-slim
WORKDIR application
EXPOSE 8080
COPY target/cicdtp-0.0.1-SNAPSHOT.jar ./
ENTRYPOINT ["java","-jar","cicdtp-0.0.1-SNAPSHOT.jar"]