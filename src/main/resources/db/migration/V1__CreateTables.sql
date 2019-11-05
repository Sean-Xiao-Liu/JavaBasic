-- Create tables for data of Students, Teachers, Classes , Grades

CREATE TABLE Students
(
    id bigint  PRIMARY KEY,
    name varchar(50) ,
    age DATE ,
    gender varchar(50)
);

CREATE TABLE Teachers
(
    id bigint PRIMARY KEY ,
    name varchar(10)
);

CREATE TABLE Classes
(
    id bigint PRIMARY KEY,
    name varchar(50),
    teacher_id bigint
);

CREATE TABLE Grades
(
    id bigint PRIMARY KEY,
    student_id bigint ,
    class_id bigint ,
    score decimal(18,1)

);