# Write your MySQL query statement below
select s1.Score, s2.t
from (select distinct(score) from Scores ) s1
where select count(*) from (select distinct(Score) from Scores s2) where s1.Score > s2.Score
