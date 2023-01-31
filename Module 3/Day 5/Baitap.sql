DROP SCHEMA demo;
CREATE SCHEMA demo;
USE demo;
CREATE TABLE Product (
    id INT NOT NULL PRIMARY KEY,
    product_Code VARCHAR(50),
    product_Name VARCHAR(50),
    product_Price INT,
    product_Amount INT,
    product_Description VARCHAR(50),
    product_Status VARCHAR(50)
);
INSERT INTO Product (id,product_Code, product_Name,product_Price,product_Amount,product_Description,product_Status) 
VALUES
 (1,'a','xe hơi','1000',3,'4 bánh','đang khuyến mãi'),
 (2,'b','xe hơi','300',5,'2 bánh','hết khuyến mãi')
;
SELECT * FROM Product;
CREATE INDEX unique_index_products ON Product(product_Code);
CREATE INDEX composite_index_products ON Product(product_Name,product_Price);
EXPLAIN SELECT * FROM Product;
EXPLAIN SELECT * FROM Product
WHERE id = 1;
CREATE VIEW view_product (codee , namess , price , statuss) AS
SELECT product_code, product_name, product_price, product_status
FROM product;
UPDATE view_product 
SET namess = 'Xe tải'
WHERE codee = 'a';
select * from view_product;
DROP VIEW view_product;
delimiter //
CREATE PROCEDURE display_product()
BEGIN
SELECT * FROM product;
END;
// delimiter ;
CALL display_product;
delimiter //
CREATE PROCEDURE add_product(id INT, product_code VARCHAR(50), product_name VARCHAR(50), product_price INT, product_amount INT, product_description VARCHAR(50)
, product_status VARCHAR(45))
BEGIN
INSERT INTO Product VALUES 
    (id,product_code, product_name, product_price, product_amount, product_description, product_status);
    END;
// delimiter ;
CALL add_product(4,'d','xe đạp', 100, 7 , 'mới', 'bảo hành');	
delimiter // 
CREATE PROCEDURE edit_by_id(
    product_code VARCHAR(50),
	product_name VARCHAR(50),
	product_price INT,
	product_amount INT,
	product_description VARCHAR(50),
	product_status VARCHAR(50))
BEGIN
	UPDATE Product
    SET 
    Product.product_code = product_code,
    Product.product_name = product_name,
    Product.product_price = product_price,
    Product.product_amount= product_amount,
    Product.product_description = product_description,
    Product.product_status = product_status
    WHERE product.id = id;
END //
delimiter ;
CALL edit_by_id ('x','xe xích lô', 200 , 7 ,'xích lô cũ','hư hỏng');

delimiter //
CREATE PROCEDURE delete_by_id (id INT) 
BEGIN
	DELETE FROM Product
    WHERE Product.id = id;
END //
delimiter ;
CALL delete_by_id(1);