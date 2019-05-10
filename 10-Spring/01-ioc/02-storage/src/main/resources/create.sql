
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