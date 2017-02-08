# event-driven-system

## docker folder:

  Contains docker config to run and scale kafka cluster elements as docker containers.

######  Prerequisites
- Install docker, docker-compose and docker-machine(including virtualbox)
- Create a docker-machine "kafka" as docker containers host running the following command:
```
  $> docker-machine create --driver virtualbox kafka
```

Running Kafka cluster with default bootstrap properties

  ```
  $> docker-compose up -d
  ```
Scaling to n multiple brokers.(e.g 3 kafka brokers)

  ```
  $> docker-compose scale kafka=3 -d
  ```

Stop and remove cluster containers

  ```
  $> docker-compose down
  ```

## event producer folder:

  Contains a kafka event producer application in Java.

## event consumer folder:

  Contains a kafka event consumer application in Java.

## Running all pieces together and testing

##### Steps:

1. Start kafka cluster as we describe in docker section

  ```
  $> docker-compose up -d
  ```
2. Start event consumer application.

  ```
  $> cd event-consumer
  $> mvn install
  $> java -jar target/event-consumer-0.0.1-SNAPSHOT.jar

  ```

3. Start event producer application.

  ```
  $> cd event-producer
  $> mvn install
  $> java -jar target/event-producer-0.0.1-SNAPSHOT.jar
  ```
4. Testing producer endpoint via the following curl command:

  ```
  curl -X POST -H "Content-Type: application/json" -H "Cache-Control: no-cache" -d '{"prueba":"contenido"}' "http://localhost:9080/message"
  ```

5. Now you can check consumer logs to verify that it's writing the received messages.

  ```
  2017-02-08 18:55:03.622  INFO 32553 --- [afka-consumer-1] o.s.k.l.KafkaMessageListenerContainer    : partitions assigned:[]
  {"prueba":"contenido"}
  ```
