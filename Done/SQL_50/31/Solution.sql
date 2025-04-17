# Write your MySQL query statement below
select employee_id, department_id
from Employee where primary_flag = 'Y' or employee_id in
(select employee_id from Employee 
group by 1
having count(employee_id) = 1);