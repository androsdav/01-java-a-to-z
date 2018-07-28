-- select
SELECT * FROM type;
SELECT * FROM product;

SELECT * FROM product,
  WHERE type_id = (SELECT type.id FROM type WHERE type.name = 'cheese')
;

SELECT * FROM product
  WHERE name = '%ice%cream%'
;


-- select all item
SELECT item.id, item.name,
  (SELECT "user".name FROM "user" WHERE "user".id = item.user_id),
  (SELECT state.name FROM state WHERE state.id = item.state_id),
  (SELECT category.name FROM category WHERE category.id = item.category_id)
  FROM item
;

-- select all comments where item = 'selling laptop'
SELECT comments.name,
  (SELECT item.name FROM item WHERE item.id = comments.item_id),
  (SELECT "user".name FROM "user" WHERE "user".id = comments.user_id)
  FROM comments
  WHERE item_id = (SELECT item.id FROM item WHERE item.name = 'selling laptop')
;

-- select all comments where item = 'buy bicycle'
SELECT comments.name,
  (SELECT item.name FROM item WHERE item.id = comments.item_id),
  (SELECT "user".name FROM "user" WHERE "user".id = comments.user_id)
  FROM comments
  WHERE item_id = (SELECT item.id FROM item WHERE item.name = 'buy bicycle')
;