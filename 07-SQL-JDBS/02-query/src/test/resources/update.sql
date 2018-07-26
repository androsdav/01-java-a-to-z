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
  'Bagel',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Baguette',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Anadama bread',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Rice bread',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Rye bread',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Sacramental bread',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Soda bread',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Tandoor bread',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Teacake bread',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Tiger bread',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);

-- inserts product sausage
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Hot dog',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Chorizo',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Vienna sausage',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Black pudding',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Salami',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Battered sausage',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Glamorgan sausage',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Cumberland sausage',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Lincolnshire sausage',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Newmarket sausage',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Oxford sausage',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Bologna sausage',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Boudin',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
-- inserts product beer
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Snow',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Bud light',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Corona',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Tiger',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Red Stripe',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Scol',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Asahi',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Taedonggang',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Guinness',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Kozel',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Duck Duck Gooze',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Kentucky Brunch Brand Stout',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
-- inserts product butter
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Butter with Canola Oil',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Butter Salted',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Pure Irish Butter',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Extra Virgin Olive Oil Buttery  Spread',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Butter',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'OrgButter Salted',
  (SELECT id FROM type WHERE type.name = 'bread'),
  'Organic Unsalted Butter Grade AA',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Unsalted Butter',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Sweet Cream Butter Unsalted',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
-- inserts product milk
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Vitamin D Milk',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Whole Milk',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Organic Lowfat Milk',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Fat Free Milk',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Instant Nonfat Dry Milk',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
-- inserts product ice cream
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Candy Cane ice cream',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Cherry ice cream',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Hokey Pokey',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Mango ice cream',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Mamey ice cream',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Sesame',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Spumoni',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Salted Caramel',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Tutti frutti',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Raspberry Ripple',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
-- inserts product cheese
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Mozzarella',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Sharp cheddar',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Brie',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Feta',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Gouda cheese',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Monterey Jack',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Muenster cheese',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Blue cheese',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Camembert',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Cheddar cheese',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Gorgonzola',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Goat cheese',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Cream cheese',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Grana Padano',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Vacherin',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '25-07-2018',
  '10.03'
);








SELECT * FROM type;
SELECT * FROM product;
DELETE FROM product;
