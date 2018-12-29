FROM openjdk:jre-alpine

COPY build/libs/ /app

EXPOSE 8090

ENTRYPOINT ["java", "-jar", "/app/stateless-word-count-1.0-SNAPSHOT-all.jar"]
