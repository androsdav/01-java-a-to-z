-- create table type of product, table don`t has duplicate name of product
CREATE TABLE type (
  id SERIAL PRIMARY KEY ASC,
  name VARCHAR(200) NOT NULL UNIQUE
);

INSERT INTO type(name) VALUES ('bread');
INSERT INTO type(id, name) VALUES ('sausage');
INSERT INTO type(id, name) VALUES ('beer');
INSERT INTO type(id, name) VALUES ('butter');
INSERT INTO type(id, name) VALUES ('milk');
INSERT INTO type(id, name) VALUES ('ice cream');
INSERT INTO type(id, name) VALUES ('cheese');

SELECT * FROM type;
DROP TABLE type;
