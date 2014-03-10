package edu.ucsb.cs56.projects.games.pong; 

import javax.swing.*;
import java.awt.*;
import java.awt.BasicStroke;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color; // class for Colors
import java.awt.Graphics;
import java.awt.Rectangle;  // squares and rectangles
import java.awt.Shape; // general class for shapes
import java.awt.Stroke;
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.geom.Ellipse2D;  // ellipses and circles
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.Line2D;  // single lines 
import java.awt.geom.Rectangle2D; // for the bounding box

/** edu.ucsb.cs56.projects.games.pong.Ball is the class that will move the ball around the screen
 @author Timothy Fok  
 @author Sanchit Gupta, Bhanu Khanijau
 @author Jake Dumont, Heneli Kailahi
 @author Benjamin Hartl, Sarah Darwiche
 @version CS56, Spring 2013, UCSB                   
*/
public class Ball extends gameObject {

    public int ballsLost;
                                                
    /** edu.ucsb.cs56.projects.games.pong.Ball constructor to initialize location of edu.ucsb.cs56.projects.games.pong.Ball onto the screen
     *  and draw it as a rectangle for a simpler and precise hitbox.
     *  @param x set initial x coordinate of ball
     *  @param y set initial y coordinate of ball 
     *  @param w set initial w of ball
     *  @param h set initial h of ball
     */

    public Ball( int x, int y, int w, int h )
    {
	super( x, y, w, h );	
      	//ballsLost = 0;
	startBall();
    }

    public void draw( Graphics g )
    {
	g.setColor( getRandomColor() );
	g.fillOval( getXCoordinate(), getYCoordinate(), 
		    getWidth(), getHeight() );
    }

    public void startBall()  // true goes right
    {
	int speed = 3;
	if( gameObject.isGoingRight == false )
	    speed = -3;
	setXVelocity( speed );
	setYVelocity( speed );
    }
    
    public boolean isStopped()
    {
	if( ( getXVelocity() == 0 ) && ( getYVelocity() == 0 ) )
	    return true;
	else 
	    return false;
    }

    public void stopBall()
    {
	setYVelocity( 0 );
	setXVelocity( 0 );
    }
    
    public void resetBall() 
    {
	stopBall();
	setXCoordinate( Screen.w / 2 );
	setYCoordinate( Screen.h / 2 );
    }
}
