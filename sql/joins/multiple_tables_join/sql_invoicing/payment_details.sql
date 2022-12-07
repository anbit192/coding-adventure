USE sql_invoicing;

SELECT p.invoice_id, c.name AS client_name, p.amount, pm.name AS payment_method, p.date
FROM payments p 
INNER JOIN clients c 
	-- ON p.client_id = c.client_id
    USING (client_id)
INNER JOIN payment_methods pm 
	ON p.payment_method = pm.payment_method_id;