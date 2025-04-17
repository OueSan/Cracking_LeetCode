select distinct(num) as 'ConsecutiveNums' from (
    select num,
    lag(num,1,-1) over() as 'num1',
    lag(num,2,-1) over() as 'num2' from logs
) subquery
where num1=num and num2=num;