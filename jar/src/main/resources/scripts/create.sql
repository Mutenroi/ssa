create table IF NOT EXISTS USER(
	id bigint auto_increment PRIMARY KEY,
	name varchar(25) ,
	password varchar(25)
);
commit;

		merge into user key(id,name,password) values (1,'user','user');
		merge into user key(id,name,password) values (2,'admin','admin');
commit;


create table IF NOT EXISTS SNIPPET(
	id bigint auto_increment PRIMARY KEY,
	username SMALLINT ,
	text CLOB
);
commit;

create table IF NOT EXISTS BOOK(
	nameBook varchar(25) ,
 	ISBN varchar(25),
 	nameAuthor varchar(25)
);
commit;

create table IF NOT EXISTS AUTHOR(
	nameAuthor varchar(25) ,
 	dateOfBirth date
);
commit;
