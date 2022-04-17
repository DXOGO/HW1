# HW1 - 98595

#### Web application with details on COVID incidence data for a certain country/territory. 

Includes:

- Web app which allows users to enter or select a region/country and access its recent COVID metrics
- Integration with external source(s). Backend services will function as a client for a third-party API, which you will access to obtain the values. 
- Implement a cache to reduce the number of external accesses.
- Your own *REST API* to expose COVID monitoring data to be invoked by external clients
- Logging strategy to produce useful evidence of the actions/events that happened while using your software, for later inspection/debugging.



#### **How to run:**



##### To create *jar* file

Inside *hw1-app* *folder*

```bash
mvn clean package -DskipTests
```

Then,

```
[DOCKER] 		./run.sh (localhost:8080)
[OPTIONAL] 		./mvnw spring-boot:run (in the hw1-app folder)
```

