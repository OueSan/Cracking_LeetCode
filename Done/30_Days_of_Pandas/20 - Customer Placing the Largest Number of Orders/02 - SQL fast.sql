select a.customer_number from(
select count(order_number) as orn,customer_number from Orders
group by customer_number) a
order by orn desc
limit 1


