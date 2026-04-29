/* Day-2 */

-- Constraints in MySQL
	-- 1. Default --  to allow to take the default value if user has not entered any value in that column
    -- 2. Unique  -- It will allow only unique values and we can apply unique on multiple columns as Primary key will be applied on one column only
    -- 3. Not Null -- It will not allow any null values
    -- 4. Check -- It allow the validation based on your requirement ( for eg : age >=18  , price <0 )
    
    use ems;
    create table cart_items(item_id int auto_increment primary key , 
							name varchar(255) not null ,
                            qty int not null ,
							sales_tax dec(5,2) not null default 0.1 ,
                            constraint chkqty check (qty >0),
                            constraint chkst check(sales_tax >=0));
    describe cart_items;
    
  
   
    insert into cart_items values(101 , "Niti" , 300 , 0.2 );
    
    insert into cart_items(item_id , name , qty) values(102 , "Shaina",400);
    
    select * from cart_items;
      drop table cart_items;
    
    -- dropping a constraint
     alter table cart_items drop constraint chkqty;
    
    -- to show all the constraints or table query 
    show create table cart_items;
	
show tables;
show databases;
use sys;
use ems;

-- this query is use to get the constraint details 
select * from information_schema.check_constraints where constraint_schema = "ems" ;


-- Joins --

use ems;
show tables;
-- Inner join , left join , right join , full outer join , cross join 
create table department(dept_id int primary key , dept_name varchar(10));
create table employee(emp_id int primary key , emp_name varchar(20) , dept_id int , 
						foreign key(dept_id) references department(dept_id));


insert into department values (10 , "HR") , (20 , "IT") , (30, "Sales");

insert into employee values(101 , "Jiya" ,10),(102 , "Shubham" ,20),(103 , "Rohit" ,30),(104 , "Richa0" ,10);

select * from department ; select * from  employee;

-- Inner Join : An inner join returns only the rows where there is a match(common) in both the tables


select  employee.emp_name , department.dept_name  
from  employee inner join department   
on  employee.dept_id = department.dept_id ;

-- or 

select d.dept_id , emp_name , dept_name  
from  employee e inner join department  d 
on  e.dept_id = d.dept_id ;


insert into department values (40 , "Admin") , (50 , "Training") , (60, "Finance");

-- right join -  It will display all the records from right table i.e. department and 
			  /* matching records from the left table i.e. employee */
select d.dept_id , emp_name , dept_name  
from  employee e right join department  d 
on  e.dept_id = d.dept_id ;


 -- left join -  It will display all the records from left table i.e. employee and 
			  /* matching records from the right table i.e. department */
 select d.dept_id , emp_name , dept_name  
from  employee e left join department  d 
on  e.dept_id = d.dept_id ;


-- full outer join --
select  e.emp_name , d.dept_name  
from  employee e left join department  d 
on  e.dept_id = d.dept_id 
union 
select  e.emp_name , d.dept_name  
from  employee e right join department  d 
on  e.dept_id = d.dept_id ;


-- self join ---
create table empmanager(empid int , name varchar(30) , manager_id int);

insert into empmanager(empid , name) values (1 , "Niti");
insert into empmanager values (2 , "Jiya" , 1) , (3,"Shubham" ,2) , (4,"Richa" ,1); 

select * from empmanager;

-- If we want to display the manager name for a employee 
 select  e1.name as employeename , e2.name as managername 
 from empmanager e1 left join empmanager e2  
 on e1.manager_id = e2.empid;
 
 -- Subquery (Non-Correlated) --
 -- Correlated query --
 
 -- Subquery -- A query inside a query where inner query is independent to a outer query 
 
 -- scalar query -- when it will return the single value as a result 
 select emp_name from employee where salary > (select avg(salary) from salary);
 select * from salary;
 select e.emp_name from employee e inner join salary  s
 on e.emp_id = s.emp_id  
 where s.salary > (select avg(salary ) from salary);
 
 -- Multi row -- when it will return single column with multiple rows (like a list) that we can achieve using IN , NOTIN  , ANY , ALL
 select * from department;
 select * from employee;
 select dept_id  from department where dept_name in ('Sales' , 'Admin');
select e.emp_name from employee e where dept_id in( select dept_id  from department where dept_name in ('Sales' , 'IT'));

-- use case -- find all employees whose salary is greater than any salary in the sales department

select * from employees where salary > any(select salary from employees where dept_id=30);

-- Tables for Core Java Project

-- users
create table users(
    user_id int primary key auto_increment,
    username varchar(50),
    email varchar(50)
);

-- products
create table products (
    product_id int primary key auto_increment,
    product_name varchar(70),
    price double,
    stock int
);

-- cart

create table cart(
cart_id int primary key auto_increment,
user_id int,
product_id int,
quantity int,
foreign key(user_id) references users(user_id),
foreign key (product_id) references products(product_id)
);

-- orders
create table orders(
    order_id int primary key auto_increment,
    user_id int,
    total_amount double,
    order_date timestamp default current_timestamp
);

show tables;






