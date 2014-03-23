
drop table stock;
create table stock (
  stock_id int, 
  stock_code varchar(10) not null, 
  stock_name varchar(20) not null,
  primary key (stock_id)
  );

CREATE SEQUENCE stock_seq  
  START WITH 9  
  MAXVALUE 999999999999999999999999999  
  MINVALUE 1  
  NOCYCLE  
  CACHE 20  
  NOORDER;  


drop table stock_daily_record;
create table stock_daily_record (
  record_id int,
  price_open number(6,2),
  price_close number(6,2),
  price_change number(6,2),
  volume int,
  xdate date,
  stock_id int, 
    constraint fk_stock_daily_detail
      foreign key(stock_id)
      references stock(stock_id)
);

CREATE SEQUENCE stock_daily_record_seq  
  START WITH 4  
  MAXVALUE 999999999999999999999999999  
  MINVALUE 1  
  NOCYCLE  
  CACHE 20  
  NOORDER;  









