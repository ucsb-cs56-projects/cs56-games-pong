package edu.ucsb.cs56.projects.games.pong;

import javax.swing.*;
import java.awt.BasicStroke;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color; // class for Colors
import java.awt.Graphics;
import java.awt.Rectangle;  // squares and rectangles      
import java.awt.Shape; // general class for shapes 
import java.awt.Stroke;
import java.awt.geom.*; // 
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.geom.Ellipse2D;  // ellipses and circles
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.Line2D;  // single lines
import java.awt.geom.Rectangle2D; // for the bounding box  


// Timothy Fok
// Sanchit Gupta, Bhanu Khanijau
// Jake Dumont, Heneli Kailahi
// Benjamin Hartl, Sarah Darwiche
// CS56, Winter 2014, UCSB 

//Moves the user-controlled paddle around the screen
public class Paddle extends gameObject{
    public int points;
    public int ballCount;
    public  boolean right;
    public static final Integer paddleHeight = 90; //fixes paddle height at 


    // Paddle contructor to initialize intial x,y placement of paddle
    public Paddle(int x, int y){
	this( x, y, false );
    }

    /** Right paddle constructor to initialize intial x,y placement of paddle
     @param x sets the x position of the paddle
     @param y sets the y position of the paddle
     @param sideRight sees if the paddle is the rightmost paddle
    */

    public Paddle(int x, int y, boolean sideRight){
	super( x, y );
	
	ballCount = 3;
	points = 0;
	right = sideRight;
    }
    
 
    // Controls the movement up and down for the paddle    
    public void keyPressed(KeyEvent evt){

        if ( this.right == false ) {
            if( evt.getKeyCode() == evt.VK_Q ){
                System.exit( 0 );
            }
            if( evt.getKeyCode() == evt.VK_W ){
		setYVelocity( -5 );
            }
            if( evt.getKeyCode() == evt.VK_S ){
                setYVelocity( 5 );
            }
        
        }
        else {
            if( evt.getKeyCode() == evt.VK_UP ){
		setYVelocity( -5 );
            }
            if( evt.getKeyCode() == evt.VK_DOWN ){
		setYVelocity( 5 );
            }
        }
    }

    // stops the movement of the paddle when any key is released
    public void keyReleased(KeyEvent evt){
	
    if ( this.right == false ) {
        if( evt.getKeyCode() == evt.VK_W ){
	    setYVelocity( 0 );
        }

        if( evt.getKeyCode() == evt.VK_S ){
	    setYVelocity( 0 );
        }
    }
    else {
        if( evt.getKeyCode() == evt.VK_UP ){
	    setYVelocity( 0 );
        }

        if( evt.getKeyCode() == evt.VK_DOWN ){
	    setYVelocity( 0 );
        }
    }
    }

    // gets a new random color to draw the paddle and then redraws it
    public void draw(Graphics g)
    {
        g.setColor( getRandomColor() );
        g.fillRect( getXCoordinate(), getYCoordinate(), 
		    getWidth(), getHeight() );
    }

    // Actually is the bottom of screen
    public int getPaddleTopHit(){ return ( Screen.h - 134 ); }

    // Actually is the top of screen
    public int getPaddleBotHit(){ return 3; }

    // lose a life
    public void decrementBalls(){ ballCount--; }
    
    // add the number of hits to the users score
    public void incrementPoints( int numOfPoints ){ points += numOfPoints; }
    
    public int getPoints(){ return points; }

    // when the ball hits the wall behind the paddle
    //   it resets the ball to the middle of the screen, stops it
    //   and switches the velocity to go the opposite way
    public void playerMissed( Ball ball, int numOfPoints, Paddle winner )
    {
	decrementBalls();
	ball.setXVelocity( -1 * ball.getXVelocity() );
	ball.resetBall();
	winner.incrementPoints( numOfPoints );
	
    }
    
    // gets activated when up or down key is pressed
    //   then sets the new coordinates for the paddle to be drawn
    public void movePaddle(){
	if( getYCoordinate() <= this.getPaddleBotHit() ){
	    setYCoordinate( this.getPaddleBotHit() );
	}
	else if( getYCoordinate() >= this.getPaddleTopHit() ){
	    setYCoordinate( this.getPaddleTopHit() );
	}
	
	setYCoordinate( getYCoordinate() + getYVelocity() );
	}
}
