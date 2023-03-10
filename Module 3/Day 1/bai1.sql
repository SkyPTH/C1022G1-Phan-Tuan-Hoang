create database book_management;
use book_management;
create table book (
id int primary key auto_increment,
name varchar(50),
page_size int,
author varchar(50)
);
insert into book(name,page_size,author) values ('Toán', 45, 'Nguyễn Thái Học'),
('Văn',34,'Trần Minh Hoàng'),
('Sử',56,'Dương Trung Quốc'),
('Địa',76,'Lê Văn Hiến'),
('Hóa',32,'Hà Văn Minh');
select * from book;
update book set page_size=50 where name='Sử';
delete from book where id=5;
drop table book;
drop database book_management;