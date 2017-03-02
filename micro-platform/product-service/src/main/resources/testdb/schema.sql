drop table T_PRODUCTS if exists;

create table T_PRODUCT (ID bigint identity primary key, DESCRIPTION varchar(100),
                         PRICE decimal(8,2));
                        

