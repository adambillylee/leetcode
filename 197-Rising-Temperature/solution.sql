# Write your MySQL query statement below
select w2.Id
from Weather w1, Weather w2
where `w2.Date` - `w1.Date` = 1
and w2.Temperature > w1.Temperature