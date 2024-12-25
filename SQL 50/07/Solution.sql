SELECT P.product_name, S.year, S.price
FROM SALES AS S, PRODUCT AS P
WHERE S.product_id=P.product_id