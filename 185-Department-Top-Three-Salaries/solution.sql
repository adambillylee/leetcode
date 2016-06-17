# Write your MySQL query statement below
select d.Name as Department, e1.Name as Employee, e1.Salary as Salary
from Employee e1
join Department d
on e1.departmentId = d.Id
where (select (count(distinct(e2.Salary)))
        from Employee e2
        where e2.Salary > e1.Salary
        and e2.departmentId = e1.departmentId
) < 3;