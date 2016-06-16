# Write your MySQL query statement below
Delete p1
from Person p1, Person p2
and p1.Email is p2.Email
and p1.Id is not p2.Id;