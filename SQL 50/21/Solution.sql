# Write your MySQL query statement below
select round(((count(case when a = 'immediate' then 1 end ))/count(a))*100,2) as immediate_percentage from
#select * from
(select customer_id,min(order_date),min(customer_pref_delivery_date), (case when min(order_date) = min(customer_pref_delivery_date) then 'immediate' else 'scheduled' end) as a
from Delivery
group by 1) 