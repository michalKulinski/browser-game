## Browser game - readme


**Start app**

To launch application you can just run it in your IDE or you commandline and *java -jar browser-game-0.0.1-SNAPSHOT.jar

Open Postman or similar tool to check endpoints and features of application.

Application in default works on port 8080
http://localhost:8080


**Authentication**

To authenticate user please use following credentials as a form-data:
username = user
password = password

http://localhost:8080/api/login?username=user&password=password

Note that if you are unauthorize you cannot use application content


**Players**

Players are added by sql statement in data.sql file


INSERT INTO player (first_name, last_name) VALUES
  ('Anna', 'Nowak'),
  ('Bill', 'Gates'),
  ('Karol', 'Kiepski');
  
  
There you can find 3 predefinied players (it is up to you if you want to extend it)

To see data of players you can use following endpoints:

all players
/api/players

player by id

/api/players/{id}


**Play game**

Lets make couple of gameplays

Send POST message to:
/api/playgame

with content body in json:

{
    "playerId": 2,
    "score": 3365
}


**LeaderBoard**

There are four possibility to see leaderboard

Whole Leaderboard
/api/leaderboard


Daily Leaderboard
/api/leaderboard/daily


Weekly Leaderboard
/api/leaderboard/weekly


Yearly Leaderboard
/api/leaderboard/yearly


To make a full test of above endpoints you have to edit timestamp in database - table 'GAME'

H2 console you can find here:
/h2-console


H2 database is configured in application.properties file



