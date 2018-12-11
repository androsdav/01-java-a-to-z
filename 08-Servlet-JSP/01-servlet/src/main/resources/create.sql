-- search data base base_vacancy
SELECT datname FROM pg_database WHERE datname = 'base_vacancy';

-- create data base base_vacancy
CREATE DATABASE base_vacancy;

-- search table vacancy
SELECT table_name FROM information_schema.tables WHERE table_schema NOT IN ('information_schema','pg_catalog');

-- create table vacancy
CREATE TABLE vacancy (
  id SERIAL PRIMARY KEY,
  theme VARCHAR(300) UNIQUE NOT NULL,
  author VARCHAR(50),
  answers INT NOT NULL,
  viewers INT NOT NULL,
  date DATE NOT NULL
);

-- add vacancy
INSERT INTO vacancy (theme, author, answers, viewers, date) VALUES (?, ?, ?, ?, ?) ON CONFLICT DO NOTHING;

-- counts all number of vacancy
SELECT COUNT(*) FROM vacancy LIMIT 1;

-- searches vacancy with last date
SELECT vacancy.date FROM vacancy WHERE vacancy.date IN (SELECT MAX(vacancy.date) FROM vacancy);