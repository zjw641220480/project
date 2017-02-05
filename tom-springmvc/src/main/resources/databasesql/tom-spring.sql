create table items (
	id number(7) primary key,
	name varchar2(20),
	price NUMBER(6),
	pic varchar2(20),
	createtime TIMESTAMP,
	detail varchar2(50)
);

-- 创建序列
CREATE SEQUENCE SEQUENCE_ITEMS
INCREMENT BY 1     --每次加几
START WITH 1         --序列从几开始
MAXVALUE 99999999;

--创建触发器
CREATE OR REPLACE TRIGGER TRIGGER_ITEMS
BEFORE INSERT ON ITEMS FOR EACH ROW
begin
select SEQUENCE_ITEMS.nextval into:new.id from dual;
end;
/

create table ORDERDETAIL(
	id number(6),
	ordersId number(20),
	itemsId number(20),
	itemsNum number(20)
)

create table ORDERS(
	id number(7),
	userId number(8),
	ordersNumber number(8),
	createtime TIMESTAMP,
	note varchar2(30)
)

create table users(
	id number(8) primary key,
	username varchar2(9),
	birthday TIMESTAMP,
	sex varchar2(2),
	address varchar2(20)
)