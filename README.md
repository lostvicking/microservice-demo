# microservice-demo
Demo of Spring Boot Microservices, including: Eureka, Hystrix, Swagger UI

3 Spring Boot Microservices: Eureka-Server, Bookstore-Service and Reading-Service
Java 8 only for now, there are some issues getting Sring Cloud dependencies to compile under Java 9.

Eureka-Server: discovery server, enables other microservices to call each other by service name
Bookstore-Service: exposes /recommended GET method for getting book recommendations
Reading-Service: exposes /to-read GET method which calls Bookstore-Service


Run Eureka-Server like so:
```
java -jar target/eureka-server-1.0-SNAPSHOT.jar 
```

Run Reading-Service like so:
```
java -jar target/reading-1.0-SNAPSHOT.jar
```

Run the Bookstore-Service like so, specify you own parameters:
```
java -jar target/bookstore-1.0-SNAPSHOT.jar --readingList=<Specify reading list here> --server.port=<port_number>
```

Swagger UI endpoints are configured for Bookstore-Serivce and Reading-Service at:
```
http://<host>:<port>/swagger-ui.html 
```

