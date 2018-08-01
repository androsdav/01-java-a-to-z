-- select
SELECT car.id, car.name, car.body_id, car.transmission_id, car.engine_id, engine.name AS engine
  FROM car, engine
  WHERE car.engine_id = engine.id
;
-- INNER JOIN
SELECT car.id, car.name, car.body_id, car.transmission_id, car.engine_id, engine.name AS engine
  FROM car
  INNER JOIN engine ON (car.engine_id = engine.id)
;
-- LEFT OUTER JOIN
SELECT car.id, car.name, car.body_id, car.transmission_id, car.engine_id, engine.name AS engine
  FROM car
  LEFT OUTER JOIN engine ON (car.engine_id = engine.id)
;

-- RIGHT OUTER JOIN
SELECT car.id, car.name, car.body_id, car.transmission_id, car.engine_id, engine.name AS engine
  FROM car
  RIGHT OUTER JOIN engine ON (car.engine_id = engine.id)
;

-- FULL OUTER JOIN
SELECT car.id, car.name, car.body_id, car.transmission_id, car.engine_id, engine.name AS engine
FROM car
  FULL OUTER JOIN engine ON (car.engine_id = engine.id)
;

-- CROSS JOIN
SELECT car.id, car.name, car.body_id, car.transmission_id, car.engine_id, engine.name AS engine
FROM car
  CROSS JOIN engine
;



-- RIGHT OUTER JOIN
SELECT car.id, car.name, car.body_id, car.transmission_id, car.engine_id, body.name AS engine
  FROM car
  RIGHT OUTER JOIN body ON (car.body_id = body.id)
;



-- INNER JOIN
SELECT engine.id, engine.name, car.name AS car
  FROM engine
  INNER JOIN car ON (car.engine_id = engine.id)
;





-- selects all product by type of product cheese
SELECT product.id, product.name, product.type_id, product.expired_date, product.price,
  (SELECT type.name AS type FROM type WHERE type.name = 'cheese')
  FROM product
  WHERE product.type_id IN (SELECT type.id FROM type WHERE type.name = 'cheese')
  ORDER BY product.price
;

-- selects all product by type of product cheese
SELECT product.id, product.name, product.type_id, product.expired_date, product.price,
  (SELECT type.name AS type FROM type WHERE type.name = 'ice cream')
  FROM product
  WHERE product.name LIKE '%ice%cream%'
  ORDER BY product.expired_date
;

-- selects all the goods whose expiry date ends next month
SELECT product.id, product.name, product.type_id, product.expired_date, product.price,
  (SELECT type.name AS type FROM type WHERE type.id = product.type_id)
  FROM product
  WHERE product.expired_date > '31-07-2018' AND product.expired_date < '01-09-2018'
  ORDER BY product.expired_date
;

-- selects product with maximum price
SELECT product.id, product.name, product.type_id, product.expired_date, product.price,
  (SELECT type.name AS type FROM type WHERE type.id = product.type_id)
  FROM product
  WHERE product.price IN (SELECT MAX(product.price) FROM product)
;

-- count all product one type
SELECT COUNT(*) AS count_all_beer FROM product
  WHERE product.type_id IN (SELECT type.id FROM type WHERE type.name = 'beer')
;

-- selects all product of type milk and cheese
SELECT product.id, product.name, product.type_id, product.expired_date, product.price,
  (SELECT type.name AS type FROM type WHERE type.id = product.type_id)
  FROM product
  WHERE product.type_id IN ((SELECT type.id FROM type WHERE type.name = 'cheese'),
  (SELECT type.id FROM type WHERE type.name = 'milk'))
  ORDER BY product.id
;

-- select type of products which are less than 10
SELECT type.id, type.name FROM type
  WHERE (SELECT COUNT(*) FROM product WHERE product.type_id = type.id) < 10
;

-- selects all product and adds column of product type
SELECT product.id, product.name, product.type_id, product.expired_date, product.price,
  (SELECT type.name AS type FROM type WHERE type.id = product.type_id)
  FROM product
;