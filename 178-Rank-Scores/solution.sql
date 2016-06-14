select Score, (select count(distinct(Score)) from Scores s1 where Score >= s.Score) as Rank
from Scores s
order by Score desc;