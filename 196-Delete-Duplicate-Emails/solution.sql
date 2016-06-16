# Write your MySQL query statement below
Delete From p1
where Person p1, Person p2
where p1.Email is p2.Email
and p1.Id is not p2.Id;