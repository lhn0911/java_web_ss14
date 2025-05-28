create database java_ss14;
use java_ss14;
create table User(
                     id int primary key auto_increment,
                     username varchar(50) not null unique,
                     password varchar(255) not null,
                     email varchar(100) not null
);

delimiter //
create procedure create_user(
    username_in varchar(50),
    password_in varchar(255),
    email_in varchar(100)
)
begin
    insert into User(username, password, email)
    values (username_in, password_in, email_in);
end;
delimiter //