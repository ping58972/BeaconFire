-- CREATE DATABASE IF NOT EXISTS hospital; 
USE hospital;
-- drop table if exists ward, staff, doctor, nurse, patient, nurse_ward, doctor_patient;

CREATE TABLE if not exists staff (id int primary key, 
lastname varchar(255), firstname varchar(255), 
address varchar(255), ssn int unique );

create table if not exists doctor(id int primary key,
staff_id int, foreign key(staff_id) 
REFERENCES staff(id));

create table if not exists nurse(id int primary key, 
staff_id int, foreign key(staff_id) 
REFERENCES staff(id));

create table if not exists ward(id int primary key, building varchar(255));


create table if not exists patient(id int primary key,
firstname varchar(255), lastname varchar(255),address varchar(255),
insurance varchar(255), ward_id int, foreign key(ward_id) 
references ward(id));



create table if not exists nurse_ward(
id int primary key,
nurse_id int not null, ward_id int, 
foreign key(nurse_id) references nurse(id), 
foreign key(ward_id) references ward(id));

create table if not exists doctor_patient(id int primary key, 
patient_id int not null, doctor_id int,
 foreign key(doctor_id) references doctor(id), 
 foreign key(patient_id) references patient(id));  