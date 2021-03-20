FROM openjdk:11-jre-slim
COPY build/libs/order-service-0.0.1-SNAPSHOT.jar app.jar
ENV PORT=6662
EXPOSE 6662/tcp
ENTRYPOINT ["sh", "-c", "java -jar app.jar"]