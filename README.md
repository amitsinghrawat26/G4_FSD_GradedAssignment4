#Run the before running the Application
Create database ems;

#Once the Application is up and running then use these queries to insert user and roles
Insert into ems.user values(1,"$2a$12$vkg2syaPUXDSYpDNJCcZNeutV.qYrAO0IzlUVCyJaumg7TuEUUTZm","ADMIN");
Insert into ems.user values(2,"$2a$12$jLAzB4kODIouGbJ5J.VpWuATdvB7hOzX6p6BEROSmSbdLrfaG8QKa","USER");
Insert into ems.role values(1,"ADMIN");
Insert into ems.role values(2,"USER");
Insert into ems.users_roles values(1,1);
Insert into ems.users_roles values(2,2);
