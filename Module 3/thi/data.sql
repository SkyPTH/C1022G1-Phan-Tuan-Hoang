drop database library2;
create database library2;
use library2;
create table category (
category_id int primary key auto_increment,
category_name varchar(255)
);
create table book (
 book_id int primary key auto_increment,
 book_name varchar(255),
 page_size int,
 category_id int,
foreign key (category_id) references category(category_id));
insert into category(category_name) values ("Tự nhiên"),("Xã hội");
select * from category;
insert into book(book_name,page_size,category_id) values ("Hoàng 1",11,1),("Hoàng 2",22,2);
select * from book;
