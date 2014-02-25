package edu.ucsb.cs56.projects.games.pong;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class gameObject{
    public int xCoordinate;
    public int yCoordinate;
    
    public int xVelocity;
    public int yVelocity;

    gameObject() 
    {
	
	
    }
    gameObject( int x, int y )
    {
	this( x, y, 0, 0 );
    }
    
    gameObject( int x, int y, int dx, int dy )
    {
	setXCoordinate( x );
	setYCoordinate( y );
	setXVelocity( dx );
	setYVelocity( dy );
    }
    
    public int getXCoordinate() { return xCoordinate; }
    public void setXCoordinate( int x ) { xCoordinate = x; }

    public int getYCoordinate() { return yCoordinate; }
    public void setYCoordinate( int y ) { yCoordinate = y; }

    public int getXVelocity() { return xVelocity; }
    public void setXVelocity( int dx ) { xVelocity = dx; }

    public int getYVelocity() { return yVelocity; }
    public void setYVelocity( int dy ) { yVelocity = dy; }

    public Color getRandomColor()
    {
	int red = (int) (Math.random() * 250);
	int green = (int) (Math.random() * 250);
	int blue  = (int) (Math.random() * 250);

	return ( new Color( red, green, blue ) );
    }
}

    
