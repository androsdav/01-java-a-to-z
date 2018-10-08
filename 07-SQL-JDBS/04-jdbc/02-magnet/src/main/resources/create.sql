-- create table item
CREATE TABLE item (
  id SERIAL PRIMARY KEY,
  name VARCHAR(200) NOT NULL,
  description VARCHAR(2000) NOT NULL,
  create_date DATE NOT NULL
);

-- create table comments
CREATE TABLE comments (
  id SERIAL PRIMARY KEY,
  name VARCHAR(2000) NOT NULL,
  description VARCHAR(2000) NOT NULL,
  create_date DATE NOT NULL,
  item_id INT REFERENCES item(id) ON DELETE CASCADE
);


CREATE TABLE entry (
  field integer
);
CREATE TABLE entry1 (
  field integer
);
CREATE TABLE entry2 (
  field integer
);

INSERT INTO entry(field) VALUES (1);
INSERT INTO entry(field) VALUES (2);
INSERT INTO entry(field) VALUES (3);
INSERT INTO entry(field) VALUES (4);

SELECT * FROM entry;
SELECT * FROM entry WHERE entry.field = 3;
DELETE FROM entry;

DROP TABLE entry;
DROP TABLE entry1;
DROP TABLE entry2;

SELECT * FROM main.sqlite_master WHERE main.sqlite_master.tbl_name = 'entry';
SELECT * FROM main.sqlite_master;

SELECT * FROM main.sqlite_master WHERE table_schema NOT IN ('information_schema','pg_catalog');