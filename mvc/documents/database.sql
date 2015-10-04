/* database 생성 */
create database dragonsnest;

/* 사용자 새성 */
create user 'dragonsnest'@'%' identified by 'dragonsnest!@#$';
grant all privileges on dragonsnest.* to 'dragonsnest'@'%';

flush privileges;



create table USERS (
	PID int(10) not null auto_increment primary key,
	ID varchar(50) not null,
	PASSWORD varchar(100) not null,
	NAME varchar(50) not null,
	PHONE varchar(11),
	ROLE varchar(10)
 );