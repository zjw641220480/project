create table user_s (id number(8) primary key,username varchar2(15),sex varchar2(2),birthday TIMESTAMP(8),address varchar2(30));

-- 创建序列
CREATE SEQUENCE SEQUENCE_USER
INCREMENT BY 1     --每次加几
START WITH 1         --序列从几开始
MAXVALUE 99999999;

--创建触发器
CREATE OR REPLACE TRIGGER TRIGGER_USER
BEFORE INSERT ON user_s FOR EACH ROW
begin
select SEQUENCE_USER.nextval into:new.id from dual;
end;

--序列各个值的说明
--create sequence SEQ_TEST
--minvalue 1        --最小值
--nomaxvalue        --不设置最大值
--start with 1      --从1开始计数
--increment by 1    --每次加1个
--nocycle           --一直累加，不循环
--nocache;          --不建缓冲区