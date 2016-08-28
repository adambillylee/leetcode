# Write your MySQL query statement below
select max(t1.Salary) as SecondHighestSalary
from (select e1.Salary, count(e1.id) as higher from Employee e1, Employee e2 where e2.Salary > e1.Salary group by e1.id) t1
where higher = 1;