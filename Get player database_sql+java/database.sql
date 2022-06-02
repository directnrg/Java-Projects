create table player
(player_id integer not null primary key,
first_name varchar2(50),
last_name varchar2(50),
address varchar2(100),
postal_code varchar2 (6),
province varchar2 (30),
phone_number varchar2 (13)
);

create table game
(game_id integer not null primary key,
game_title varchar (100)
);

create table PlayerAndGame
(player_game_id integer,
game_id integer,
player_id integer,
playing_date date,
score integer, 

FOREIGN KEY (game_id) references game(game_id),
FOREIGN KEY (player_id) references player (player_id)
);

--sequence for primary key player_id 
CREATE SEQUENCE new_player_id
START WITH 2
INCREMENT BY 1
NOCACHE
NOMAXVALUE;

--trigger before insert primary key player_id 
CREATE OR REPLACE TRIGGER new_player_insert
  BEFORE INSERT ON player
  FOR EACH ROW
BEGIN
  SELECT new_player_id.nextval
  INTO :new.player_id
  FROM dual;
END;

--sequence for primary key game_id 
CREATE SEQUENCE new_game_id
START WITH 2
INCREMENT BY 1
NOCACHE
NOMAXVALUE;

--trigger before insert primary key game_id 
CREATE OR REPLACE TRIGGER new_game_insert
  BEFORE INSERT ON game
  FOR EACH ROW
BEGIN
  SELECT new_game_id.nextval
  INTO :new.game_id
  FROM dual;
END;

--sequence for primary key game_id 
CREATE SEQUENCE new_playerandgame_id
START WITH 1
INCREMENT BY 1
NOCACHE
NOMAXVALUE;

--trigger before insert primary key game_id 
CREATE OR REPLACE TRIGGER new_playerandgame_insert
  BEFORE INSERT ON playerandgame
  FOR EACH ROW
BEGIN
  SELECT new_playerandgame_id.nextval
  INTO :new.player_game_id
  FROM dual;
END;

 alter SESSION set NLS_DATE_FORMAT = 'DD-MM-YYYY' 
 
INSERT INTO playerandgame (game_id, player_id, playing_date, score) VALUES(1,1,TO_DATE('20-12-2020','DD-MM-YYYY'),2000)
