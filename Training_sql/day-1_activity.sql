create database companydb;
use companydb;
create table customers (
    customer_id int,
    name varchar(100),
    email varchar(100),
    city varchar(50)
);
create table employees (
    employee_id int,
    name varchar(100),
    department varchar(50),
    salary int,
    city varchar(50)
);
create table restaurants (
    restaurant_id int,
    name varchar(100),
    cuisine_type varchar(50),
    city varchar(50)
);
create table orders (
    order_id int,
    customer_id int,
    order_amount int,
    order_date date
);
insert into customers values
(1, 'rahul sharma', 'rahul@gmail.com', 'delhi'),
(2, 'anita roy', 'anita@gmail.com', 'kolkata'),
(3, 'amit das', 'amit@gmail.com', 'durgapur'),
(4, 'neha singh', 'neha@gmail.com', 'mumbai'),
(5, 'ravi kumar', 'ravi@gmail.com', 'pune');
insert into employees values
(101, 'amit das', 'finance', 65000, 'kolkata'),
(102, 'neha singh', 'hr', 55000, 'mumbai'),
(103, 'ravi kumar', 'finance', 70000, 'delhi'),
(104, 'sneha patel', 'it', 80000, 'bangalore'),
(105, 'arjun mehta', 'marketing', 60000, 'pune');
insert into restaurants values
(201, 'pizza world', 'italian', 'bangalore'),
(202, 'spicy hub', 'indian', 'delhi'),
(203, 'dragon wok', 'chinese', 'kolkata'),
(204, 'burger house', 'fast food', 'mumbai'),
(205, 'tandoori town', 'indian', 'pune');
insert into orders values
(1001, 1, 500, '2025-01-11'),
(1002, 2, 1200, '2025-01-12'),
(1003, 3, 800, '2025-01-11'),
(1004, 4, 1500, '2025-01-13'),
(1005, 5, 700, '2025-01-14');
select * from customers;
select * from employees
where department = 'finance';
select * from employees
where salary > 60000;
select * from orders
where order_date = '2025-01-11';
select name, salary from employees
order by salary desc;
select name, salary from employees
order by salary desc
limit 2;
set sql_safe_updates=0;
update employees
set city = 'pune'
where name = 'ravi';
update restaurants
set cuisine_type = 'fast food'
where name = 'pizza world';
update orders
set order_amount = 550
where order_id = 1001;
delete from customers
where customer_id = 3;
delete from orders
where order_id = 1002;
delete from restaurants
where city = 'bangalore';

