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
insert into customer values (1,'Minh Quan', 10),(2,'Ngoc Oanh', 20),(3,'Hong Ha', 50);
insert into `order` (o_id, c_id , o_date, o_totalprice) values (1,1,'2006/3/21', null),(2,2,'2006/3/23', null),(3,3,'2006/3/16', null);
insert into product (p_id,p_name, p_price) values (1,'May Giat', 3),(2,'Tu Lanh', 5),(3,'Dieu Hoa', 7),(4,'Quat', 1),(5,'Bep Dien', 2);
insert into order_detail (o_id, p_id, o_detail_QTY) values (1, 1, 3),(1, 3, 7),(1, 4, 2),(2, 1, 1),(3, 1, 8),(2, 5, 4),(2, 3, 3);
-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
SELECT 
    o_id, o_date, o_totalprice
FROM
    `order`nh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách 
select c_name as "Khách hàng", p_name as "Sản phẩm" from order_detail inner join `order` on order_detail.o_id= `order`.o_id INNER JOIN
    product ON order_detail.p_id = product.p_id
        INNER JOIN
    customer ON customer.c_id = `order`.c_id;
    -- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào 
    SELECT 
    customer.c_name
FROM
    customer
        LEFT JOIN
    `order` ON customer.c_id = `order`.c_id
WHERE
    `order`.c_id IS NULL;
    -- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. Giá bán của từng loại được tính = odQTY*pPrice)
SELECT 
    `order`.o_id,
    `order`.o_date,
    order_detail.o_detail_QTY * product.p_price AS o_totalprice
FROM
    order_detail
        INNER JOIN
    `order` ON order_detail.o_id = `order`.o_id
        INNER JOIN
    product ON order_detail.p_id = product.p_id;