# event-driven-system

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
