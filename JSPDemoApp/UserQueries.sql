Create database springApplication

use springApplication

CREATE TABLE user(
id int not null auto_increment,
user_id varchar(300),
user_password varchar(300),
primary key(id), 
unique key `user_id` (`user_id`)
);

create table role(id int not null auto_increment,
name varchar(255),
primary key(id));


create table user_role(id int not null auto_increment,
role_id int,
user_id int,
primary key(id)
);

insert into user(user_id, user_password)values('Admin', hex(aes_encrypt('Root', 'secret')));

Select cast(aes_decrypt(unhex(`user_password`), 'secret') as char(50)) from user where user_id='Roshan'

select * from user



