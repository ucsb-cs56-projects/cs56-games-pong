package edu.ucsb.cs56.projects.games.pong.gameplay;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/** edu.ucsb.cs56.projects.games.pong.gameplay.Ball is the class that will move the ball around the screen
    @author Timothy Fok  
    @author Sanchit Gupta, Bhanu Khanijau
    @author Jake Dumont, Heneli Kailahi
    @author Benjamin Hartl, Sarah Darwiche
    @author Vincent Gandolfo, Krishna Lingampalli
    @author Andrew Polk, Victoria Sneddon
    @version CS56, Fall 2017, UCSB                   
*/

// The Movement of the Ball on the screen
public class Ball extends gameObject{

    /**Number of balls lost */
    public int ballsLost;

    /**Speed of the ball */
    public int speed = 1;

    /** Holds original x velocity */
    public int origXVelocity;

    /**Holds if the ball is attached to a paddle */
    public boolean attached = false;

    /**Paddle being held to, false=p1, true=p2*/
    private boolean paddle = false;

    /**Player 1*/
    private Paddle p1;
    /**Player 2*/
    private Paddle p2;
    
    /** Holds if the ball is going right */
    boolean isGoingRight = false;
                                                
    /** edu.ucsb.cs56.projects.games.pong.gameplay.Ball constructor to initialize location of edu.ucsb.cs56.projects.games.pong.gameplay.Ball onto the screen
     *  and draw it as a rectangle for a simpler and precise hitbox.
     *  @param x set initial x coordinate of ball
     *  @param y set initial y coordinate of ball 
     *  @param w set initial w of ball
     *  @param h set initial h of ball
     *  @param isGoingRight set if ball is going right
     */

    // Constructor
    // inputs are start x, start y, width of ball, and height of ball
    public Ball( int x, int y, int w, int h, boolean isGoingRight )
    {
	super( x, y, w, h, isGoingRight );
	speed = DifficultyLevel.getSpeed();
	startBall();
	
	p1 = edu.ucsb.cs56.projects.games.pong.gameplay.Pong.getPlayer1();
	p2 = edu.ucsb.cs56.projects.games.pong.gameplay.Pong.getPlayer2();
    }

    /** The draw method sets a new Color for the ball and redraws the ball with new coordinates 
     * @param g The Graphics object for the draw method
     */ 
    public void draw( Graphics g )
    {
	g.setColor(this.color);
	g.fillOval( getXCoordinate(), getYCoordinate(), 
		    getWidth(), getHeight() );
    }

    /** startBall(): When the ball is stopped, this will start the ball in the opposite direction of the way it was going*/
    public void startBall() {
	if( gameObject.isGoingRight == false )
	    speed = speed*-1;
	setXVelocity( speed );
	setYVelocity( speed );
    }
    
    /** isStopped() checks if the ball is stopped
     * @return boolean if ball is stopped
     */
    public boolean isStopped()
    {
	if( ( getXVelocity() == 0 ) && ( getYVelocity() == 0 ) && attached == false )
	    return true;
	else 
	    return false;
    }
    
    /** stopBall() stops the ball no matter what*/
    public void stopBall()
    {
    	setYVelocity( 0 );
    	setXVelocity( 0 );
    }
    
    /** resetBall() puts the ball back in the middle of the screen and stops the ball
     * @params ballNumber the index number for the ball being reset
     */
    public void resetBall(int ballNumber) 
    {
    	stopBall();
    	setXCoordinate(( Screen.w-DifficultyLevel.getWidth() ) / 2 );
	setYCoordinate(( Screen.h-(4*ballNumber)*DifficultyLevel.getHeight() ) / 2 );
    }
   
    /** takes in KeyEvent and distance and holds ball to paddle if correct key is pressed and distance is correct 
     * @param evt The event of a key press
     * @param distance Distance from paddle to ball
     */
    public void holdBallToPaddle(KeyEvent evt, double distance)
    {
	origXVelocity = getXVelocity();
	attached = true;
   	 
	if(evt.getKeyCode() == KeyEvent.VK_A && ( (int)distance < DifficultyLevel.getPaddleHeight() ) ) {
	    setXVelocity(0);
	    setYVelocity(0);
	    paddle = false;
	}
   	 
	if(evt.getKeyCode() == KeyEvent.VK_LEFT && ( (int)distance < DifficultyLevel.getPaddleHeight() ) ) {
	    setXVelocity(0);
	    setYVelocity(0);
	    paddle = true;
	}
    }
    
    /** Takes in keyEvent and distance and releases ball from paddle if correct key is released
     * @param evt The event of a key press
     * @param distance Distance from paddle to ball
     */
    public void releaseBallFromPaddle(KeyEvent evt, double distance)
    {
	attached = false;
	if(evt.getKeyCode() == KeyEvent.VK_A && ( (int)distance < DifficultyLevel.getPaddleHeight() ) ) {
	    setXVelocity(origXVelocity * -1);
	    setYVelocity(speed);
	}
   	 
	if(evt.getKeyCode() == KeyEvent.VK_LEFT && ( (int)distance < DifficultyLevel.getPaddleHeight() ) ) {
	    setXVelocity(origXVelocity * -1);
	    setYVelocity(speed);
	    
	}
    }
    
    /** Takes in KeyEvent and arrayList of distance and moves ball with the paddle if ball is being held 
     * @param evt The event of a key press
     * @param distance ArrayList of distances from balls
     */
    public void keyPressed(KeyEvent evt, ArrayList<Double> distance){
        if ( (evt.getKeyCode() == KeyEvent.VK_A) && ( distance.get(0) < DifficultyLevel.getPaddleHeight()) && (attached == false)) {
	    holdBallToPaddle(evt, distance.get(0));
        }
	if(paddle == false && attached == true){
	    if(p1.isPaddleMoving() == true){
		if( evt.getKeyCode() == KeyEvent.VK_W && distance.get(4) > 5 ){
		    //setYVelocity( -5 );
		    setYVelocity(p1.getYVelocity());
		}
		if( evt.getKeyCode() == KeyEvent.VK_S && distance.get(2) > 5){
		    //setYVelocity( 5 );
		    setYVelocity(p1.getYVelocity());
		}
	    } else {
		setYVelocity(0);
	    }        
	}
	
        if (evt.getKeyCode() == KeyEvent.VK_LEFT && distance.get(1)< DifficultyLevel.getPaddleHeight() && attached == false) {
	    holdBallToPaddle(evt, distance.get(1));
        }
	if(paddle == true && attached == true){
	    if(p2.isPaddleMoving() == true) {
		if( evt.getKeyCode() == KeyEvent.VK_UP && distance.get(5) > 5 ){
		    //setYVelocity( -5 );
		    setYVelocity(p2.getYVelocity());
		}
		if( evt.getKeyCode() == KeyEvent.VK_DOWN && distance.get(3) > 5 ){
		    //setYVelocity( 5 );
		    setYVelocity(p2.getYVelocity());
		}
	    } else {
		setYVelocity(0);
	    }
	}
    }

    /**Updates the velocity if the ball is attached*/
    public void ballAttachUpdate() {
	if(attached == true) {
	    if(paddle == false) {
		if(p1.isPaddleMoving() == true) {
		    setYVelocity(p1.getYVelocity());
		} else {
		    setYVelocity(0);
		}
	    }
	    if(paddle == true) {
		if(p2.isPaddleMoving() == true) {
		    setYVelocity(p2.getYVelocity());
		} else {
		    setYVelocity(0);
		}
	    }
	}
    }

    /**Overrides getYVelocity to call ballAttachUpdate outside of key event
     * @return int y velocity
     */
    @Override
    public int getYVelocity() {
	ballAttachUpdate();
	return yVelocity;
    }
    
    /** takes in KeyEvent and arrayList of distance and releases ball from paddle or stops ball from moving 
     * @param evt The event of a key press
     * @param distance Arraylist of distances from balls
     */
    public void keyReleased(KeyEvent evt, ArrayList<Double> distance){
	if(attached == true) {
	    if ( evt.getKeyCode() == KeyEvent.VK_A) {
		releaseBallFromPaddle(evt, distance.get(0));
	    }
	    if(paddle == false){
		if( evt.getKeyCode() == KeyEvent.VK_W || evt.getKeyCode() == KeyEvent.VK_S){
		    setYVelocity( 0 );
		}
	    }
	    
	    if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
		releaseBallFromPaddle(evt,distance.get(1));
	    }
	    if(paddle == true) {
		if( evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN){
		    setYVelocity( 0 );
		}
	    }
	}
    }
}
