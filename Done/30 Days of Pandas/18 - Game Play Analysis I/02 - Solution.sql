SELECT
player_id, min(event_date) as first_login
FROM activity group by player_id
