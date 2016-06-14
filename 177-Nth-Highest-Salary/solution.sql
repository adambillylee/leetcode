CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  DECLARE M INT;
  SET M = N-1;
  RETURN (
      # Write your MySQL query statement below.
      select distinct(Salary)
      from Employee e1
      where select count(Salary) from 
        (select distinct(Salary) from Employee e2 where e2.Salary > e1.Salary) = N-1;
  );
END