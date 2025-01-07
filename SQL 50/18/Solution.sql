SELECT
    contest_id,round(count(user_id)*100/(select count(user_id) from Users),2) percentage
FROM
    Register a 
GROUP BY
    contest_id
ORDER BY
    percentage desc,contest_id 