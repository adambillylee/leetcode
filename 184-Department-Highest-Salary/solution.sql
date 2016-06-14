select D.Name, E.Name, (select DepartmentId, Max(Salary) as max from e group by DepartmentId) T;
from Department d
join Employee e
on e.DepartmentId = d.Id
where e.Salary = T.max;