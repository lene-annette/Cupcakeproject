create table bottom(
	bottom_type varchar(45) not null,
    price integer not null,
    primary key (bottom_type)
);

create table top(
	top_type varchar(45) not null,
    price integer not null,
    primary key (top_type)
);

create table users(
	u_name varchar(45) not null,
    psw varchar (45) not null,
    balance integer,
    primary key (u_name)
);

insert into bottom values('Chocolate',5),('Vanilla',5),('Nutmeg',5),('Pistacio',6),('Almond',7);
insert into top values('Chocolate',5),('Blueberry',5),('Rasberry',5),('Crispy',6),('Strawberry',6),('Rum/Raisin',7),('Orange',8),('Lemon',8),('Blue Cheese',9);

alter table users add email varchar(45) not null;

select * from users;

insert into users values('Lene','1234',100,'lene@mail.dk');
