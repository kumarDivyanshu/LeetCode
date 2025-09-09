# Write your MySQL query statement below

-- select d.name Department, e.name Employee, e.salary Salary
-- from Employee e join Department d
-- on e.departmentId = d.id
-- where e.salary =(select max(salary) from employee where departmentId= e.departmentId)

-- select d.

-- select departmentId ,max(salary) Salary from employee group by departmentId

select d.name as Department,e.name as Employee,e.salary as Salary from 
employee e 
join 
department d 
on e.departmentId=d.id 
where (e.departmentid,e.salary) in 
(select departmentid,max(salary) from employee group by departmentId);