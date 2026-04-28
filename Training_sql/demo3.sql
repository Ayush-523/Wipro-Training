create database QuickBite;
USE QuickBite;
CREATE TABLE Customers (
    customer_id int,
    name varchar(100),
    email varchar(100),
    city varchar(50)
);
CREATE TABLE Restaurants (
    restaurant_id int,
    name varchar(100),
    cuisine_type varchar(50),
    city varchar(50)
);
CREATE TABLE Orders (
    order_id int,
    customer_id int,
    restaurant_id int,
    order_amount decimal(10,2),
    order_date date
);
insert into Customers values
(1, 'Rahul Sharma', 'rahul@gmail.com', 'Delhi'),
(2, 'Anita Roy', 'anita@gmail.com', 'Kolkata'),
(3, 'Ayush Pal', 'ayush@gmail.com', 'Durgapur');
insert into Restaurants values
(101, 'Spicy Hub', 'Indian', 'Delhi'),
(102, 'Pizza Palace', 'Italian', 'Kolkata'),
(103, 'Dragon Wok', 'Chinese', 'Durgapur');
insert into Orders values
(1001, 1, 101, 500.00, '2026-04-01'),
(1002, 2, 102, 750.00, '2026-04-02'),
(1003, 3, 103, 300.00, '2026-04-03');
select * from Customers;
select * from Restaurants;
select * from Orders;
