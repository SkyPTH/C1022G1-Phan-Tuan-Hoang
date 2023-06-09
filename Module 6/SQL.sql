CREATE TABLE Customer (
	id_customer int auto_increment primary key,
    name varchar(255),
    email varchar(255),
    phone varchar(13),
    address varchar(255)
);
CREATE TABLE Product (
	id_product int auto_increment primary key,
    name varchar(255),
    password varchar(255),
    price int,
    description text
)
;
CREATE TABLE Account (
	id_account int auto_increment primary key,
    name varchar(255),
    password varchar(255),
    role int,
    description text
);
CREATE TABLE `Order` (
	id_order int auto_increment primary key,
    customerID int,
    foreign key (customerID) references customer(id_customer),
    order_date date,
    total_price int
);