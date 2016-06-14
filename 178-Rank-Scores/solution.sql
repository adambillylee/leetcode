select Score, (select count(distinct(Score)) from Scores s1 where s1.Score >= Score) as Rank
from Scores
order by Scores;