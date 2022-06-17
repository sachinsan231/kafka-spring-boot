# kafka-spring-boot

reference : https://howtodoinjava.com/kafka/spring-boot-with-kafka/

to set up Kafka: https://howtodoinjava.com/kafka/getting-started-windows-10/

Command to create topic: bin\windows\kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic test

command to comsume messages from topic: bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic test --from-beginning