select d.Name, e.Name, (select Max(Salary) as maxS from Employee group by DepartmentId) T
from Department d
join Employee e
on e.DepartmentId = d.Id
where e.Salary = T.maxS;