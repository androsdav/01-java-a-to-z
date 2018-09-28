-- create table type of product, table don`t has duplicate name of product
CREATE TABLE type (
  id INTEGER PRIMARY KEY,
  name VARCHAR(200) NOT NULL UNIQUE
);

CREATE TABLE androsdav (
  name VARCHAR(100) NOT NULL
);


CREATE TABLE tableforsearches (
  name VARCHAR(100) NOT NULL
);

INSERT INTO tableforsearches(name) VALUES ('tableforsearches');

INSERT INTO type(name) VALUES ('bread');
INSERT INTO type(name) VALUES ('sausage');
INSERT INTO type(name) VALUES ('beer');
INSERT INTO type(name) VALUES ('butter');
INSERT INTO type(name) VALUES ('milk');
INSERT INTO type(name) VALUES ('ice cream');
INSERT INTO type(name) VALUES ('cheese');

SELECT * FROM type;
SELECT * FROM tableforsearches;
DROP TABLE type;

DELETE FROM type WHERE id = 1;


CREATE DATABASE andros;
