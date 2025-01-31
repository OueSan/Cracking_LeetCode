# Write your MySQL query statement below
with uniquelocations as (
    select lat,lon from insurance 
    group by lat,lon
    having count(*)=1
),
duplicatetiv2015 as (
select tiv_2015 from insurance 
group by tiv_2015
having count(*)>1
)
select ROUND(SUM(tiv_2016),2) as tiv_2016 from Insurance
where (lat,lon) in (select lat,lon from uniquelocations) and
tiv_2015 in (select tiv_2015 from duplicatetiv2015 )