# Write your MySQL query statement below
select Firstname, LastName, City, State
from Person p
left join Address a
where p.PersonId = a.PersonId;