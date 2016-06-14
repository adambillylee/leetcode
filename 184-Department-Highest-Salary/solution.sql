# Write your MySQL query statement below
select Department.name, Employee.name, Max(Salary)
from Employee e
join Department d
where e.DepartmentId = d.id
group by Department.id;

