SELECT
    A1.sell_date,
    COUNT(DISTINCT product) AS num_sold,
    ARRAY_TO_STRING(
        ARRAY(
            SELECT
                DISTINCT product
            FROM
                Activities AS A2
            WHERE
                A1.sell_date = A2.sell_date
            ORDER BY
                product
        ),','
    ) AS products
FROM
    Activities AS A1
GROUP BY
    sell_date
ORDER BY
    sell_date




SELECT
    sell_date,
    COUNT(DISTINCT product) AS num_sold,
    ARRAY_TO_STRING(ARRAY_AGG(DISTINCT product),',') AS products
FROM
    Activities
GROUP BY
    sell_date
ORDER BY
    sell_date