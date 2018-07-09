
CREATE TABLE human (
  id SERIAL PRIMARY KEY,
  first_name VARCHAR(20),
  second_name VARCHAR(20)
);

INSERT INTO human (first_name, second_name) VALUES ('Alex', 'Svistun');
INSERT INTO human (first_name, second_name) VALUES ('Bob', 'Marly');
INSERT INTO human (first_name, second_name) VALUES ('Bil', 'While');

SELECT * FROM human;