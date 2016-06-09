# Write your MySQL query statement below
select Num
from Logs
having count(Num) > 3
group by Id;