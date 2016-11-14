package edu.ucsb.cs56.projects.games.pong.gameplay;

import java.awt.Graphics;
import edu.ucsb.cs56.projects.games.pong.menu.PlayTextComponent;
import java.io.*;
/** edu.ucsb.cs56.projects.games.pong.gameplay.Difficultylevel is the class that holds the diffculty and other parameters associated with varying difficulty levels
 @author Millan Batra, Alex Ngo
 @version CS56, Fall 2016, UCSB
*/

public class DifficultyLevel
{
    /**
   // @param origwidth
   // @param origheight
    @param difficultylevel
    */
    private int diflevel;
    private int screenfactor;
    private int width;
    private int height;
    private int origballsize=5;
    private int paddleHeight;
    
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
    }
    public int getDifficulty()
    {
	return diflevel;
    }
    public int getHeight()
    {
	return height;
    }
    public int getWidth()
    {
	return width;
    }
    public int getScreenFactor()
    {
	return screenfactor;
    }
    public int getPaddleHeight()
    {
	return paddleHeight;
    }
}
