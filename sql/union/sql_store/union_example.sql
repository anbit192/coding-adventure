USE sql_store;

SELECT 
	o.order_id,
    o.order_date,
    'ACTIVE' AS status
FROM orders o 
WHERE o.order_date >= '2019-01-01'
UNION
SELECT 
	o.order_id,
    o.order_date,
    'ARCHIVE' AS status
FROM orders o 
WHERE o.order_date < '2019-01-01'
	