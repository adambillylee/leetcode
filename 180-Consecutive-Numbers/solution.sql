# Write your MySQL query statement below
select Num
from Logs
where count(Num) > 3
group by Id;