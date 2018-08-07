-- add item 'selling laptop'
INSERT INTO item (name, description, create_date) VALUES (
  'selling laptop',
  'I wont to sell laptop. Laptop not bad.',
  '10-09-2018')
;


UPDATE item SET name = 'task_test', description = 'desc_test', create_date = '10-09-2008' WHERE id = 1;



-- add item 'buy bicycle'
INSERT INTO item (name) VALUES ('buy bicycle');
-- add item 'locking for job'
INSERT INTO item (name) VALUES ('locking for job');
-- add item 'locking for job'
INSERT INTO item (name) VALUES ('search table');