use quiz;

drop table if exists Permission;
create table Permission (permission_id int auto_increment primary key,
name varchar(50) not null);
insert into Permission(permission_id, name) values(1, "read"),(2, "write"),(3, "update"),(4, "delete");
select * from Permission;
-- SELECT * FROM quiz.User;
drop table if exists UserPermission;
create table UserPermission(id int auto_increment primary key,
user_id int not null, permission_id int not null,
constraint `fk_UserPermission_User` foreign key `User_fk`(`user_id`) 
references `User`(`user_id`),
constraint `fk_UserPermission_Permission` foreign key `Permission_fk`(`permission_id`)
references `Permission`(`permission_id`) );
insert into UserPermission(user_id, permission_id) values
(1, 1), (1, 2),(1,3),(1,4),
(2, 1), (2, 2),(2,3),
(37, 1), (37, 2),
(38, 1),
(34, 1),
(35,1),
(36, 1);

select * from UserPermission;




