package edu.ucsb.cs56.projects.games.pong;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class gameObject{
    
    public int xVelocity;                  // speed horizontally
    public int yVelocity;                  // speed vertically
    static boolean isGoingRight = false;   // direction of the ball
    public Rectangle rectangle;            // holds the x and y coordinates
                                           //   as well as width and height

    gameObject() {  }            // Default, not used

    // Used by both the Paddles, so all paddles are the same size
    gameObject( int x, int y ) 
    {    
	this( x, y, 10, Paddle.paddleHeight ); // paddleHeight is static
    }
    
    // Used to set coordinates and size, used by subclasses Ball and Paddle
    gameObject( int x, int y, int rectW, int rectH )
    {
	setXVelocity( 0 );
	setYVelocity( 0 );
	rectangle = new Rectangle( x, y, rectW, rectH );
    }
    
    // ( x, y ) coordinates are to the upper left hand corner

    // The x Coordinate to the left hand side
    public int getXCoordinate()         { return rectangle.x; }
    public void setXCoordinate( int x ) { rectangle.x = x; }

    // The y Coordinate to the top
    public int getYCoordinate()         { return rectangle.y; }
    public void setYCoordinate( int y ) { rectangle.y = y; }

    // Stored in the rectangle
    public int getWidth()               { return rectangle.width; }
    public void setWidth( int w )       { rectangle.width = w; }

    // Stored in the rectangle
    public int getHeight()              { return rectangle.height; }
    public void setHeight( int h )      { rectangle.height = h; }

    public int getXVelocity()           { return xVelocity; }
    public void setXVelocity( int dx )  { xVelocity = dx; }

    public int getYVelocity()           { return yVelocity; }
    public void setYVelocity( int dy )  { yVelocity = dy; }

    public Color getRandomColor()
    {
	int red = (int) (Math.random() * 250);
	int green = (int) (Math.random() * 250);
	int blue  = (int) (Math.random() * 250);

	return ( new Color( red, green, blue ) );
    }
}

    
