-- create new database for storage item
CREATE DATABASE base_item;

-- create table role
CREATE TABLE role (
  id SERIAL PRIMARY KEY,
  name VARCHAR(50) NOT NULL CHECK (name IN ('user', 'superuser', 'admin', 'root'))
);

-- create table rules
CREATE TABLE rules (
  id SERIAL PRIMARY KEY,
  name VARCHAR(50) NOT NULL CHECK (name IN(
    'add_user', 'ban_user', 'delete_user',
    'add_item', 'delete_item',
    'add_comment', 'delete_comment'))
);

-- create table user
CREATE TABLE "user" (
  id SERIAL PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  role_id INT REFERENCES role(id) ON DELETE SET NULL
);

-- create table role_rules
CREATE TABLE role_rules (
  id SERIAL PRIMARY KEY,
  role_id INT REFERENCES role(id) ON DELETE SET NULL,
  rules_id INT REFERENCES rules(id) ON DELETE SET NULL
);

-- create table state
CREATE  TABLE state (
  id SERIAL PRIMARY KEY,
  name VARCHAR(50) NOT NULL CHECK (name IN('active', 'not_active', 'open', 'closed','removed'))
);

-- create table category
CREATE TABLE category (
  id SERIAL PRIMARY KEY,
  name VARCHAR(50) NOT NULL CHECK (name IN('sport', 'work', 'life','study', 'hobby'))
);

-- create table item
CREATE TABLE item (
  id SERIAL PRIMARY KEY,
  name VARCHAR(2000) NOT NULL,
  user_id INT REFERENCES "user" (id) ON DELETE SET NULL,
  state_id INT REFERENCES state(id) ON DELETE SET NULL,
  category_id INT REFERENCES category(id) ON DELETE SET NULL
);

-- create table comments
CREATE TABLE comments (
  id SERIAL PRIMARY KEY,
  name VARCHAR(2000) NOT NULL,
  item_id INT REFERENCES item(id) ON DELETE CASCADE,
  user_id INT REFERENCES "user"(id) ON DELETE SET NULL
);

-- create table attaches
CREATE TABLE attaches (
  id SERIAL PRIMARY KEY,
  name VARCHAR(2000) NOT NULL,
  item_id INT REFERENCES item(id) ON DELETE CASCADE,
  user_id INT REFERENCES "user"(id) ON DELETE SET NULL
);