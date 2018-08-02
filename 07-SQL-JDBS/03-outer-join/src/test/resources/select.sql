-- INNER JOIN for tables: car, body, engine and transmission
SELECT c.id, c.name, b.name AS body, e.name AS engine, t.name AS transmission FROM car AS c
  INNER JOIN body AS b ON (b.id = c.body_id)
  INNER JOIN engine AS e ON (c.engine_id = e.id)
  INNER JOIN transmission AS t ON (c.transmission_id = t.id)
  ORDER BY c.id
;

-- LEFT OUTER JOIN - selects all type body of car don`t uses
SELECT body.id, body.name FROM body
  LEFT OUTER JOIN car ON car.body_id = body.id WHERE car.id IS NULL
;

-- LEFT OUTER JOIN - selects all type engine of car don`t uses
SELECT engine.id, engine.name FROM engine
  LEFT OUTER JOIN car ON car.engine_id = engine.id WHERE car.id IS NULL
;

-- LEFT OUTER JOIN - selects all type transmission of car don`t uses
SELECT transmission.id, transmission.name FROM transmission
  LEFt OUTER JOIN car ON car.transmission_id = transmission.id WHERE car.id IS NULL
;