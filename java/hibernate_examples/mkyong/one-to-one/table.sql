
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


drop table stock_detail;
create table stock_detail (
  stock_id int,
  comp_name varchar(100) not null,
  comp_desc varchar(255) not null,
  remark varchar(255) not null,
   listed_date date,
	constraint fk_stock 
	  foreign key(stock_id)
  	  references stock(stock_id)
);



