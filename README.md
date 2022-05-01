## Bank Account
The account service is responsible for storing the account information of an user of the bank.

Each bank account undergoes several payment or withdrawal transactions.
The shopping cart service manages the products that a user has chosen to add to their online shopping cart.The user service is responsible for being the authentication gateway for the online bank account application.

The app is structured on the following modules:

  controller module: 
- a key difference between a traditional MVC controller and the RESTful web service controller is the way that the HTTP response body is created. Rather than relying on a view technology to perform server-side rendering of the data to HTML, this RESTful web service controller populates and returns an object. The object data will be written directly to the HTTP response as JSON.
This code uses Spring @RestController annotation, which marks the class as a controller where every method returns a domain object instead of a view. It is shorthand for including both @Controller and @ResponseBody.

    dao module:
- contains the dao classes that are used for CRUD operations on the database.(CRUD refers Create, Read, Update, Delete).I need to create a repository that holds user records.

    entities module: 
- contains the entities classes that are mapped at the database level (ORM).

    security module: 
- is responsible for the authentication, authorization logic of the user in the app, and activating the account when a new one is created.

    service module:
- contains the service classes that stores the business logic code of the app.

Spring Boot does not generate code or make edits to your files. Instead, when you start your application, Spring Boot dynamically wires up beans and settings and applies them to your application context. 

Framework and dependecies used: Spring boot 1.5.9, Spring security, Spring web, Spring Data Jpa, mysql-connector-java, Hibernate validator, mySQL database.



