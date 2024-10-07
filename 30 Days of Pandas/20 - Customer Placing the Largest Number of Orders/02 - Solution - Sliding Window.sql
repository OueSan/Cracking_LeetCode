-- The rank is generated on the count of order placed for each user, and the user with the highset number of orders placed will rank 1. 
WITH temp AS(
    SELECT customer_number,
        RANK() OVER(ORDER BY COUNT(order_number) DESC) AS rnk
    FROM Orders
    GROUP BY customer_number)

SELECT customer_number
FROM temp
WHERE rnk = 1; 