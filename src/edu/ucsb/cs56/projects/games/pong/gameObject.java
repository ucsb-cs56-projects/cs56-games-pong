package edu.ucsb.cs56.projects.games.pong;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class gameObject{
    public int xVelocity;
    public int yVelocity;
    static boolean isGoingRight = false;
    public Rectangle rectangle;


    gameObject() {  }            // Default, not used
    gameObject( int x, int y )   // used by p1, it does on the left 
    {    
	//  Calls the other Constructor below with this( )
	this( x, y, 10, Paddle.paddleHeight ); // paddleHeight is static
    }
    
    // called by on
    gameObject( int x, int y, int rectW, int rectH )
    {
	setXVelocity( 0 );
	setYVelocity( 0 );
	rectangle = new Rectangle( x, y, rectW, rectH );
    }
    
    public int getXCoordinate() { return rectangle.x; }
    public void setXCoordinate( int x ) { rectangle.x = x; }

    public int getYCoordinate() { return rectangle.y; }
    public void setYCoordinate( int y ) { rectangle.y = y; }

    public int getWidth() { return rectangle.width; }
    public void setWidth( int w ) { rectangle.width = w; }

    public int getHeight() { return rectangle.height; }
    public void setHeight( int h ) { rectangle.height = h; }

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

    
