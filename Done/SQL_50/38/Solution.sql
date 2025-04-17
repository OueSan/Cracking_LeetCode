(select name as results 
from Users u join MovieRating mr on u.user_id = mr.user_id 
group by u.name
order by count(*) desc, name limit 1)

union all

(select m.title as results 
from Movies m join MovieRating mr on m.movie_id = mr.movie_id
where year(mr.created_at) = '2020' and month(mr.created_at) = '02'
group by title
order by avg(rating) desc, title limit 1)