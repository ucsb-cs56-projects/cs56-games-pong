Pong
==============

TODO: maybe add a few more tickets, most of the existing ones wouldn't take much time to implement.  Other than that it builds and runs fine (David Coffill)

project history
===============

### Fall 2016 final remarks
TODO: 
* Add instructions for the ball grabbing feature, we implemented it so that holding "a" when the ball is within close range of the left paddle grabs the balls, and "left arrow" grabs the balls when they are in range of the right paddle. 

* Fix the ball colliding with the top/bottom wall when grabbing the ball with paddle (play around with this and you will clearly see the issue)
* Fix how the game recognizes pausing when the ball is attached
* Integrate two balls with all the difficulty modes and extra balls

How To Play:
Player 1 (on the left)
  "W" -- Move up
  "S" -- Move down
  "a" -- grab ball (hold to grab)

Player 2 (on the right)
  up arrow -- Move up
  down arrow -- Move down
  left arrow -- grab ball (hold to grab)
  SUGGESTIONS 
  Integrate grab paddle with thread so that it when the user presses either "a" or "left arrow", the game processes it right as the ball and paddle collide. (right now we are using distance which allows you to grab the ball while it isn't touching the paddle)
  Refactor how the two balls is implemented so that multiple balls will be easier to work with (in the code)

### W16 final remarks

`W16: Angel Ortega, Ben Patient, 4PM lab`

* What the code does:
  * The code is a simple game of Pong for two players, with scores.
* Features that could be added:
  * AI for the paddle
  * Multiple ball modes
  * Unit-tests
* What bugs exist:
  * Pausing does not pause the paddles
* Opportunities for refactoring:
  * Make variables private, prefer to use nonstatic variables
  * Remove coupling
  * Consider builder pattern for GUI creation

### W14 remarks
```
 W14 | bronhuston 4pm | sarahdarwiche,benjaminhartl | An implementation of the classic game Pong, with cooperative multiplayer support.
```

An implementation of the classic game Pong, with cooperative multiplayer support.

To Compile and Run:
"ant run" in the main directory

The three difficulty options correspond to the size of the window when playing.

How To Play:
Player 1 (on the left)
  "W" -- Move up
  "S" -- Move down

Player 2 (on the right)
  up arrow -- Move up
  down arrow -- Move down

When the ball is stopped, Press the spacebar to activate motion.
Try to not let the ball hit your side of the screen or you will lose a life.
The player who wins the round, recieves the total number of hits added to their score.
Each Player has 3 lives.
The Winner is whoever has the most lives at the end, their name will be prompted.
If their score is in the top 5 of the High Score, then it will be saved to the High Score.

![](http://i.imgur.com/NAKKNhR.jpg)
![](http://i.imgur.com/jdCMrej.jpg)
