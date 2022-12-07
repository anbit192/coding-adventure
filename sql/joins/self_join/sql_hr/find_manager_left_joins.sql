USE sql_hr;

SELECT 
	e.employee_id,
	CONCAT(e.first_name, ' ', e.last_name ) AS employee_name,
    CONCAT(m.first_name, ' ', m.last_name ) AS manager_name
FROM employees e
LEFT JOIN employees m 
	ON e.reports_to = m.employee_id