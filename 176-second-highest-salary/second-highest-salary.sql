# Write your MySQL query statement below
select 
(SELECT distinct salary from Employee ORDER BY salary DESC LIMIT 1 OFFSET 1) AS SecondHighestSalary;
