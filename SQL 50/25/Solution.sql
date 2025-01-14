SELECT product_id, first_year, quantity, price
FROM (
    SELECT 
        product_id,
        year AS first_year,
        quantity,
        price,
        RANK() OVER (PARTITION BY product_id ORDER BY year) AS row_num
    FROM Sales
) subquery
WHERE row_num = 1