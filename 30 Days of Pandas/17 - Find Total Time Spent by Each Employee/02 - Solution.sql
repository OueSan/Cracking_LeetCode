select event_day as day, emp_id, SUM(out_time - in_time) as total_time
from Employees group by emp_id, event_day;


or 

SELECT
    DISTINCT event_day AS day,
    emp_id,
    SUM(out_time - in_time) OVER(PARTITION BY emp_id, event_day) AS total_time
FROM Employees