delete p1 from person p1
inner join
(select email, min(id) as min_id
from
person p
group by email) p2
on
p1.email = p2.email and p1.id != p2.min_id;