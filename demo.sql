CREATE table t_user
(
  ID             NUMBER NOT NULL,
  NAME           VARCHAR2(100),
  USERNAME       VARCHAR2(100),
  PASSWORD       VARCHAR2(100),
  PHONE          VARCHAR2(50),
  SEX            NUMBER(1) DEFAULT 0 NOT NULL,
  AGE            NUMBER(3) DEFAULT 0 NOT NULL,
  CREATE_TIME    TIMESTAMP,
  ADDRESS        VARCHAR2(255),
  DESCRIPTION    VARCHAR2(255),
  ROLE           NUMBER(1) DEFAULT 0  NOT NULL,
  STATUS         NUMBER(1) DEFAULT 0  NOT NULL
);
CREATE SEQUENCE t_user_sequence
INCREMENT BY 1
NOMAXVALUE
NOCYCLE
CACHE 10;

create or replace trigger t_user_trigger
  before insert on t_user
  for each row
begin
  select t_user_sequence.nextval into :new.id from dual;
end t_user_trigger;
/

Insert into T_USER (ID,NAME,USERNAME,PASSWORD,PHONE,SEX,AGE,CREATE_TIME,ADDRESS,DESCRIPTION,ROLE,STATUS) values (1,'admin','admin','21232f297a57a5a743894a0e4a801fc3','18009260929',1,18,to_timestamp('06-12月-17 03.04.05.000000000 下午','DD-MON-RR HH.MI.SSXFF AM'),'文化西路44号','。。。',0,0);
