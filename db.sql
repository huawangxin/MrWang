create table users(
	userid number(38) primary key,
	username varchar2(20),
	truename varchar2(20),
	passwd varchar2(40),
	email varchar2(40),
	phone varchar2(40),
	address varchar2(40),
	postcode varchar2(40),
	grade number(11)
)
insert into users_wangxin values(1,'张三','乔布斯',111111,'qiaobusi@qq.com','13888888888','浙江省舟山市行政大厦1楼101室','310000',1);
drop table users_wangxin
SELECT * FROM users_wangxin
create sequence users_wangxin_id_seq.nextval increment by 1 start with 1;
drop sequence emp_id_seq_wangxin

create table orders_wangxin(
	userid number(38),
	isPayed number(1),
	totalPrice number(20)
)
insert into orders_wangxin values(1,0,1000);
SELECT * FROM orders_wangxin;
drop table orders_wangxin
购物车（尚未付款宝贝）
create table cart_wangxin(
	id number(38),
	userid number(38),
	goodsid number(38),
	goodsname  varchar2(80),
	price number(38),
	numbers  number(38)
)
insert into cart_wangxin values(1,1,1,'iPhone 6 Plus 128G',7188,1);
SELECT * FROM cart_wangxin;
drop table cart_wangxin

create table goods_wangxin(
	goodsId number(38) primary key,
	goodsName varchar2(20),
	goodsIntro varchar2(40),
	goodsPrice number(20),
	goodsNum number(20),
	publisher varchar2(40),
	photo varchar2(40),
	type varchar2(40)
)
insert into goods_wangxin values(1,'iPhone 6 Plus 128G','限时半价，欲购从速',7188,99,'苹果','照片','限时特价');
SELECT * FROM goods

create table orderdetail_wangxin(
	ordersIid number(38),
	goodsId  number(38),
	nums number(20)
)
insert into orderdetail_wangxin values(1,1,1)
select * from orderdetail;


delete t_emp_wangxin where id=8 or id=9
SELECT * FROM users where name like '%张%' order by id asc