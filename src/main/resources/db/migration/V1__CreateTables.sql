-- Create tables for data of Students, Teachers, Classes , Grades

CREATE TABLE Students
(
    id bigserial  PRIMARY KEY,
    name varchar(50) ,
    age datetime_interval_code ,
    gender varchar(50)
);

CREATE TABLE Teachers
(
    id bigserial PRIMARY KEY ,
    name varchar(10)
);

CREATE TABLE Classes
(
    id bigserial PRIMARY KEY,
    name varchar(50),
    teacher_id bigserial
);

CREATE TABLE Grades
(
    id bigserial PRIMARY KEY,
    student_id bigserial ,
    class_id bigserial ,
    score decimal(18,1)

);