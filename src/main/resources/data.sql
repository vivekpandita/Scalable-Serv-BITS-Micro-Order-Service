drop table if exists app_user; 
create table app_user (id bigint not null, address varchar(255), contact_number varchar(255), email varchar(255), name varchar(255), user_name varchar(255), password varchar(255), primary key (id));

insert into app_user (address,contact_number,email,name,id, user_name, password) values ('Talab Tillo Jammu','223333','rajt@gmail.com','Rajat',9991, 'u1','1');
insert into app_user (address,contact_number,email,name,id, user_name, password) values ('Talab Tillo Jammu, J&K','9923232','ViveRock@gmail.com','Vivek',9992, 'u2','2');
insert into app_user (address,contact_number,email,name,id, user_name, password) values ('NIBM Pune','233342234','mike@gmail.com','Mike',9993,'u3','3');


drop table if exists book; 
create table book (id bigint not null, author varchar(255), name varchar(255), price float(53), print_year bigint, publisher varchar(255), primary key (id));

insert into book (author,name,price,print_year,publisher,id) values ('JK Rowling', 'Harry Potter & Philosopher Stone', 200.0, 1998, 'Warner Bros', 80001);
insert into book (author,name,price,print_year,publisher,id) values ('JK Rowling', 'Harry Potter & Chambers of Secret', 250.0, 1999, 'Warner Bros', 80002);
insert into book (author,name,price,print_year,publisher,id) values ('JK Rowling', 'Harry Potter & Prisoner of Azkaban', 150.0, 1999, 'Warner Bros', 80003);
insert into book (author,name,price,print_year,publisher,id) values ('George RR Martin', 'Song of Ice & Fire', 1150.0, 2005, 'HBO', 80004);
insert into book (author,name,price,print_year,publisher,id) values ('Chetan Bhagat', 'Half GirlFriend', 25.7, 2012, 'Penguin', 80005);
insert into book (author,name,price,print_year,publisher,id) values ('Astron Bulleyan', 'Almanak by Naval', 99.0, 2015, 'Rajat Word Press Ltd', 80006);
insert into book (author,name,price,print_year,publisher,id) values ('JL Nehru', 'Discovery of India', 2000.5, 2012, 'Sams', 80007);

drop table if exists order_item; 
create table order_item (id bigint not null, quantity bigint, total_price float(53), book_id bigint, order_id bigint, primary key (id));

drop table if exists orders; 
create table orders (id bigint not null, delivery_date timestamp(6), order_placed_on timestamp(6), order_status varchar(255), payment_method varchar(255), shipping_address varchar(255), total_order_price float(53), user_id bigint, primary key (id));