-- create new database for storage product
CREATE DATABASE base_product;

-- create table type of product, table don`t has duplicate name of product
CREATE TABLE type (
  id SERIAL PRIMARY KEY,
  name VARCHAR(200) NOT NULL UNIQUE
);

-- create table product, table don`t has duplicate name of product
CREATE TABLE product (
  id SERIAL PRIMARY KEY,
  name VARCHAR(200) NOT NULL UNIQUE,
  type_id INT REFERENCES type(id) ON DELETE SET NULL,
  expired_date DATE,
  price FLOAT(2) NOT NULL CONSTRAINT  positive_price CHECK (price > 0)
);