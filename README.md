

# About

This is Spring Boot REST API demo 

### Technology stack
Spring Boot,
Spring Web,
Spring Data JPA,
H2 Database,
Maven,
JUnit,
Lombok,
Travis CI

### To run this application use
./gradlew bootRun

### Postman collection included (under main/resources)
Get all reports
GET http://localhost:8080/reports

Get report by id
GET http://localhost:8080/reports/{id}

Save new report
POST http://localhost:8080/reports

Delete report by id
DELETE http://localhost:8080/reports/{id}
