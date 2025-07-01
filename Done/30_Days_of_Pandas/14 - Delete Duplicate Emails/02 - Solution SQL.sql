With Dupli as(
    Select min(id) as MinId
    from Person
    group by email 
)

Delete from Person
where id not in (Select MinId from Dupli);