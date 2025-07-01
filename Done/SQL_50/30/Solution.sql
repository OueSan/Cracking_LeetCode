# Write your MySQL query statement below
SELECT 
    e.employee_id, 
    e.name,
    COUNT(e2.employee_id) AS reports_count,
    ROUND(AVG(e2.age)) AS average_age
FROM 
    Employees e
LEFT JOIN 
    Employees e2 ON e.employee_id = e2.reports_to
GROUP BY 
    e.employee_id, e.name
HAVING 
    COUNT(e2.employee_id) > 0
ORDER BY 
    e.employee_id ASC;