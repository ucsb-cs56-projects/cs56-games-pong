package edu.ucsb.cs56.projects.games.pong.gameplay;

import java.awt.Graphics;
import edu.ucsb.cs56.projects.games.pong.menu.PlayTextComponent;
import java.io.*;
/** edu.ucsb.cs56.projects.games.pong.gameplay.Difficultylevel is the class that holds the diffulty and other parameters associated with varying difficulty levels
 @author Millan Batra, Alex Ngo
 @version CS56, Winter 2016, UCSB
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
    
    public DifficultyLevel(int difficultylevel)
    {
    diflevel=difficultylevel;
    if(diflevel==80)//supereasy
	{
	    screenfactor=10;
	    width=origballsize*screenfactor;
	    height=origballsize*screenfactor;
	}
    else if(diflevel==100)//easy
	{
	    screenfactor=8;
	    width=origballsize*screenfactor;
	    height=origballsize*screenfactor;
	}
    else if(diflevel==120)//medium
	{
	    screenfactor=6;
	    width=origballsize*screenfactor;
	    height=origballsize*screenfactor;
	}
    else if(diflevel==130)//hard
	{
	    screenfactor=4;
	    width=origballsize*screenfactor;
	    height=origballsize*screenfactor;
	}
    else if(diflevel==140)//extreme
	{
	    screenfactor=2;
	    width=origballsize*screenfactor;
	    height=origballsize*screenfactor;
	}
    else if(diflevel==170)//chaos
	{
	    screenfactor=1;
	    width=origballsize*screenfactor;
	    height=origballsize*screenfactor;
	}
    }
    public int getDifficulty()
    {
	return diflevel;
    }
    public int getNewHeight()
    {
	return height;
    }
    public int getNewWidth()
    {
	return height;
    }
    public int getScreenFactor()
    {
	return screenfactor;
    }
}
