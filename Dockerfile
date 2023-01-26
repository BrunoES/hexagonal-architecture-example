FROM openjdk:17-oracle

ARG JAR_FILE=target/hexagonal-architecture-example-0.0.1-SNAPSHOT.jar

ENV SPRING_DATASOURCE_PASSWORD=1234

WORKDIR /opt/app

COPY ${JAR_FILE} app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]

EXPOSE 9003