# Write your MySQL query statement below
SELECT 
    res.Department,
    res.Employee,
    res.salary
FROM (
    SELECT 
        b.name AS Department,
        a.name AS Employee,
        a.salary,
        DENSE_RANK() OVER (
            PARTITION BY a.departmentid 
            ORDER BY a.salary DESC
        ) AS rnk
    FROM employee a 
    JOIN Department b 
    ON  a.departmentid = b.id
) res
WHERE res.rnk <= 3;