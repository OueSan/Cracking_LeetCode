SELECT
    s.score,
    DENSE_RANK() OVER(
      ORDER BY s.score DESC
    ) 'rank'
FROM score s;
