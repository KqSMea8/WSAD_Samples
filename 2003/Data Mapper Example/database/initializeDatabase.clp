create database EJPBOOK;
connect to EJPBOOK;
grant connect on database to user "GUEST";
create schema acme;

create table acme.department (
	id 			integer not null primary key,
	name 		varchar(60),
	description varchar(60),
	code		varchar(128),
	externalBudget float,
	type		integer not null
);

create table acme.employee (
	id 		varchar(10) not null primary key,
	name 	varchar(60),
	age 	integer,
	street 	varchar(60),
	city 	varchar(60),
	state 	varchar(60),
	zip 	varchar(30),
	deptid	integer,
	constraint empdept foreign key (deptid) references acme.department (id)
);

grant all on table acme.employee to user "GUEST ";
grant all on table acme.department to user "GUEST ";
commit work;
connect reset;
terminate;

