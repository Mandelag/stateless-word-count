FROM openjdk:latest

COPY build/libs/ /app

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/stateless-word-count-1.0.SNAPSHOT-all.jar"]
