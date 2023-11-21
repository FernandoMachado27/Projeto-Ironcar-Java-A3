create table cars(
	
	id bigint not null auto_increment,
	name varchar(100) not null,
	brand varchar(50) not null,
	model varchar(100) not null,
	year varchar(5)not null,
	plan varchar(50)not null,
	plate varchar(15)not null,
	
	primary key(id)
	
);	