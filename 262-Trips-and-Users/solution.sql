select t.Request_at as Day, round(( sum(if (status != 'Completed', 1, 0))/ count(t.Id)),2) as "Cancellation Rate"
    from Trips t
    left join Users u
    on t.Client_id = u.Users_Id
    where Request_at >= "2013-10-01" and Request_at <= "2013-10-03"
    and u.Banned = "No"
    group by Request_at;