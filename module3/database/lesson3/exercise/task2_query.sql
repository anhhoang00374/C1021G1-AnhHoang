use quan_ly_ban_hang;

SELECT order_id,order_date,order_total_price 
 FROM quan_ly_ban_hang.`order`;
 
 SELECT customer.customer_name, GROUP_CONCAT(product.product_name) AS "list products" 
 FROM customer 
 inner join `order` on customer.customer_id = order.customer_id
 inner join order_detail on order.order_id = order_detail.order_id
 inner join product on product.product_id = order_detail.product_id
 GROUP BY customer.customer_name;


SELECT * FROM customer
WHERE customer.customer_name NOT IN (
SELECT customer.customer_name
 FROM customer 
 inner join `order` on customer.customer_id = order.customer_id
);

 SELECT order_detail.order_id,`order`.order_date,SUM(order_detail.order_QTY * product.product_price ) AS "total price"
 FROM customer INNER JOIN `order` on customer.customer_ID = `order`.customer_ID 
 INNER JOIN order_detail on order_detail.order_id = `order`.order_id 
 INNER JOIN product on product.product_id = order_detail.product_id 
 GROUP BY order_detail.order_id;