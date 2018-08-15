-- insert to table body
INSERT INTO body(name) VALUES ('Sedan');
INSERT INTO body(name) VALUES ('Universal');
INSERT INTO body(name) VALUES ('Hatchback');
INSERT INTO body(name) VALUES ('Coupe');
INSERT INTO body(name) VALUES ('Limousine');
INSERT INTO body(name) VALUES ('Minivan');
INSERT INTO body(name) VALUES ('Hardtop');
INSERT INTO body(name) VALUES ('Liftback');

-- insert to table transmission
INSERT INTO transmission(name) VALUES ('Manual');
INSERT INTO transmission(name) VALUES ('Fully automatic');
INSERT INTO transmission(name) VALUES ('Semi-Automatic');
INSERT INTO transmission(name) VALUES ('CVT');

-- insert to table engine
INSERT INTO engine(name) VALUES ('VEE');
INSERT INTO engine(name) VALUES ('Inline');
INSERT INTO engine(name) VALUES ('Straight');
INSERT INTO engine(name) VALUES ('VR type');
INSERT INTO engine(name) VALUES ('W type');
INSERT INTO engine(name) VALUES ('Boxer');
INSERT INTO engine(name) VALUES ('Brotary');

-- insert to table car
INSERT INTO car(name, body_id, transmission_id ,engine_id) VALUES (
  'Mercedes',
  (SELECT body.id FROM body WHERE body.name = 'Coupe'),
  (SELECT transmission.id FROM transmission WHERE transmission.name = 'Manual'),
  (SELECT engine.id FROM engine WHERE engine.name = 'W type')
);
INSERT INTO car(name, body_id, transmission_id ,engine_id) VALUES (
  'BMW',
  (SELECT body.id FROM body WHERE body.name = 'Sedan'),
  (SELECT transmission.id FROM transmission WHERE transmission.name = 'CVT'),
  (SELECT engine.id FROM engine WHERE engine.name = 'Boxer')
);
INSERT INTO car(name, body_id, transmission_id ,engine_id) VALUES (
  'Opel',
  (SELECT body.id FROM body WHERE body.name = 'Universal'),
  (SELECT transmission.id FROM transmission WHERE transmission.name = 'Fully automatic'),
  (SELECT engine.id FROM engine WHERE engine.name = 'Inline')
);
INSERT INTO car(name, body_id, transmission_id ,engine_id) VALUES (
  'Alfa Romeo',
  (SELECT body.id FROM body WHERE body.name = 'Limousine'),
  (SELECT transmission.id FROM transmission WHERE transmission.name = 'Manual'),
  (SELECT engine.id FROM engine WHERE engine.name = 'W type')
);
INSERT INTO car(name, body_id, transmission_id ,engine_id) VALUES (
  'Jeep',
  (SELECT body.id FROM body WHERE body.name = 'Hardtop'),
  (SELECT transmission.id FROM transmission WHERE transmission.name = 'Fully automatic'),
  (SELECT engine.id FROM engine WHERE engine.name = 'Inline')
);
INSERT INTO car(name, body_id, transmission_id ,engine_id) VALUES (
  'Audi',
  (SELECT body.id FROM body WHERE body.name = 'Coupe'),
  (SELECT transmission.id FROM transmission WHERE transmission.name = 'CVT'),
  (SELECT engine.id FROM engine WHERE engine.name = 'Brotary')
);
INSERT INTO car(name, body_id, transmission_id ,engine_id) VALUES (
  'Mazda',
  (SELECT body.id FROM body WHERE body.name = 'Hatchback'),
  (SELECT transmission.id FROM transmission WHERE transmission.name = 'Manual'),
  (SELECT engine.id FROM engine WHERE engine.name = 'W type')
);
INSERT INTO car(name, body_id, transmission_id ,engine_id) VALUES (
  'Toyota',
  (SELECT body.id FROM body WHERE body.name = 'Limousine'),
  (SELECT transmission.id FROM transmission WHERE transmission.name = 'Fully automatic'),
  (SELECT engine.id FROM engine WHERE engine.name = 'Inline')
);
INSERT INTO car(name, body_id, transmission_id ,engine_id) VALUES (
  'Honda',
  (SELECT body.id FROM body WHERE body.name = 'Coupe'),
  (SELECT transmission.id FROM transmission WHERE transmission.name = 'Manual'),
  (SELECT engine.id FROM engine WHERE engine.name = 'W type')
);
INSERT INTO car(name, body_id, transmission_id ,engine_id) VALUES (
  'Lexus',
  (SELECT body.id FROM body WHERE body.name = 'Hardtop'),
  (SELECT transmission.id FROM transmission WHERE transmission.name = 'Fully automatic'),
  (SELECT engine.id FROM engine WHERE engine.name = 'Boxer')
);
INSERT INTO car(name, body_id, transmission_id ,engine_id) VALUES (
  'Infinity',
  (SELECT body.id FROM body WHERE body.name = 'Sedan'),
  (SELECT transmission.id FROM transmission WHERE transmission.name = 'CVT'),
  (SELECT engine.id FROM engine WHERE engine.name = 'Inline')
);