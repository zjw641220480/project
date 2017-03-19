--创建用户表,角色表,权限表(实质上是权限和资源的结合),用户角色表,角色权限表;
create table sys_user (user_id number(8) primary key,usercode varchar2(8),username varchar2(8),password varchar2(64),salt varchar2(8),locked varchar2(8));
-- 创建序列
CREATE SEQUENCE SEQUENCE_SYS_USER
INCREMENT BY 1     --每次加几
START WITH 1         --序列从几开始
MAXVALUE 99999999;
--创建触发器
CREATE OR REPLACE TRIGGER TRIGGER_SYS_USER
BEFORE INSERT ON sys_user FOR EACH ROW
begin
select SEQUENCE_SYS_USER.nextval into:new.user_id from dual;
end;

create table sys_permission(
	id number(20) NOT NULL ,
	name varchar2(128) NOT NULL ,
	type varchar2(32) NOT NULL ,
	url varchar2(128) DEFAULT NULL ,
	percode varchar2(128) DEFAULT NULL ,
	parentid number(20) DEFAULT NULL ,
	parentids varchar2(128) DEFAULT NULL ,
	sortstring varchar2(128) DEFAULT NULL ,
	available char(1) DEFAULT NULL ,
	PRIMARY KEY (id)
	);
-- 创建序列
CREATE SEQUENCE SEQUENCE_SYS_permission
INCREMENT BY 1     --每次加几
START WITH 1         --序列从几开始
MAXVALUE 99999999;
--创建触发器
CREATE OR REPLACE TRIGGER TRIGGER_SYS_permission
BEFORE INSERT ON sys_permission FOR EACH ROW
begin
select SEQUENCE_SYS_permission.nextval into:new.id from dual;
end;
--角色表
create table sys_role(
	id varchar2(36),
	name varchar2(128),
	available char(1)
);
-- 创建序列
CREATE SEQUENCE SEQUENCE_SYS_role
INCREMENT BY 1     --每次加几
START WITH 1         --序列从几开始
MAXVALUE 99999999;
--创建触发器
CREATE OR REPLACE TRIGGER TRIGGER_SYS_role
BEFORE INSERT ON sys_role FOR EACH ROW
begin
select SEQUENCE_SYS_permission.nextval into:new.id from dual;
end;
--角色权限表
create table sys_role_permission(
	id varchar2(36),
	sys_role_id varchar2(36),
	sys_permission_id varchar2(32)
);
-- 创建序列
CREATE SEQUENCE SEQUENCE_SYS_role_permission
INCREMENT BY 1     --每次加几
START WITH 1         --序列从几开始
MAXVALUE 99999999;
--创建触发器
CREATE OR REPLACE TRIGGER TRIGGER_SYS_role_permission
BEFORE INSERT ON sys_role_permission FOR EACH ROW
begin
select SEQUENCE_SYS_role_permission.nextval into:new.id from dual;
end;
create table sys_user_role(
	id varchar2(36),
	sys_user_id varchar2(32),
	sys_role_id varchar2(32)
);
-- 创建序列
CREATE SEQUENCE SEQUENCE_SYS_user_role
INCREMENT BY 1     --每次加几
START WITH 1         --序列从几开始
MAXVALUE 99999999;
--创建触发器
CREATE OR REPLACE TRIGGER TRIGGER_SYS_user_role
BEFORE INSERT ON sys_user_role FOR EACH ROW
begin
select SEQUENCE_SYS_user_role.nextval into:new.id from dual;
end;