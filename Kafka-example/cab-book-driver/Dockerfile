FROM openjdk:17-jdk-alpine
COPY target/cab-book-driver-0.0.1-SNAPSHOT.jar /opt/cab-book-driver.jar


#RUN java -Djarmode=layertools -jar /opt/cab-book-driver.jar extract

EXPOSE 8082
# environment variable with default value
#ENV ENV_KAFKA_BROKER_HOST=localhost


#COPY --from=builder dependencies/ ./
#COPY --from=builder snapshot-dependencies/ ./
#COPY --from=builder spring-boot-loader/ ./
#COPY --from=builder application/ ./


#CMD ["/bin/bash", "-c", "echo nohup java -jar /opt/cab-book-driver-SNAPSHOT.jar com.sjala.spring.kafka.cabbookdriver.CabBookDriverApplication > log.log 2>&1 && echo nohup java -jar /opt/cab-book-user-SNAPSHOT.jar com.sjala.spring.kafka.cabbookuser.CabBookUserApplication > log.log 2>&1"]
ENTRYPOINT java -jar /opt/cab-book-driver.jar

