# Write your MySQL query statement below

select d.name Department, e.name Employee, e.salary Salary
from Employee e join Department d
on e.departmentId = d.id
where e.salary =(select max(salary) from employee where departmentId= e.departmentId)

-- select d.

-- select departmentId ,max(salary) Salary from employee group by departmentId