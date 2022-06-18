-- create database if not exists pet_service;
use pet_service;
-- drop table PET_OWNER, PET, OWNER, VISIT, PROCEDURE_TABLE;
-- CREATE ALL TABLE.
create table if not exists OWNER(ID int primary key, FIRSTNAME varchar(255) NOT NULL, LASTNAME varchar(255) not null);

create table if not exists PROCEDURE_TABLE(ID int primary key, PR0C_DESCRIBE varchar(255) not null);

create table if not exists PET(ID int primary key, NAME varchar(255), TYPE varchar(55), AGE int);

create table if not exists PET_OWNER(PET_ID int primary key, OWNER_ID int, foreign key(PET_ID) references PET(ID), 
foreign key(OWNER_ID) references OWNER(ID));

create table if not exists VISIT(ID int primary key, PET_ID int not null, PROCEDURE_ID int, DATE varchar(255), 
foreign key(PET_ID) references PET(ID), foreign key(PROCEDURE_ID) references PROCEDURE_TABLE(ID));

--  INSERT TO EACH TABLE
insert into OWNER(ID, FIRSTNAME, LASTNAME)VALUES(1, "SAM","COOK"),(2, "TERRY","KIM");

insert into PET(ID, NAME, TYPE, AGE)VALUES(246, "ROVER", "DOG", 12),
(298, "SPOT", "DOG", 2),( 341, "MORRIS", "CAT", 4),( 519, "TWEEDY", "BIRD", 2);

insert into PET_OWNER(PET_ID, OWNER_ID) values(246, 1), (298, 2), (341, 1), (519, 2);

insert into PROCEDURE_TABLE(ID, PR0C_DESCRIBE) values(1, "RABIES VACCINATION"), 
(10, "EXAMINE and TREAT WOUND" ), (5, "HEART WORM TEST"), (8, "TETANUS VACCINATION"), 
(20, "ANNUAL CHECK UP"), (12, "EYE WASH");

insert into VISIT(ID, PET_ID, PROCEDURE_ID, DATE) values(1, 246, 1, "JAN 13/2002"), (2, 246, 10, "MAR 27/2002")
, (3, 246, 5, "APR 02/2002"), (4, 298, 8, "JAN 21/2002"), (5, 298, 5, "MAR 10/2002"), (6, 341, 1, "JAN 23/2001")
,(7, 341, 1, "JAN 13/2002"), (8, 519, 20, "APR 30/2002"), (9, 519, 12, "APR 30/2002");

-- delete all Owners whose first name is ‘Sam’
delete from OWNER where OWNER.FIRSTNAME = "SAM";








