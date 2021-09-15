# egen
This is a take home assessment. This is a ecommerce order picking service based application which manages the employee performance based on the orders.


This project contains 2 microservices (Modules)
1. egen-picking
2. egen-labour-management

Egen-picking runs on port number 8080 and egen-labour-management runs on port number 8081

egen-picking
 --> this includes, Single order picking and bulk order picking.
 --> there is one file named schema.sql in both the microservices, which will run only once during the project run. This file contains all the tables and related info.
 --> API's are present in the Controller folder.
 --> Data Models are present in the Models folder.
 --> Services (Which interacts with DB) are present in the services folder.
 --> Swagger documentation (localhost:8080/swagger-ui.html)

egen-labour-management
--> this includes creating a new file based on timely based to evaluate the employee performance.
--> this includes ScheduleConfiguration which helps us to Schedule the endpoint based on the frequency mentioned.