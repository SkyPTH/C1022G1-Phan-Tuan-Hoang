drop schema library;
create database library;
use library;
create table author (
author_id int primary key auto_increment,
`name` varchar(50)
);
create table category (
category_id int primary key auto_increment,
`name` varchar(50)
);
create table book (
book_id int primary key auto_increment,
`name` varchar(50),
tittle varchar (50),
page_size int,
category_id int,
author_id int,
foreign key (category_id) references category(category_id),
foreign key (author_id) references author(author_id)
);
create table student (
student_id int primary key auto_increment,
class_name varchar(50),
`name` varchar(50),
birthday date 
);
create table borrow (
borrow_day date ,
return_day date,
 borrow_id int primary key auto_increment,
 student_id int,
 book_id int,
 foreign key (student_id) references student(student_id),
 foreign key (book_id) references book(book_id)
);