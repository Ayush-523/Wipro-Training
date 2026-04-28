show databases;
-- select * from sakila.actor;
create database LMS;
use lms;
create database ems;
use ems;
 create table employees (emp_id int,emp_name varchar(30),password varchar(40),emp_dept varchar(40) not null ,salary int not null);
 describe employees;
 select * from employees;
 insert into employees values(101,"Ayush","abc@123","Training",50000),
							(102,"Aman","abd@124","Training",40000),
                            (103,"Akash","abe@125","Training",45000);
-- insert partial value->
insert into employees (emp_id, emp_name, password) values (104, "Ritesh", "abf@126");
select * from employees;
-- drop table employees;