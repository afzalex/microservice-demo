FROM openjdk:11-jre-slim
COPY build/libs/product-service-0.0.1-SNAPSHOT.jar app.jar
ENV PORT=6661
EXPOSE 6661/tcp
ENTRYPOINT ["sh", "-c", "java -jar app.jar"]