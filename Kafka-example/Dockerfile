FROM openjdk:17
WORKDIR /app
COPY Kafka-example/cab-book-user/cab-book-user-SNAPSHOT.jar /app
COPY Kafka-example/cab-book-driver/target/cab-book-driver-SNAPSHOT.jar /app
EXPOSE 8081 8082
CMD ["/bin/bash", "-c", "echo java -jar cab-book-driver-SNAPSHOT.jar;echo java -jar cab-book-user-SNAPSHOT.jar"]