select d.`Name`, e.`Name`, (select DepartmentId, Max(Salary) as max from Employee group by DepartmentId) T
from Department d
join Employee e
on Employee.DepartmentId = Department.Id
where Employee.Salary = T.max and
Employee.DepartmentId = T.DepartmentId and
Department.id = T.DepartmentId;