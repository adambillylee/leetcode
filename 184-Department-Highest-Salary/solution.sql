select d.Name as Department, e.Name as Employee, e.Salary
from Department d, (select DepartmentId, Max(Salary) as maxS from Employee group by DepartmentId) T, Employee e
where e.DepartmentId = d.Id
and e.DepartmentId = T.DepartmentId
and e.Salary = T.maxS;