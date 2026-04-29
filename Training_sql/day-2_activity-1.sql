create database quickbites;
use quickbites;

create table customers (
    customer_id int primary key,
    customer_name varchar(50),
    city varchar(50)
);

create table restaurants (
    restaurant_id int primary key,
    restaurant_name varchar(50),
    city varchar(50)
);

create table orders (
    order_id int primary key,
    customer_id int,
    restaurant_id int,
    order_amount decimal(10,2),
    order_date date,
    foreign key (customer_id) references customers(customer_id),
    foreign key (restaurant_id) references restaurants(restaurant_id)
);

insert into customers values
(1, 'rahul', 'delhi'),
(2, 'priya', 'mumbai'),
(3, 'amit', 'delhi'),
(4, 'neha', 'kolkata'),
(5, 'rohit', 'mumbai');

insert into restaurants values
(101, 'food hub', 'delhi'),
(102, 'spice kitchen', 'mumbai'),
(103, 'tasty bites', 'kolkata'),
(104, 'urban eatery', 'bangalore');

insert into orders values
(1001, 1, 101, 500, '2024-01-10'),
(1002, 2, 102, 800, '2024-01-11'),
(1003, 1, 102, 300, '2024-01-12'),
(1004, 3, 101, 700, '2024-01-13'),
(1005, 4, 103, 400, '2024-01-14');

-- Activity 1 (all joins)


select c.customer_name, r.restaurant_name, o.order_amount
from customers c
join orders o on c.customer_id = o.customer_id
join restaurants r on o.restaurant_id = r.restaurant_id;

select c.customer_name, o.order_id, o.order_amount
from customers c
left join orders o on c.customer_id = o.customer_id;

select r.restaurant_name, o.order_id, o.order_amount
from orders o
right join restaurants r on o.restaurant_id = r.restaurant_id;

select c.customer_name, o.order_id, o.order_amount
from customers c
left join orders o on c.customer_id = o.customer_id

union

select c.customer_name, o.order_id, o.order_amount
from customers c
right join orders o on c.customer_id = o.customer_id;

select c1.customer_name as customer1, c2.customer_name as customer2, c1.city
from customers c1
join customers c2
on c1.city = c2.city
and c1.customer_id <> c2.customer_id;

-- Activity 2 (all subqueries)

select distinct c.customer_name
from customers c
join orders o on c.customer_id = o.customer_id
where o.order_amount > (
    select avg(order_amount) from orders
);

select r.restaurant_name
from restaurants r
where r.restaurant_id in (
    select restaurant_id from orders
);


select c.customer_name, o.order_amount
from customers c
join orders o on c.customer_id = o.customer_id
where o.order_amount = (
    select max(order_amount) from orders
);

-- Activity 3 (all correlated subqueries)

select c.customer_name, o.order_amount
from customers c
join orders o on c.customer_id = o.customer_id
where o.order_amount > (
    select avg(o2.order_amount)
    from orders o2
    where o2.customer_id = o.customer_id
);

select r.restaurant_name
from restaurants r
join orders o on r.restaurant_id = o.restaurant_id
group by r.restaurant_id, r.restaurant_name
having avg(o.order_amount) > (
    select avg(order_amount) from orders
);

