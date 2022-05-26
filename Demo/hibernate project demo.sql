create database if not exists project_demo;
use project_demo;

drop table if exists Question;

create table if not exists Question
(
    id 				int auto_increment primary key,
    description  	varchar(250),
    is_active   	boolean
);

truncate table question;

insert into question values 
	(1, "fav color?", true), 
    (2, "fav place?", false);
    
select * from question;

