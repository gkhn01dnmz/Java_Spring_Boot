FROM alpine:3.13
RUN apk --no-cache add openjdk11-jre

COPY target/Docker.jar  Docker.jar

ENTRYPOINT ["java", "-jar", "/Docker.jar"]