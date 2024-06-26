CREATE DATABASE STUDENT;
USE STUDENT;
CREATE TABLE STUDENT.Address_01 (
    id INT PRIMARY KEY,
    firstname VARCHAR(50),
    lastname VARCHAR(50),
    street VARCHAR(100),
    city VARCHAR(50)
);
SELECT * FROM STUDENT.Address_01;
INSERT INTO STUDENT.Address_01 (id, firstname, lastname, street, city)
VALUES (1, 'John', 'Smith', '123 Main St', 'New York City'),
       (2, 'Jane', 'Doe', '456 Elm St', 'Los Angeles'),
       (3, 'Michael', 'Johnson', '789 Oak Ave', 'Chicago'),
       (4, 'Emily', 'Davis', '1010 Pine St', 'Houston'),
       (5, 'David', 'Wilson', '1212 Maple St', 'Miami'),
       (6, 'Sarah', 'Brown', '1414 Cherry St', 'Seattle'),
       (7, 'James', 'Garcia', '1616 Cedar St', 'Atlanta'),
       (8, 'Jessica', 'Rodriguez', '1818 Birch St', 'Dallas'),
       (9, 'Matthew', 'Lee', '2020 Spruce St', 'San Francisco'),
       (10, 'Olivia', 'Martinez', '2222 Walnut St', 'Boston');
