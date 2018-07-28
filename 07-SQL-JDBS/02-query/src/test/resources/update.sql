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
  '30-07-2018',
  '5.23'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Baguette',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '31-07-2018',
  '6.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Anadama bread',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '29-07-2018',
  '3.25'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Rice bread',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '31-07-2018',
  '1.11'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Rye bread',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '29-07-2018',
  '4.49'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Sacramental bread',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '31-07-2018',
  '6.01'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Soda bread',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '30-07-2018',
  '3.56'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Tandoor bread',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '30-07-2018',
  '0.80'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Teacake bread',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '31-07-2018',
  '3.72'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Tiger bread',
  (SELECT id FROM type WHERE type.name = 'bread'),
  '02-08-2018',
  '6.55'
);

-- inserts product sausage
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Hot dog',
  (SELECT id FROM type WHERE type.name = 'sausage'),
  '30-07-2018',
  '2.00'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Chorizo',
  (SELECT id FROM type WHERE type.name = 'sausage'),
  '01-09-2018',
  '10.12'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Vienna sausage',
  (SELECT id FROM type WHERE type.name = 'sausage'),
  '09-09-2018',
  '9.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Black pudding',
  (SELECT id FROM type WHERE type.name = 'sausage'),
  '25-09-2018',
  '20.98'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Salami',
  (SELECT id FROM type WHERE type.name = 'sausage'),
  '22-09-2018',
  '23.56'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Battered sausage',
  (SELECT id FROM type WHERE type.name = 'sausage'),
  '21-09-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Glamorgan sausage',
  (SELECT id FROM type WHERE type.name = 'sausage'),
  '12-10-2018',
  '12.45'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Cumberland sausage',
  (SELECT id FROM type WHERE type.name = 'sausage'),
  '15-09-2018',
  '15.56'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Lincolnshire sausage',
  (SELECT id FROM type WHERE type.name = 'sausage'),
  '18-09-2018',
  '27.50'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Newmarket sausage',
  (SELECT id FROM type WHERE type.name = 'sausage'),
  '25-08-2018',
  '31.28'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Oxford sausage',
  (SELECT id FROM type WHERE type.name = 'sausage'),
  '25-09-2018',
  '15.60'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Bologna sausage',
  (SELECT id FROM type WHERE type.name = 'sausage'),
  '30-08-2018',
  '16.80'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Boudin',
  (SELECT id FROM type WHERE type.name = 'sausage'),
  '23-09-2018',
  '24.60'
);

-- inserts product beer
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Snow',
  (SELECT id FROM type WHERE type.name = 'beer'),
  '10-09-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Bud light',
  (SELECT id FROM type WHERE type.name = 'beer'),
  '25-10-2018',
  '12.33'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Corona',
  (SELECT id FROM type WHERE type.name = 'beer'),
  '25-11-2018',
  '15.63'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Tiger',
  (SELECT id FROM type WHERE type.name = 'beer'),
  '27-08-2018',
  '5.00'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Red Stripe',
  (SELECT id FROM type WHERE type.name = 'beer'),
  '11-11-2018',
  '24.53'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Scol',
  (SELECT id FROM type WHERE type.name = 'beer'),
  '06-09-2018',
  '4.43'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Asahi',
  (SELECT id FROM type WHERE type.name = 'beer'),
  '19-11-2018',
  '11.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Taedonggang',
  (SELECT id FROM type WHERE type.name = 'beer'),
  '25-08-2018',
  '12.22'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Guinness',
  (SELECT id FROM type WHERE type.name = 'beer'),
  '05-09-2018',
  '23.45'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Kozel',
  (SELECT id FROM type WHERE type.name = 'beer'),
  '12-09-2018',
  '8.40'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Duck Duck Gooze',
  (SELECT id FROM type WHERE type.name = 'beer'),
  '17-11-2018',
  '20.50'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Kentucky Brunch Brand Stout',
  (SELECT id FROM type WHERE type.name = 'beer'),
  '01-12-2018',
  '32.45'
);

-- inserts product butter
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Butter with Canola Oil',
  (SELECT id FROM type WHERE type.name = 'butter'),
  '05-08-2018',
  '4.50'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Butter Salted',
  (SELECT id FROM type WHERE type.name = 'butter'),
  '03-09-2018',
  '5.00'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Pure Irish Butter',
  (SELECT id FROM type WHERE type.name = 'butter'),
  '04-09-2018',
  '3.43'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Extra Virgin Olive Oil Buttery  Spread',
  (SELECT id FROM type WHERE type.name = 'butter'),
  '15-09-2018',
  '8.00'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Butter',
  (SELECT id FROM type WHERE type.name = 'butter'),
  '27-09-2018',
  '2.52'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Org Butter Salted',
  (SELECT id FROM type WHERE type.name = 'butter'),
  '28-09-2018',
  '6.54'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Unsalted Butter',
  (SELECT id FROM type WHERE type.name = 'butter'),
  '25-07-2018',
  '2.00'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Sweet Cream Butter Unsalted',
  (SELECT id FROM type WHERE type.name = 'butter'),
  '25-08-2018',
  '6.03'
);

-- inserts product milk
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Vitamin D Milk',
  (SELECT id FROM type WHERE type.name = 'butter'),
  '25-09-2018',
  '6.90'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Whole Milk',
  (SELECT id FROM type WHERE type.name = 'butter'),
  '25-10-2018',
  '10.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Organic Lowfat Milk',
  (SELECT id FROM type WHERE type.name = 'butter'),
  '25-08-2018',
  '5.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Fat Free Milk',
  (SELECT id FROM type WHERE type.name = 'butter'),
  '25-09-2018',
  '8.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Instant Nonfat Dry Milk',
  (SELECT id FROM type WHERE type.name = 'butter'),
  '02-10-2018',
  '6.03'
);

-- inserts product ice cream
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Candy Cane ice cream',
  (SELECT id FROM type WHERE type.name = 'ice cream'),
  '25-08-2018',
  '2.34'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Cherry ice cream',
  (SELECT id FROM type WHERE type.name = 'ice cream'),
  '02-09-2018',
  '1.50'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Hokey Pokey',
  (SELECT id FROM type WHERE type.name = 'ice cream'),
  '05-09-2018',
  '2.90'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Mango ice cream',
  (SELECT id FROM type WHERE type.name = 'ice cream'),
  '15-09-2018',
  '2.34'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Mamey ice cream',
  (SELECT id FROM type WHERE type.name = 'ice cream'),
  '09-11-2018',
  '2.33'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Sesame',
  (SELECT id FROM type WHERE type.name = 'ice cream'),
  '12-10-2018',
  '5.11'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Spumoni',
  (SELECT id FROM type WHERE type.name = 'ice cream'),
  '12-09-2018',
  '3.10'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Salted Caramel',
  (SELECT id FROM type WHERE type.name = 'ice cream'),
  '08-09-2018',
  '2.60'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Tutti frutti',
  (SELECT id FROM type WHERE type.name = 'ice cream'),
  '28-08-2018',
  '4.32'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Raspberry Ripple',
  (SELECT id FROM type WHERE type.name = 'ice cream'),
  '25-08-2018',
  '2.25'
);

-- inserts product cheese
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Mozzarella',
  (SELECT id FROM type WHERE type.name = 'cheese'),
  '25-09-2018',
  '18.60'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Sharp cheddar',
  (SELECT id FROM type WHERE type.name = 'cheese'),
  '21-09-2018',
  '11.32'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Brie',
  (SELECT id FROM type WHERE type.name = 'cheese'),
  '11-10-2018',
  '18.89'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Feta',
  (SELECT id FROM type WHERE type.name = 'cheese'),
  '15-08-2018',
  '19.56'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Gouda cheese',
  (SELECT id FROM type WHERE type.name = 'cheese'),
  '08-11-2018',
  '23.99'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Monterey Jack',
  (SELECT id FROM type WHERE type.name = 'cheese'),
  '25-09-2018',
  '14.65'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Muenster cheese',
  (SELECT id FROM type WHERE type.name = 'cheese'),
  '26-09-2018',
  '18.45'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Blue cheese',
  (SELECT id FROM type WHERE type.name = 'cheese'),
  '15-09-2018',
  '23.36'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Camembert',
  (SELECT id FROM type WHERE type.name = 'cheese'),
  '03-08-2018',
  '16.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Cheddar cheese',
  (SELECT id FROM type WHERE type.name = 'cheese'),
  '22-11-2018',
  '19.03'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Gorgonzola',
  (SELECT id FROM type WHERE type.name = 'cheese'),
  '22-08-2018',
  '11.37'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Goat cheese',
  (SELECT id FROM type WHERE type.name = 'cheese'),
  '28-09-2018',
  '21.33'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Cream cheese',
  (SELECT id FROM type WHERE type.name = 'cheese'),
  '21-09-2018',
  '10.23'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Grana Padano',
  (SELECT id FROM type WHERE type.name = 'cheese'),
  '22-08-2018',
  '50.56'
);
INSERT INTO product(name, type_id, expired_date, price) VALUES (
  'Vacherin',
  (SELECT id FROM type WHERE type.name = 'cheese'),
  '21-09-2018',
  '18.23'
);