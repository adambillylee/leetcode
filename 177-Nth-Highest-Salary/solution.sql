CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  DECLARE M INT;
  SET M = N-1;
  RETURN (
      # Write your MySQL query statement below.
      select Max(Salary)
      from Employee
      order by Salary
      limit M, 1;
  );
END