-- create new database for storage item
-- CREATE DATABASE base_item;

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

-- add to role
INSERT INTO role (name) VALUES ('user');
INSERT INTO role (name) VALUES ('superuser');
INSERT INTO role (name) VALUES ('admin');
INSERT INTO role (name) VALUES ('root');

-- add to rules
INSERT INTO rules (name) VALUES ('add_user');
INSERT INTO rules (name) VALUES ('ban_user');
INSERT INTO rules (name) VALUES ('delete_user');
INSERT INTO rules (name) VALUES ('add_item');
INSERT INTO rules (name) VALUES ('delete_item');
INSERT INTO rules (name) VALUES ('add_comment');
INSERT INTO rules (name) VALUES ('delete_comment');

-- add to role_rules for user: add_item, add_comment
INSERT INTO role_rules (role_id, rules_id) VALUES (
  (SELECT id FROM role WHERE name = 'user'),
  (SELECT id FROM rules WHERE name = 'add_item')
);
INSERT INTO role_rules (role_id, rules_id) VALUES (
  (SELECT id FROM role WHERE name = 'user'),
  (SELECT id FROM rules WHERE name = 'add_comment')
);
-- add to role_rules for admin: add_item, add_comment, delete_item, delete_comment
INSERT INTO role_rules (role_id, rules_id) VALUES (
  (SELECT id FROM role WHERE name = 'admin'),
  (SELECT id FROM rules WHERE name = 'add_item')
);
INSERT INTO role_rules (role_id, rules_id) VALUES (
  (SELECT id FROM role WHERE name = 'admin'),
  (SELECT id FROM rules WHERE name = 'add_comment')
);
INSERT INTO role_rules (role_id, rules_id) VALUES (
  (SELECT id FROM role WHERE name = 'admin'),
  (SELECT id FROM rules WHERE name = 'delete_item')
);
INSERT INTO role_rules (role_id, rules_id) VALUES (
  (SELECT id FROM role WHERE name = 'admin'),
  (SELECT id FROM rules WHERE name = 'delete_comment')
);
INSERT INTO role_rules (role_id, rules_id) VALUES (
  (SELECT id FROM role WHERE name = 'admin'),
  (SELECT id FROM rules WHERE name = 'ban_user')
);

-- add to user 3 users
INSERT INTO "user" (name, role_id) VALUES (
  'David', (SELECT id FROM role WHERE name = 'user')
);
INSERT INTO "user" (name, role_id) VALUES (
  'Robert', (SELECT id FROM role WHERE name = 'user')
);
INSERT INTO "user" (name, role_id) VALUES (
  'Edward', (SELECT id FROM role WHERE name = 'user')
);
INSERT INTO "user" (name, role_id) VALUES (
  'Steven', (SELECT id FROM role WHERE name = 'user')
);
INSERT INTO "user" (name, role_id) VALUES (
  'Thomas', (SELECT id FROM role WHERE name = 'user')
);
INSERT INTO "user" (name, role_id) VALUES (
  'Richard', (SELECT id FROM role WHERE name = 'admin')
);
-- add state
INSERT INTO state (name) VALUES ('active');
INSERT INTO state (name) VALUES ('not_active');
INSERT INTO state (name) VALUES ('open');
INSERT INTO state (name) VALUES ('closed');
INSERT INTO state (name) VALUES ('removed');

-- add category
INSERT INTO category (name) VALUES ('sport');
INSERT INTO category (name) VALUES ('work');
INSERT INTO category (name) VALUES ('life');
INSERT INTO category (name) VALUES ('study');
INSERT INTO category (name) VALUES ('hobby');

-- add item
INSERT INTO item (name, user_id, state_id, category_id) VALUES (
  'selling laptop',
  (SELECT id FROM "user" WHERE name = 'David'),
  (SELECT id FROM state WHERE name = 'active'),
  (SELECT id FROM category WHERE name = 'life')
);
INSERT INTO item (name, user_id, state_id, category_id) VALUES (
  'buy bicycle',
  (SELECT id FROM "user" WHERE name = 'Edward'),
  (SELECT id FROM state WHERE name = 'open'),
  (SELECT id FROM category WHERE name = 'sport')
);
INSERT INTO item (name, user_id, state_id, category_id) VALUES (
  'locking for job',
  (SELECT id FROM "user" WHERE name = 'Thomas'),
  (SELECT id FROM state WHERE name = 'active'),
  (SELECT id FROM category WHERE name = 'work')
);
-- add comment
INSERT INTO comments (name, item_id, user_id) VALUES (
  'Not bad laptop',
  (SELECT id FROM item WHERE item.name = 'selling laptop'),
  (SELECT id FROM "user" WHERE name = 'Thomas')
);
INSERT INTO comments (name, item_id, user_id) VALUES (
  'Your laptop is trash',
  (SELECT id FROM item WHERE item.name = 'selling laptop'),
  (SELECT id FROM "user" WHERE name = 'Edward')
);
INSERT INTO comments (name, item_id, user_id) VALUES (
  'I want to buy, discuss ?',
  (SELECT id FROM item WHERE item.name = 'selling laptop'),
  (SELECT id FROM "user" WHERE name = 'Steven')
);
INSERT INTO comments (name, item_id, user_id) VALUES (
  'Ok Steven, talk to me me about this now !!!',
  (SELECT id FROM item WHERE name = 'selling laptop'),
  (SELECT id FROM "user" WHERE name = 'David')
);
INSERT INTO comments (name, item_id, user_id) VALUES (
  'good bike',
  (SELECT id FROM item WHERE name = 'buy bicycle'),
  (SELECT id FROM "user" WHERE name = 'David')
);
INSERT INTO comments (name, item_id, user_id) VALUES (
  'bad bike',
  (SELECT id FROM item WHERE name = 'buy bicycle'),
  (SELECT id FROM "user" WHERE name = 'Richard')
);




