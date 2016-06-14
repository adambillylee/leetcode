select d.Name, e.Name
from Department d, (select Max(Salary) as maxS from Employee group by DepartmentId) T
join Employee e
on e.DepartmentId = d.Id
where e.Salary = T.maxS;