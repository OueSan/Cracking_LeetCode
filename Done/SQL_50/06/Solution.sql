# Write your MySQL query statement below
select b.unique_id,a.name #here i put "alias" for the colums i want to join as b. and a. 
from Employees as a 
left join EmployeeUNI as b #can be right join whatever
on a.id = b.id #if the 2 colums are equal, they'll combine, intead they'll return null 