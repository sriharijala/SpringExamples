FROM openjdk:17-jdk-alpine
COPY target/cab-book-user-0.0.1-SNAPSHOT.jar /opt/cab-book-user.jar
EXPOSE 8081
#CMD ["/bin/bash", "-c", "echo nohup java -jar /opt/cab-book-driver-SNAPSHOT.jar com.sjala.spring.kafka.cabbookdriver.CabBookDriverApplication > log.log 2>&1 && echo nohup java -jar /opt/cab-book-user-SNAPSHOT.jar com.sjala.spring.kafka.cabbookuser.CabBookUserApplication > log.log 2>&1"]
ENTRYPOINT java -jar /opt/cab-book-user.jar

