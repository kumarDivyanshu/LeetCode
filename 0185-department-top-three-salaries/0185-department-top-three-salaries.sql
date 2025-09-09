# Write your MySQL query statement below

-- select

select d.name Department , e1.name Employee , e1.salary Salary
from employee e1 
join department d
on e1.departmentId = d.id
where 3 > (select count(distinct salary) from employee e2 where e2.salary > e1.salary and
e2.departmentId = e1.departmentId)

-- limit 3;