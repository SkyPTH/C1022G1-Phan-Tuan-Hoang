drop database riot_shop;
create database riot_shop;
use riot_shop;
create table `rank`(
id_rank int primary key auto_increment,
name_rank varchar(255)
);
create table product(
id_product int primary key auto_increment,
name_product varchar(255),
price int,
id_rank int ,
foreign key (id_rank) references `rank`(id_rank) 
);
create table account_user(
id_account int auto_increment primary key,
name_account varchar(255),
password_account varchar(255)
);
create table roles(
id_role int auto_increment primary key,
name_role varchar(255)
);
create table role_account(
id int auto_increment primary key,
id_account int,
id_role int,
foreign key (id_account) references account_user(id_account),
foreign key (id_role) references roles(id_role)
);
create table type_customer(
id_type int auto_increment primary key,
name_type varchar(255)
);
create table customer(
id_customer int auto_increment primary key,
name_type varchar(255),
mail varchar(255),
id_type int,
id_account int,
foreign key (id_account) references account_user(id_account),
foreign key (id_type) references type_customer(id_type)
);
create table `order`(
id_order int auto_increment primary key,
status_order bit(1),
id_customer int,
foreign key (id_customer) references customer(id_customer)
);
create table order_detail(
id_detail int auto_increment primary key,
id_order int,
id_product int,
foreign key (id_order) references `order`(id_customer),
foreign key (id_product) references product(id_product)
)