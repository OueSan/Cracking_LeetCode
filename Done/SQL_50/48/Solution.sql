# Write your MySQL query statement below
select p.product_name, sum(o.unit) as unit
from Orders o
join Products p
on o.product_id=p.product_id
where '2020-02-01'<=o.order_date and o.order_date<='2020-02-29'
group by p.product_name
having sum(o.unit)>=100