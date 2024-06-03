FROM ubuntu:22.04 AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . .

RUN apt-get install maven -y
RUN mvn clean install

FROM openjdk:17-jdk-slim

EXPOSE 8080

COPY --from=build evento-0.0.1-SNAPSHOT.jar app.

ENTRYPOINT [ "java", "-jar", "app.jar" ]