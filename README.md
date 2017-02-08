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

3. Start event consumer application.
```
```

4. Start event producer application.
```
```
