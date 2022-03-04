USE quan_ly_ban_hang;

INSERT INTO Customer(customer_id, customer_name, customer_age) 
VALUES (1, "Minh Quan", 10), (2, "Ngoc Oanh", 20), (3, "Hong Ha", 50);

INSERT INTO `order`(order_id, customer_id, order_date, order_total_price) 
VALUES (1, 1, "2006-03-21", null), (2, 2, "2006-03-23", null), (3, 1, "2006-03-13", null);


INSERT INTO product(product_id, product_name, product_price) 
VALUES (1, "May giat", 3), (2, "Tu lanh", 5), (3, "Dieu hoa", 7), (4, "Quat", 1), (5, "Bep dien", 2);


INSERT INTO Order_Detail(order_id, product_id, order_qty) 
VALUES (1, 1, 3), (1, 3, 7), (1, 4, 2), (2, 1, 1), (3, 1, 8), (2, 5, 4), (2, 3, 3);