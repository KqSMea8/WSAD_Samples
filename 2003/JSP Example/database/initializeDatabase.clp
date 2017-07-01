create database EJPBOOK;
connect to EJPBOOK;
grant connect on database to user "GUEST";
create schema acme;

create table jamsden.employee (
	id 		varchar(10) not null primary key,
	name 	varchar(60),
	age 	integer,
	street 	varchar(60),
	city 	varchar(60),
	state 	varchar(60),
	zip 	varchar(30)
);

grant all on table acme.employee to user "GUEST ";
commit work;
connect reset;
terminate;

