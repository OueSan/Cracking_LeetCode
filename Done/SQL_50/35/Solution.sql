# Write your MySQL query statement below
WITH CumulativeSum AS (
    SELECT person_name, SUM(weight) OVER (ORDER BY turn) AS cumulative_sum
    FROM Queue
)
SELECT person_name
FROM CumulativeSum
WHERE cumulative_sum <= 1000
ORDER BY cumulative_sum DESC
LIMIT 1;