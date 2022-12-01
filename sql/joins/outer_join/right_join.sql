USE sql_store;

SELECT 
	c.customer_id,
    c.first_name,
    o.order_id
FROM orders o
-- Return all the values from the right table (customers) even if the JOIN condition not sastisfied (some customers do not have an order => order_id = null).
RIGHT JOIN customers c 
	ON o.customer_id = c.customer_id;