select Score, (select count(distinct(Score)) from Scores s1 where s1.Score > score) as Rank
from Scores
order by Scores;