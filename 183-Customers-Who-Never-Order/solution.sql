# Write your MySQL query statement below
select Name as Customers
from Customers c
where c.id not in (select c.id from Customers c join Orders o on c.Id = o.CustomerId);