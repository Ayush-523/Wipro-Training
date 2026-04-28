-- to list out all the databases we have 
show databases;

-- It is a collection of multiple tables of its similar type of database
create database LMS;
-- to get inside the database or change the database 
use lms;

-- database -> collection of tables  , Tables  --  collection of rows and columns

-- create a database
create database EMS;
use ems;

-- create a table
create table employees(emp_id int , emp_name varchar(30) ,password varchar(40) not null , emp_dept varchar(40) not null  ,salary int);

-- To see table structure
describe employees;

-- to retrieve/ view / see  the records or data or rows of a table 
select * from employees;

-- insert the values in a table 
insert into employees values(101, "Niti Dwivedi" , "pass@123" , "Training" , 50000),
							(102, "Nitin Mehta" , "password@123" , "Admin" , 60000),
                            (103, "Jaya Kishori" , "jaya@123" , "Finance" , 80000);

-- or

insert into employees values(101, "Niti Dwivedi" , "pass@123" , "Training" , 50000);
insert into employees values(102, "Nitin Mehta" , "password@123" , "Admin" , 60000);
insert into employees values(103, "Jaya Kishori" , "jaya@123" , "Finance" , 80000);

-- to insert partial data 

insert into employees (emp_id , emp_name , password) values(104, "Meenu Kumari" , "meenu@123" );

select * from employees;

-- drop a table
drop table employees;

-- update the data

select * from employees;

update employees set password = "Hello@123" where emp_id=102;

-- parameterized query  ---  JDBC 
update employees set password = ?  where emp_id=?;

set sql_safe_updates = 0 ;

delete from employees where emp_id =103;

-- parameterized query  ---  JDBC
delete from employees where emp_id =?;

select * from employees;

select emp_id , emp_name , salary from employees;

select  emp_name , salary from employees where emp_id= 101;

select  * from employees where emp_id= 101;

-- How to sort the data 
select emp_id , emp_name , salary from employees order by emp_id desc ;








