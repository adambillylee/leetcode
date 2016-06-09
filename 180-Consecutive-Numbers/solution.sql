# Write your MySQL query statement below
select count(Num) as ConsecutiveNums
from Logs
group by Id, Num
having ConsecutiveNums >= 3;