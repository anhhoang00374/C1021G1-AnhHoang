-- CREATE DATABASE quan_ly_ban_hang;
-- use quan_ly_ban_hang;

-- CREATE TABLE customer(
-- customer_id INT PRIMARY KEY,
-- customer_name VARCHAR(255),
-- customer_age INT
-- );

-- CREATE TABLE `order`(
-- order_id INT PRIMARY KEY AUTO_INCREMENT,
-- customer_id int,
-- order_date DATE,
-- order_total_price int,
-- FOREIGN KEY (customer_id) REFERENCES customer (customer_id)
-- ); 

-- CREATE TABLE product(
-- product_id INT PRIMARY KEY,
-- product_name VARCHAR(255),
-- product_price VARCHAR(255)
-- );

CREATE TABLE order_detail(
order_id INT,
product_id INT,
order_qty VARCHAR(255),
PRIMARY KEY (order_id,product_id),
FOREIGN KEY (order_id) REFERENCES `order`(order_id),
FOREIGN KEY (product_id) REFERENCES product(product_id)
);