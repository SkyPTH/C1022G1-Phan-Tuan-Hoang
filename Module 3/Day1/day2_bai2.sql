CREATE SCHEMA quan_ly_ban_hang;
USE quan_ly_ban_hang;
CREATE TABLE customer (
    c_id INT PRIMARY KEY,
    c_name VARCHAR(50),
    c_age INT
);
CREATE TABLE `order` (
    o_id INT PRIMARY KEY,
    o_date DATE,
    o_totalprice INT,
    c_id INT,
    FOREIGN KEY (c_id)
        REFERENCES customer (c_id)
);
CREATE TABLE product (
    p_id INT PRIMARY KEY,
    p_name VARCHAR(50),
    p_price INT
);
CREATE TABLE order_detail (
    o_id INT,
    p_id INT,
    o_detail_QTY INT,
    PRIMARY KEY (o_id , p_id),
    FOREIGN KEY (o_id)
        REFERENCES `order` (o_id),
    FOREIGN KEY (p_id)
        REFERENCES product (p_id)
);