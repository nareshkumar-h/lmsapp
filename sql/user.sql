--drop database prod_lms_db;
--DROP database dev_lms_db 

create database prod_lms_db;

CREATE DATABASE prod_lms_db
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;

CREATE USER 'prod_user';
SET PASSWORD FOR 'prod_user' = PASSWORD('prod_pass123');


create database dev_lms_db;

CREATE DATABASE dev_lms_db
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;

CREATE USER 'dev_user';
SET PASSWORD FOR 'dev_user' = PASSWORD('dev_pass123');

GRANT ALL ON prod_lms_db.* TO 'prod_user';
GRANT ALL ON dev_lms_db.* TO 'dev_user';