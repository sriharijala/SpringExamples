FROM openjdk:17
WORKDIR /app
COPY ./cab-book-user-SNAPSHOT.jar /app
COPY ./cab-book-driver-SNAPSHOT.jar /app
EXPOSE 8081 8082
CMD ["/bin/bash", "-c", "echo nohup java -jar cab-book-driver-SNAPSHOT.jar > log.log 2>&1 &;echo nohup java -jar cab-book-user-SNAPSHOT.jar > log.log 2>&1 &"]