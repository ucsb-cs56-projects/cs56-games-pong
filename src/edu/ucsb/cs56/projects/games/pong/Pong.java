package edu.ucsb.cs56.projects.games.pong;

import javax.swing.*;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color; // class for Colors
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;  // squares and rectangles
import java.awt.Shape; // general class for shapes
import java.awt.Stroke;
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.geom.Ellipse2D;  // ellipses and circles
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.Line2D;  // single lines
import java.awt.geom.Rectangle2D; // for the bounding box
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

/** edu.ucsb.cs56.projects.games.pong.Ball is the class that will move the ball around the screen

 @author Sanchit Gupta, Bhanu Khanijau
 @author Heneli Kailahi, Jake Dumont  
 @author Benjamin Hartl, Sarah Darwiche
 @version CS56, Winter 2014, UCSB
*/

public class Pong implements Runnable {
    
    int hits;                      // times it hits a paddle
    int moreSpeed = 1;             // to increase speed every 5 hits
    
    Paddle p1;                     // Left Paddle
    Paddle p2;                     // Right Paddle
    Paddle winner;                 // the paddle that wins
    
    Ball b;                        // The Ball
    
    boolean gameIsGoing = true;    
    
    // It initializes 2 paddle objects, a ball object, and points value
    public Pong() {
	p1 = new Paddle( 8, 160 );                        // Left Paddle
        p2 = new Paddle( Screen.w - 18 , 160, true );     // Right Paddle
        b = new Ball( (int)(Screen.w / 2), (int)(Screen.h / 2), 20, 20 );
        hits = 0;                                      // # of times of wall
	moreSpeed = 1;
    }

    public int getHits( ){ return hits; }     // times it hit any paddle
    
    public void incrementHits(){ hits++; }    // whenever it hits a paddle

    public void hitsReset(){ hits = 0; }      // when a paddle misses the ball

    public Paddle getWinner(){ return winner; }
    public void setWinner(Paddle a) { winner = a; }

    // Prints out which player has won
    public String toString() {
	if( winner.right == true )
	    return "Player 2";
	else
	    return "Player 1";
    }

    // Checks each time a ball is lost if they hav any lives left
    public void checkGameStatus()
    {
	if(p2.ballCount <= 0 ){
	    setWinner(p1);
	    gameLoss(p2);
	}
	else if(p1.ballCount <= 0 ){
	    setWinner(p2);
	    gameLoss(p1);
	}
    }
  
    // Brings up frame to enter the users name
    public void gameLoss( Paddle p )
    {
	GameOver gameOver = new GameOver( toString(), winner.getPoints() );
	kill();                 // kills the thread 
	
    }

    public void moveGame() { // every iterations of thread the ball calls this
        p1.movePaddle();     // draws paddles at new location
        p2.movePaddle();      
	
	// sets the new locations
	b.setXCoordinate( b.getXCoordinate() + b.getXVelocity() );
        b.setYCoordinate( b.getYCoordinate() + b.getYVelocity() );
	
	// checks if it hit a paddle
	paddleCollision();
	
	// checks if the ball hit a wall
        wallCollision();
    }
    
    /** Detect whether ball hits a paddle
     */
    
    public void paddleCollision() { // speed starts out at 1
	if( getHits() % 5 == 0 )    // every 5 hits increases speed by 1,
	    moreSpeed = 1;
	else
	    moreSpeed = 0;	       

	// Sets the new velocity if it hits either paddle, p1 or p2
	//   and adds the increments the number of hits 
	
	// checks if it hits p1
	if( ( b.rectangle ).intersects( p1.rectangle ) ){
	    b.setXVelocity( -1 * ( b.getXVelocity() - moreSpeed ) );
	    incrementHits();
	}
	
	// checks if it hits p2
	else if( ( b.rectangle ).intersects( p2.rectangle ) ){
            b.setXVelocity( -1 * ( b.getXVelocity() + moreSpeed ) );
	    incrementHits();
        }
    }
    
    // Detect whether the ball hits a wall
    public void wallCollision() 
    {
	// if p1 misses / hits the wall behind it
	//   then increment balls lost, sets the ball 
	//   to the middle and gives points to other player

	// check if p1 misses
        if( b.getXCoordinate() <= ( 0 ) )
	    {
		p1.playerMissed( b, getHits(), p2 );
		gameObject.isGoingRight = true;
		hitsReset();
	    }
	// check if p2 misses
        else if( b.getXCoordinate() >= ( Screen.w - 20 ) )
	    {
		p2.playerMissed( b, getHits(), p1 );
		gameObject.isGoingRight = false;
		hitsReset();
	    }

	// If the ball hits the top or bottom of the screen,
	//   then the Y velocity is reversed to stay on screen

	// checks if ball hits the bottom of the screen
	if( b.getYCoordinate() >= ( Screen.h - 20 ) )
	    {
		b.setYVelocity( -1 * b.getYVelocity() );
	    }
	
	// checks if ball hits the top of the screen
        else if( b.getYCoordinate() <=  30 )
	    {
		b.setYVelocity( -1 * b.getYVelocity() );
	    }

	checkGameStatus();
    }

    // Checks the movements every 15 milliseconds
    public void run(){
	b.stopBall();
        try{
            while( gameIsGoing ){
                moveGame();
                Thread.sleep( 15 );
            }
        }catch(Exception e){}
	
    }
    
    // Stops the thread
    public void kill()
    {
	gameIsGoing = false;
	Screen.theball.stop();
    }
}
    
