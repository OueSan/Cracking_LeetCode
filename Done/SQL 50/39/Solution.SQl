with aggregate_table as(
    select visited_on,
    sum(amount) as amount
    from customer
    group by visited_on
) 
,ranked_table as (
    Select visited_on,
    sum(amount) over (order by visited_on 
    rows between 6 preceding  and current row ) as cumulative_amount,
    ROW_NUMBER() over(order by visited_on) as rowno,
    Round(avg(amount) over (order by visited_on 
    rows between 6 preceding  and current row ),2) as average_amount from aggregate_table
    group by visited_on)
select visited_on,
    cumulative_amount as amount,
    average_amount
    from ranked_table
    where rowno >6



-- select distinct visited_on,
-- sum(amount) over w as amount,
-- round((sum(amount)over w)/7,2)as average_amount
-- from customer
-- Window w as (
--     order by visited_on 
--     range between interval 6 day preceding and current row
-- ) limit 6 ,999
