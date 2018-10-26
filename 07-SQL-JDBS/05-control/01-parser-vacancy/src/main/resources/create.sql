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

SELECT table_name FROM information_schema.tables WHERE table_schema NOT IN ('information_schema','pg_catalog');

CREATE TABLE vacancy (
  id SERIAL PRIMARY KEY,
  theme VARCHAR(300) UNIQUE NOT NULL,
  author VARCHAR(50) UNIQUE NOT NULL,
  answers INT NOT NULL,
  viewers INT NOT NULL,
  date VARCHAR(100) NOT NULL
);

CREATE TABLE vacancy1 (
  id SERIAL PRIMARY KEY,
  theme VARCHAR(300) UNIQUE NOT NULL,
  author VARCHAR(50) UNIQUE NOT NULL,
  answers INT NOT NULL,
  viewers INT NOT NULL,
  date VARCHAR(100) NOT NULL
);

INSERT INTO vacancy (theme, author, answers, viewers, date) VALUES (
    'Java professor',
    'admin',
    '100',
    '10',
    '10.10.2018'
);

INSERT INTO vacancy (theme, author, answers, viewers, date) VALUES (
  'Java professor',
  'admin',
  '100',
  '10',
  '10.10.2018'
);

SELECT *FROM vacancy;

SELECT table_name FROM information_schema.tables WHERE table_schema NOT IN ('information_schema','pg_catalog');