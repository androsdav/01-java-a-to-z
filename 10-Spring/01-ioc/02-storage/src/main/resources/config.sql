
CREATE TABLE users (
  id serial PRIMARY KEY,
  login VARCHAR(50) NOT NULL,
  name VARCHAR(50) NOT NULL
);

INSERT INTO users(login, name) VALUES('goad', 'dilan');
INSERT INTO users(login, name) VALUES('queen', 'amanda');
INSERT INTO users(login, name) VALUES('baron', 'bob');



SELECT * FROM users;
DROP TABLE users;



INSERT INTO users(login, name) VALUES(?, ?)
SELECT * FROM users WHERE id=?
SELECT * FROM users WHERE name=?
SELECT * FROM users WHERE login=?
SELECT * FROM users WHERE login=? AND name=?
UPDATE users SET login = ?, name = ? WHERE id = ?
DELETE FROM users WHERE id=?
SELECT * FROM users ORDER BY id