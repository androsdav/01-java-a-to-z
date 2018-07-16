
DROP TABLE music_lover_compose;
DROP TABLE music_lover;
DROP TABLE compose;
DROP TABLE author;
--/
-- create table author
CREATE TABLE  author (
  id SERIAL PRIMARY KEY,
  name VARCHAR(200)
);

-- create table compose
CREATE TABLE compose (
  id SERIAL PRIMARY KEY,
  name VARCHAR(200),
  author_id INT REFERENCES author(id)
);

CREATE TABLE music_lover (
  id SERIAL PRIMARY KEY,
  name VARCHAR(200)
);

CREATE TABLE music_lover_compose (
  id SERIAL PRIMARY KEY,
  music_lover_id INT REFERENCES music_lover(id),
  compose_id INT REFERENCES compose(id)
);

INSERT INTO author (name) VALUES
  ('Jackson');
INSERT INTO author (name) VALUES
  ('Sting');
INSERT INTO author (name) VALUES
  ('Nirvana');
INSERT INTO author (name) VALUES
  ('Metallica');

INSERT INTO compose (name, author_id) VALUES
  ('Thriller', (SELECT id FROM author WHERE name = 'Jackson'));

INSERT INTO music_lover (name) VALUES
  ('meloman1');

INSERT INTO music_lover_compose (music_lover_id, compose_id) VALUES
((SELECT id FROM music_lover WHERE name = 'meloman1'),
 (SELECT id FROM compose WHERE name = 'Thriller')

);

SELECT * FROM author;
SELECT * FROM compose;
SELECT * FROM music_lover;
SELECT compose.name, music_lover.name, music_lover_compose.* FROM music_lover_compose, compose, music_lover
WHERE compose.id = music_lover_compose.compose_id AND music_lover.id = music_lover_compose.music_lover_id;
