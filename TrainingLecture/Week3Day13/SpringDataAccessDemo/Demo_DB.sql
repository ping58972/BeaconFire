drop table if exists trainee;
create table trainee (
	id int primary key auto_increment,
    firstName text not null,
    lastName text not null,
    phoneNumber text not null,
    ssn text not null
);

drop table if exists trainer;
create table trainer (
	id int primary key auto_increment,
    firstName text not null,
    lastName text not null,
    phoneNumber text not null,
    email text not null
);

drop table if exists trainingSession;
create table trainingSession (
	id int primary key auto_increment,
    sessionDate text not null,
    topic text not null,
    trainer int not null,
    foreign key (trainer) references trainer(id)
);

insert into trainer (firstName, lastName, phoneNumber, email) values
("Tracy", "Lan", "2132387153", "clan@beaconfireinc.com"),
("Oliver", "Li", "9492026942", "bli@beaconfireinc.com");

insert into trainingSession (sessionDate, topic, trainer) values 
("Week 1 Day 1", "Intro", 2),
("Week 1 Day 2", "Java SE", 2),
("Week 1 Day 3", "OOP", 1),
("Week 1 Day 4", "Collections", 2),
("Week 1 Day 5", "IO/Exception", 1),
("Week 2 Day 2", "Thread", 2);

insert into trainee (firstName, lastName, phoneNumber, ssn) values 
("John", "Doe", "1234567890", "123456789"),
("Jane", "Doe", "0987654321", "987654321"),
("Wendy", "Burger", "4561237890", "987123654"),
("Papa", "John", "3217894650", "321654987");

delimiter //
create procedure getAllTrainee()
begin

select * from trainee;

end //
delimiter ;

drop table if exists Bank;
create table Bank (
	id int primary key auto_increment,
    accountName text not null,
    balance int not null
);

insert into Bank (accountName, balance) values 
("Oliver", 0),
("Tracy", 50);

