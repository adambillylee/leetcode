# Write your MySQL query statement below
select d.Name as Department, e1.Name as Employee, s1.Salary as Salary
from Employee e1
join Department d
on e1.departmentId = d.Id
where (select (count(distinct(Salary)))
        from Employee e2
        where e2.Salary > e2.Salary
        and e2.departmentId = e1.departmentId
) < 3;