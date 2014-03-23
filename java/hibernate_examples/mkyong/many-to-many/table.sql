
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


drop table category;
create table category (
  category_id int,
  name varchar(10),
  description varchar(25),
  primary key (category_id)
);

create sequence category_seq
  START WITH 1  
  MAXVALUE 999999999999999999999999999  
  MINVALUE 1  
  NOCYCLE  
  CACHE 20  
  NOORDER;  

create table stock_category (
  stock_id int,
  category_id int,
  constraint fk_stock_sc
      foreign key(stock_id)
      references stock(stock_id),
  constraint fk_category_sc
      foreign key(category_id)
      references category(category_id)
);



