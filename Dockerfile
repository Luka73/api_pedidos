FROM openjdk:17
VOLUME /tmp
EXPOSE 8084
ARG JAR_FILE=target/api_pedidos-1.0.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]