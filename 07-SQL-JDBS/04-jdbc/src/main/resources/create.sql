-- create new database for car
CREATE DATABASE base_tracker;

-- create table item
CREATE TABLE item (
  id SERIAL PRIMARY KEY,
  name VARCHAR(2000) NOT NULL
);

-- create table comments
CREATE TABLE comments (
  id SERIAL PRIMARY KEY,
  name VARCHAR(200) NOT NULL,
  description VARCHAR(2000) NOT NULL,
  create_date DATA
  item_id INT REFERENCES item(id) ON DELETE CASCADE
);