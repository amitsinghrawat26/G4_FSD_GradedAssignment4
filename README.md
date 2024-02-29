Employee Management Rest API-based Web application, where we have developed CRUD(Create, Read, Update, and Delete) functionality along with Sorting and some concepts of security.

This Rest API is secure and has different endpoints for different operations


#Run the before running the Application
Create database ems;

#Once the Application is up and running then use these queries to insert user and roles
Insert into ems.user values(1,"$2a$12$vkg2syaPUXDSYpDNJCcZNeutV.qYrAO0IzlUVCyJaumg7TuEUUTZm","ADMIN");
Insert into ems.user values(2,"$2a$12$jLAzB4kODIouGbJ5J.VpWuATdvB7hOzX6p6BEROSmSbdLrfaG8QKa","USER");
Insert into ems.role values(1,"ADMIN");
Insert into ems.role values(2,"USER");
Insert into ems.users_roles values(1,1);
Insert into ems.users_roles values(2,2);

GET: Get all employees http://localhost:8080/ems/getAllEmployee

GET: Get all employees sorted by name http://localhost:8080/ems/sortEmployeeByName

GET: Get all employees, who have this name http://localhost:8080/ems/searchEmployeeByName?name=Amit

DELETE: Delete employee by ID http://localhost:8080/ems/deleteEmployeeById?id=11

POST: Create a new employee http://localhost:8080/ems/createEmployee?firstName=xyz&lastName=ws&email=xyz@ivp.in&id=11

POST: Update an existing employee http://localhost:8080/ems/updateEmployee?id=0&firstName=Amit&lastName=Singh&email=amit@gmail.com


GET: Get all users http://localhost:8080/ems/user/getUserDetails

POST: Create a new user with a role. Also, we can add a new role to a user. http://localhost:8080/ems/user/createUser { "id": 4, "username": "TEMP", "password": "TEMP", "roles": [ {"id": 3, "name": "TEMP"} ] }

GET: Get all roles http://localhost:8080/role/getAllRoles

POST: Create new role http://localhost:8080/role/createNewRole?id=3&name=TEMP
