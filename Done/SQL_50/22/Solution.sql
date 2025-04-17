# Write your MySQL query statement below
SELECT 
    ROUND(
        SUM(CASE WHEN DATEDIFF(event_date, min_event_date) = 1 THEN 1 ELSE 0 END) 
        / COUNT(DISTINCT player_id),
        2
    ) AS fraction
FROM (
    SELECT 
        player_id,
        event_date,
        MIN(event_date) OVER (PARTITION BY player_id) AS min_event_date
    FROM activity
) AS activity_with_min_date