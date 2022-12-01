USE sql_hr;

SELECT 
	e.first_name AS employee_firstName,
	e.last_name AS employee_lastName,
    e.reports_to AS manager_id,
    m.first_name AS manager_firstName,
    m.last_name AS manager_lastName
FROM employees e
INNER JOIN employees m 
	ON e.reports_to = m.employee_id;