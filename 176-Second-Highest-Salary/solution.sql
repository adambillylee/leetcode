# Write your MySQL query statement below
select max(t1.Salary) as SecondHighestSalary
from (select e1.Salary from Employee e1 join Employee e2 on e1.Salary < e2.Salary group by e1.Id having count(e2.Id) = 1) t1;