create database module_3;
use module_3;
create table class ( 
id int,
`name` varchar(50),
primary key (id)
);
create table teacher (
id int,
`name` varchar(50),
age int,
`country` varchar (30),
primary key (id)
);
insert into teacher (id,`name`,age,`country`) values (1,"Thảo",18,"Việt Nam");
select * from teacher;
select id "Id", age "Tuổi", `country` "Nước" from teacher;
