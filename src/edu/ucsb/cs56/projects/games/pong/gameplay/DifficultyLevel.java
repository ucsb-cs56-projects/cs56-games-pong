package edu.ucsb.cs56.projects.games.pong.gameplay;
/** edu.ucsb.cs56.projects.games.pong.gameplay.Difficultylevel is the class that holds the diffculty and other parameters associated with varying difficulty levels
 * @author Millan Batra, Alex Ngo
 * @author Andrew Polk, Victoria Sneddon
 * @version CS56, Fall 2017, UCSB
 */

public class DifficultyLevel
{
    /*
    @param difficultylevel
    */
    /** The game difficulty level */
    public static int diflevel;
    /** The screen multiplier factor */
    public static int screenfactor;
    /** New screen width */
    public static int width;
    /** New screen height */
    public static int height;
    /** The original size of the ball */
    public static int origballsize=5;
    /** New paddle height */
    public static int paddleHeight;
    /** New ball speed */
    public static int speed;
    
    /** edu.ucsb.cs56.projects.games.pong.gameplay.DifficultyLevel constructor to initialize difficulty of game onto the screen 
    * @param difficultylevel set game difficulty    
    */

    // Constructor
    // inputs are game difficulty [80,100,120,130,140,170,90]
    public DifficultyLevel(int difficultylevel)
    {
    diflevel=difficultylevel;
    if(diflevel==80)//supereasy
	{
	    screenfactor=10;
	    width=origballsize*screenfactor;
	    height=origballsize*screenfactor;
	    paddleHeight = 110;
	    speed = 1;
	}
    else if(diflevel==100)//easy
	{
	    screenfactor=8;
	    width=origballsize*screenfactor;
	    height=origballsize*screenfactor;
	    paddleHeight = 100;
	    speed = 2;
	}
    else if(diflevel==120)//medium
	{
	    screenfactor=6;
	    width=origballsize*screenfactor;
	    height=origballsize*screenfactor;
	    paddleHeight = 90;
	    speed = 3;
	}
    else if(diflevel==130)//hard
	{
	    screenfactor=4;
	    width=origballsize*screenfactor;
	    height=origballsize*screenfactor;
	    paddleHeight = 80;
	    speed = 3;
	}
    else if(diflevel==140)//extreme
	{
	    screenfactor=2;
	    width=origballsize*screenfactor;
	    height=origballsize*screenfactor;
	    paddleHeight = 70;
	    speed = 4;
	}
    else if(diflevel==170)//chaos
	{
	    screenfactor=1;
	    width=origballsize*screenfactor;
	    height=origballsize*screenfactor;
	    paddleHeight = 60;
	    speed = 5;

	}
    else if (diflevel == 90) 
    {
    	screenfactor=10;
	    width=origballsize*screenfactor;
	    height=origballsize*screenfactor;
	    paddleHeight = 100;
	    speed = 2;
    }
    }
    
    /** getDifficulty() returns the current difficulty of the game */
    public static int getDifficulty() { return diflevel; }
    /** getHeight() returns the screen height based on difficulty */
    public static int getHeight() { return height; }
    /** getWidth() returns the screen width based on difficulty */
    public static int getWidth() { return width; }
    /** getScreenFactor() returns the multiply factor of the screen size */
    public static int getScreenFactor() { return screenfactor; }
    /** getPaddleHeight() returns the height height based on difficulty */
    public static int getPaddleHeight() { return paddleHeight; }
    /** getSpeed() returns the ball speed based on difficulty */
    public static int getSpeed() {return speed; }
}
