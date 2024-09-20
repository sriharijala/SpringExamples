FROM ubuntu:22.04
WORKDIR /opt
COPY ./cab-book-user-SNAPSHOT.jar /opt
COPY ./cab-book-driver-SNAPSHOT.jar /opt
EXPOSE 8081 8082
CMD ["/bin/bash", "-c", "echo nohup java -jar /opt/cab-book-driver-SNAPSHOT.jar > log.log 2>&1 && echo nohup java -jar /opt/cab-book-user-SNAPSHOT.jar > log.log 2>&1"]