FROM openjdk:11-jre-slim
COPY build/libs/gateway-server-0.0.1-SNAPSHOT.jar app.jar
ENV PORT=6669
EXPOSE 6669/tcp
ENTRYPOINT ["sh", "-c", "java -jar app.jar"]