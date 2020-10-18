DROP TABLE IF EXISTS player;

CREATE TABLE player (
  id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL
);

DROP TABLE IF EXISTS game;

CREATE TABLE game (
    id BIGINT AUTO_INCREMENT  PRIMARY KEY,
    score BIGINT,
    timestamp TIMESTAMP,
    player_id BIGINT,
    foreign key (player_id) references player(id)
);

INSERT INTO player (first_name, last_name) VALUES
  ('Anna', 'Nowak'),
  ('Bill', 'Gates'),
  ('Karol', 'Kiepski');