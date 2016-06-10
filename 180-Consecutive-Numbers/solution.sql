# Write your MySQL query statement below
select distinct(Num)
from Logs l1, Logs l2, Logs l3
where l1.id - l2.id = 1 and l2.id - l3.id = 1;