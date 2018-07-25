-- inserts data to table type of product
INSERT INTO type(name) VALUES ('bread');
INSERT INTO type(name) VALUES ('sausage');
INSERT INTO type(name) VALUES ('beer');
INSERT INTO type(name) VALUES ('butter');
INSERT INTO type(name) VALUES ('milk');
INSERT INTO type(name) VALUES ('ice cream');
INSERT INTO type(name) VALUES ('cheese');

-- inserts product bread
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Baba',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
SELECT * FROM type;
SELECT * FROM product;