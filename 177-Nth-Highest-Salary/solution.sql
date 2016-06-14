CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  DECLARE M INT;
  SET M = N-1;
  RETURN (
      # Write your MySQL query statement below.
      select e1.Salary
      from (select distinct(Salary) from Employee) e1
      where (select count(*) from (select distinct(Salary) from Employee) e2 
        where e2.Salary > e1.Salary) = N-1
      limit 1
  );
END