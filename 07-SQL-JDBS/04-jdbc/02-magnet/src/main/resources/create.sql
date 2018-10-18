-- create table entry
CREATE TABLE entry (
  field integer
);

-- select from entry
SELECT * FROM entry;

-- drop table entry
DROP TABLE entry;

-- check table entry
SELECT * FROM main.sqlite_master WHERE main.sqlite_master.tbl_name = 'entry';