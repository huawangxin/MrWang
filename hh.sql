create table users_wangxin(
	userid  number(38) primary key,
	username  varchar2(40),
	userpwd  varchar2(40)
)
create table address_wangxin(
	addressid  number(38) primary key,
	userid   number(38),
	address  varchar2(80),
	phone  number(40),
	localname   varchar2(40)
)
create table goods_wangxin(
	goodsid  number(38) primary key,
	goodsname   varchar2(40),
	price   number(40),
	tyles     varchar2(40)
)
create table orders_wangxin(
	ordersid  number(38) primary key,
	userid    number(38),
	prices   number(40),
	times     varchar2(40),
	states    varchar2(40),
	addressid  number(38),
	address  varchar2(80),
	phone  number(40),
	localname   varchar2(40)
)
create table emp_wangxin(
	id   number(38) primary key,
	empname   varchar2(40)
)