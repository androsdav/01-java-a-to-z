-- create table users
CREATE TABLE users (
  id serial PRIMARY KEY,
  login VARCHAR(50) NOT NULL,
  name VARCHAR(50) NOT NULL
);

-- insert user to table users
INSERT INTO users(login, name) VALUES('goad', 'dilan');
INSERT INTO users(login, name) VALUES('queen', 'amanda');
INSERT INTO users(login, name) VALUES('baron', 'bob');

-- insert user
INSERT INTO users(login, name) VALUES(?, ?)
-- returns user by id
SELECT * FROM users WHERE id=?
-- select user by name
SELECT * FROM users WHERE name=?
-- select user by login
SELECT * FROM users WHERE login=?
-- select user by name and by login
SELECT * FROM users WHERE login=? AND name=?
-- update user by id
UPDATE users SET login = ?, name = ? WHERE id = ?
-- delete user by id
DELETE FROM users WHERE id=?
-- select all users
SELECT * FROM users ORDER BY id