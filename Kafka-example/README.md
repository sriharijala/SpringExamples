# kafka-cab-app
Get the Docker image:

$ docker pull apache/kafka:3.8.0
Start the Kafka Docker container:

$ docker run -p 9092:9092 apache/kafka:3.8.0


Step 3: Create a topic to store your events
Kafka is a distributed event streaming platform that lets you read, write, store, and process events (also called records or messages in the documentation) across many machines.

Example events are payment transactions, geolocation updates from mobile phones, shipping orders, sensor measurements from IoT devices or medical equipment, and much more. These events are organized and stored in topics. Very simplified, a topic is similar to a folder in a filesystem, and the events are the files in that folder.

So before you can write your first events, you must create a topic. Open another terminal session and run:

$ bin/kafka-topics.sh --create --topic cab-location --bootstrap-server localhost:9092
All of Kafka's command line tools have additional options: run the kafka-topics.sh command without any arguments to display usage information. For example, it can also show you details such as the partition count of the new topic:

$ bin/kafka-topics.sh --describe --topic cab-location --bootstrap-server localhost:9092
Topic: cab-location        TopicId: NPmZHyhbR9y00wMglMH2sg PartitionCount: 1       ReplicationFactor: 1	Configs:
Topic: cab-location Partition: 0    Leader: 0   Replicas: 0 Isr: 0


Step 4: Write some events into the topic
A Kafka client communicates with the Kafka brokers via the network for writing (or reading) events. Once received, the brokers will store the events in a durable and fault-tolerant manner for as long as you need—even forever.

Run the console producer client to write a few events into your topic. By default, each line you enter will result in a separate event being written to the topic.

$ bin/kafka-console-producer.sh --topic cab-location --bootstrap-server localhost:9092
>This is my first event
>This is my second event

