select sp.name from SalesPerson sp
where not exists (
    select 1
    from Orders o
    join Company c
    on o.com_id = c.com_id
    where sp.sales_id = o.sales_id and c.name = 'RED'
    group by sp.sales_id
);