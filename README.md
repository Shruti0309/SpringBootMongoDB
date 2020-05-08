# SpringBootMongoDB

We will build a Spring Boot MongoDB Rest CRUD API for a User application in that:

Each User has id, age, residentCountry, qualification .
Apis help to create, retrieve, update, delete User.
Apis also support custom finder methods such as find by  qualification.
These are APIs that we need to provide:

Methods	Urls	Actions
POST	/createUser	create new User
GET	/users	retrieve all Users
GET	/users/{id}	retrieve a User by :id
GET /usersByQualification/{qualification}	retrieve a User by :qualification
PUT	/users/{id}	update a User by :id
DELETE /users/{id} delete a User by :id
DELETE	/users	delete all User
– We make CRUD operations & finder methods using Spring Data MongoDB.
– Rest Controller will be created with the help of Spring Web MVC.

Technology
Java 8
Spring Boot 2.2.4 (with Spring We
b MVC, Spring Data MongoDB)
MongoDB
Maven 3.6.1
