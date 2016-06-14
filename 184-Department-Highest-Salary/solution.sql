# Write your MySQL query statement below
select Department.Name, Employee.Name, Max(Salary)
from Employee e
join Department d
where e.DepartmentId = d.id
group by Department.id;

