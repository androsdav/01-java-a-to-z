-- create new database for storage product
CREATE DATABASE base_car;

-- create table body
CREATE TABLE body (
  id SERIAL PRIMARY KEY,
  name VARCHAR(200) NOT NULL UNIQUE
);

-- create table transmission
CREATE TABLE transmission (
  id SERIAL PRIMARY KEY,
  name VARCHAR(200) NOT NULL UNIQUE
);

-- create table engine
CREATE TABLE engine (
  id SERIAL PRIMARY KEY,
  name VARCHAR(200) NOT NULL UNIQUE
);

-- create table car
CREATE TABLE car (
  id SERIAL PRIMARY KEY,
  name VARCHAR(200) NOT NULL UNIQUE,
  body_id INT REFERENCES body(id) ON DELETE SET NULL,
  transmission_id INT REFERENCES transmission(id) ON DELETE SET NULL,
  engine_id INT REFERENCES engine(id) ON DELETE SET NULL
);