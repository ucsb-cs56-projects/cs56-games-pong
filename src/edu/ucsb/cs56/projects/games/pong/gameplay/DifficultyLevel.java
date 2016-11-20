package edu.ucsb.cs56.projects.games.pong.gameplay;
/** edu.ucsb.cs56.projects.games.pong.gameplay.Difficultylevel is the class that holds the diffculty and other parameters associated with varying difficulty levels
 @author Millan Batra, Alex Ngo
 @version CS56, Fall 2016, UCSB
*/

public class DifficultyLevel
{
    /*
    @param difficultylevel
    */
    public static int diflevel;
    public static int screenfactor;
    public static int width;
    public static int height;
    public static int origballsize=5;
    public static int paddleHeight;
    public static int numBalls = 1;
    
    public DifficultyLevel(int difficultylevel)
    {
    diflevel=difficultylevel;
    if(diflevel==80)//supereasy
	{
	    screenfactor=10;
	    width=origballsize*screenfactor;
	    height=origballsize*screenfactor;
	    paddleHeight = 110;
	}
    else if(diflevel==100)//easy
	{
	    screenfactor=8;
	    width=origballsize*screenfactor;
	    height=origballsize*screenfactor;
	    paddleHeight = 100;
	}
    else if(diflevel==120)//medium
	{
	    screenfactor=6;
	    width=origballsize*screenfactor;
	    height=origballsize*screenfactor;
	    paddleHeight = 90;
	}
    else if(diflevel==130)//hard
	{
	    screenfactor=4;
	    width=origballsize*screenfactor;
	    height=origballsize*screenfactor;
	    paddleHeight = 80;
	}
    else if(diflevel==140)//extreme
	{
	    screenfactor=2;
	    width=origballsize*screenfactor;
	    height=origballsize*screenfactor;
	    paddleHeight = 70;

	}
    else if(diflevel==170)//chaos
	{
	    screenfactor=1;
	    width=origballsize*screenfactor;
	    height=origballsize*screenfactor;
	    paddleHeight = 60;

	}
    else if (diflevel == 90) 
    {
    	screenfactor=10;
	    width=origballsize*screenfactor;
	    height=origballsize*screenfactor;
	    paddleHeight = 100;
	    numBalls = 2;
    }
    }
    
    public static int getDifficulty() { return diflevel; }
    public static int getHeight() { return height; }
    public static int getWidth() { return width; }
    public static int getScreenFactor() { return screenfactor; }
    public static int getPaddleHeight() { return paddleHeight; }
    public static int getNumOfBalls() {return numBalls; }
}
