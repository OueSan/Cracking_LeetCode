CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
   # Write your MySQL query statement below.
   with CTE as (
        Select salary, row_number() over (order by salary desc) as rnk from Employee group by salary
    )
    Select salary from CTE where rnk = N
  );
END