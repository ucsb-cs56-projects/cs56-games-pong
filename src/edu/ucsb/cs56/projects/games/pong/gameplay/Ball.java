package edu.ucsb.cs56.projects.games.pong.gameplay;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

/** edu.ucsb.cs56.projects.games.pong.gameplay.Ball is the class that will move the ball around the screen
 @author Timothy Fok  
 @author Sanchit Gupta, Bhanu Khanijau
 @author Jake Dumont, Heneli Kailahi
 @author Benjamin Hartl, Sarah Darwiche
 @author Vincent Gandolfo, Krishna Lingampalli
 @version CS56, Winter 2015, UCSB                   
*/

// The Movement of the Ball on the screen
public class Ball extends gameObject{

    public int ballsLost;
    public int speed = 1;
    public int origXVelocity;
    public boolean attached = false;
    boolean isGoingRight = false;
                                                
    /** edu.ucsb.cs56.projects.games.pong.gameplay.Ball constructor to initialize location of edu.ucsb.cs56.projects.games.pong.gameplay.Ball onto the screen
     *  and draw it as a rectangle for a simpler and precise hitbox.
     *  @param x set initial x coordinate of ball
     *  @param y set initial y coordinate of ball 
     *  @param w set initial w of ball
     *  @param h set initial h of ball
     */

    // Constructor
    // inputs are start x, start y, width of ball, and height of ball
    public Ball( int x, int y, int w, int h, boolean isGoingRight )
    {
	super( x, y, w, h, isGoingRight );
	speed = DifficultyLevel.getSpeed();
	startBall();
	
    }

    /** The draw method sets a new Color for the ball and redraws the ball with new coordinates */ 
    public void draw( Graphics g )
    {
	g.setColor( getRandomColor() );
	g.fillOval( getXCoordinate(), getYCoordinate(), 
		    getWidth(), getHeight() );
    }

    /** startBall(): When the ball is stopped, this will start the ball in the opposite direction of the way it was going  */
    public void startBall() {
	if( gameObject.isGoingRight == false )
		speed = speed*-1;
	setXVelocity( speed );
	setYVelocity( speed );
    }
    
    /** isStopped() checks if the ball is stopped */
    public boolean isStopped()
    {
	if( ( getXVelocity() == 0 ) && ( getYVelocity() == 0 ) && attached == false )
	    return true;
	else 
	    return false;
    }
    
    /** stopBall() stops the ball no matter what */
    public void stopBall()
    {
    	setYVelocity( 0 );
    	setXVelocity( 0 );
    }
    
    /** resetBall() puts the ball back in the middle of the screen and stops the ball */
    public void resetBall() 
    {
    	stopBall();
    	setXCoordinate(( Screen.w-DifficultyLevel.getWidth() ) / 2 );
		setYCoordinate(( Screen.h-DifficultyLevel.getHeight() ) / 2 );
    }
    ///work in progress below
    public void holdBallToPaddle(KeyEvent evt, double distance)/////////////////////////////
    {
   	 origXVelocity = getXVelocity();
   	 attached = true;
   	 
   	 if(evt.getKeyCode() == KeyEvent.VK_A && ( (int)distance < DifficultyLevel.getPaddleHeight() ) ) {
   		 setXVelocity(0);
   		 setYVelocity(0);
   	 }
   	 
   	 if(evt.getKeyCode() == KeyEvent.VK_LEFT && ( (int)distance < DifficultyLevel.getPaddleHeight() ) ) {
   		 setXVelocity(0);
   		 setYVelocity(0);
   	 }
    }
    
    public void releaseBallFromPaddle(KeyEvent evt, double distance)/////////////////////////////
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
    
    public void keyPressed(KeyEvent evt, double [] distance){

        if ( (evt.getKeyCode() == KeyEvent.VK_A) && ((int)distance[0] < DifficultyLevel.getPaddleHeight()) && (attached == false)) {
       	 holdBallToPaddle(evt, distance[0]);
        }
        if( evt.getKeyCode() == KeyEvent.VK_W && attached == true && (int)distance[4] 
        		> 5 ){
       	 setYVelocity( -5 );
        }
        if( evt.getKeyCode() == KeyEvent.VK_S && attached == true && (int)distance[2] 
        		> 5){
            setYVelocity( 5 );
        }
        
        
        if (evt.getKeyCode() == KeyEvent.VK_LEFT && (int)distance[1] < DifficultyLevel.getPaddleHeight() && attached == false) {
       	 holdBallToPaddle(evt, distance[1]);
        }
        if( evt.getKeyCode() == KeyEvent.VK_UP && attached == true && (int)distance[5] 
        		> 5 ){
       	 setYVelocity( -5 );
        }
        if( evt.getKeyCode() == KeyEvent.VK_DOWN && attached == true && (int)distance[3] 
        		> 5 ){
       	 setYVelocity( 5 );
        }
    }
    
    public void keyReleased(KeyEvent evt, double[] distance){
   		
   	 if ( evt.getKeyCode() == KeyEvent.VK_A && attached == true ) {
       	 releaseBallFromPaddle(evt, distance[0]);
   	 }
        if( evt.getKeyCode() == KeyEvent.VK_W && attached == true){
       	 setYVelocity( 0 );
        }
        if( evt.getKeyCode() == KeyEvent.VK_S && attached == true){
            setYVelocity( 0 );
        }
        if (evt.getKeyCode() == KeyEvent.VK_LEFT && attached == true) {
       	 releaseBallFromPaddle(evt,distance[1]);
        }
        if( evt.getKeyCode() == KeyEvent.VK_UP && attached == true){
       	 setYVelocity( 0 );
        }
        if( evt.getKeyCode() == KeyEvent.VK_DOWN && attached == true){
       	 setYVelocity( 0 );
        }
   	    }
    
    
}
