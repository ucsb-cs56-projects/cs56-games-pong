package edu.ucsb.cs56.projects.games.pong.gameplay;

import java.awt.event.KeyEvent;
import java.awt.Graphics;


/** edu.ucsb.cs56.projects.games.pong.gameplay.Paddle is the class that is used to move the user-controlled paddle around the screen
 @author Timothy Fok
 @author Sanchit Gupta, Bhanu Khanijau
 @author Jake Dumont, Heneli Kailahi
 @author Benjamin Hartl, Sarah Darwiche
 @author Vincent Gandolfo, Krishna Lingampalli
 @version CS56, Winter 2015, UCSB 
*/
public class Paddle extends gameObject{
    public int points;
    public int ballCount;
    public boolean right;
    public boolean lol;


    /** Paddle contructor to initialize intial x,y placement of paddle
     * @param x set initial x coordinate of paddle
     * @param y set initial y coordinate of paddle
     */
    public Paddle(int x, int y, int rectH ){
	this( x, y, rectH, false );
    }

    /** Right paddle constructor to initialize initial x,y placement of paddle
     @param x set initial x position of the paddle
     @param y set initial y position of the paddle
     @param sideRight sees if the paddle is the rightmost paddle
    */

    public Paddle(int x, int y, int rectH, boolean sideRight){
	super( x, y, rectH );
	
	ballCount = 3;
	points = 0;
	right = sideRight;
    }
    
 
    /** keyPressed controls the movement up and down for the paddle    */
    public void keyPressed(KeyEvent evt){

        if ( this.right == false ) {
            if( evt.getKeyCode() == KeyEvent.VK_Q ){
                System.exit( 0 );
            }
            if( evt.getKeyCode() == KeyEvent.VK_W ){
            	setYVelocity( -5 );
            }
            if( evt.getKeyCode() == KeyEvent.VK_S ){
                setYVelocity( 5 );
            }
        
        }
        else {
            if( evt.getKeyCode() == KeyEvent.VK_UP ){
		setYVelocity( -5 );
            }
            if( evt.getKeyCode() == KeyEvent.VK_DOWN ){
		setYVelocity( 5 );
            }
        }
    }

    /** keyReleased stops the movement of the paddle when any key is released */
    public void keyReleased(KeyEvent evt){
	
    if ( this.right == false ) {
        if( evt.getKeyCode() == KeyEvent.VK_W ){
	    setYVelocity( 0 );
        }

        if( evt.getKeyCode() == KeyEvent.VK_S ){
	    setYVelocity( 0 );
        }
    }
    else {
        if( evt.getKeyCode() == KeyEvent.VK_UP ){
	    setYVelocity( 0 );
        }

        if( evt.getKeyCode() == KeyEvent.VK_DOWN ){
	    setYVelocity( 0 );
        }
    }
    }

    /** the draw function gets a new random color to draw the paddle and then redraws it */
    public void draw(Graphics g)
    {
        g.setColor(this.color);
        g.fillRect( getXCoordinate(), getYCoordinate(), 
		    getWidth(), getHeight() );
    }
    /** the draw2 function runs when ExtremeType2 is being played */
    public void draw2(Graphics g)
    {
        g.setColor( getRandomColor() );
        g.fillRect( getXCoordinate(), getYCoordinate(),
                    getWidth()+15 , getHeight()-60 );
    }

	/** getPaddleTopHit(): Actually is the bottom of screen */
    public int getPaddleTopHit(){ return ( Screen.h - DifficultyLevel.getPaddleHeight() - 30); }

    /** getPaddleBotHit(): Actually is the top of screen */
    public int getPaddleBotHit(){ return DifficultyLevel.getPaddleHeight()/30; }

    /** decrementBalls() decrements ballCount when a player loses a life */
    public void decrementBalls(){ ballCount--; }
    
    /** incrementPoints adds the number of hits to the user's score 
     * @param numOfPoints number of points to add to score
     */

    public void incrementPoints( int numOfPoints ){ points += numOfPoints; }
    /** getPoints() returns the score of the player */
    public int getPoints(){ return points; }

    /**  playerMissed occurs when the ball hits the wall behind the paddle.
       It resets the ball to the middle of the screen, stops it
       and switches the velocity to go the opposite way 
       * @param ball the ball in the game
       * @param numOfPoints number of points to add to the score
       * @param winner the paddle that just won the points
       */
    public void playerMissed( Ball ball, int numOfPoints, Paddle winner )
    {
	decrementBalls();
	ball.setXVelocity( -1 * ball.getXVelocity() );
	ball.resetBall();
	winner.incrementPoints( numOfPoints );
	
    }
    
    /** movePaddle() gets activated when up or down key is pressed
     *   then sets the new coordinates for the paddle to be drawn
     */
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
