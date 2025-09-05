# Write your MySQL query statement below
select 
(select salary from Employee
group by salary
order by salary desc
limit 1
offset 1)
as SecondHighestSalary;
