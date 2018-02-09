## Samuel Fu, Xingxing Geng
- Samuel Fu (GitHubID:`iamSamuelFu`)
- Xingxing Geng (GitHubID:'`xingxinggeng`)

## A)
This project builds up a game simulating table tennis, which can have most up to 2 players playing at the same time on the same computer.

## B)
- As a user, I can start a new game so I can play against another player on the same computer.
- As a user, I can choose the color of the ping pong ball and the difficulty level of the game before I start a new game.
- As a user, I can control the paddle to hit or hold the ball.
- As a user, I can lose a life if I let the ball get past by my paddle.
- As a user, I can store my name and my score in this game if I made top five highest scores.

## C)
The software definitely runs. It creates a rectangle panel in the middle of the screen to provide an interface for users, allowing them to start a new game, check the instructions or exit. It simulates the game of table tennis, putting two paddles on both sides and a ball bouncing between.

## D)
- As a user, I would like to be able to throw a curving ball.
- As a user, I would like to be able to adjust the size of the screen when the program is running.

## E)
Current README.md does a great job both introducing this game and tracing through the development and improvements of this program. It is really helpful for me to get to know this program and how to maintain it. However, I think a collection of pictures from each version can be added into the file, to display the development of this game more visually.

## F)
The build.xml is a little bit messy in formatting but runnable. Some targets needs description, but there is no JWS stuff needs to be removed.

## G)
The "issues" listed pointed out many possibilities this game could turn into. All the bugs and improvements in "issues" are explained in details respectively. There are definitely enough questions for us to earn 1000 points, though some of the issues are minor.

## H)
Hit star to gain life :https://github.com/ucsb-cs56-projects/cs56-games-pong/issues/100

## I)
The code overall is formatted well, and the purposes of class and methods of are clear. The variable names are mostly self-documenting. However, there are more comments than it actually needs. It makes the code easier to read within their own class, but some comments only explained what the code does, instead of why we use this code. Therefore, it is difficult to see the relationship between classes without the class diagram. I would tell whoever is going to work on the code that each object in this game (such as "paddle," "pong," and "game") was coded in seperate file under the same directory. Each file implements what each object does. It will be easier to understand the code by figuring out what object the method belongs to.

## J)
The test coverage is very limited, and there is no JUnit tests at all. There are only handful of tests, and most of them are commented out for unknown reasons. The coverage can be expanded by adding more tests of some basic methods in each class and some corner cases on top of that. 

