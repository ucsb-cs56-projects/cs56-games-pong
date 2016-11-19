package edu.ucsb.cs56.projects.games.pong.gameplay;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import edu.ucsb.cs56.projects.games.pong.menu.PlayTextComponent;

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

    DifficultyLevel difficulty = new DifficultyLevel(PlayTextComponent.getDifficulty());
    public int ballsLost;
    public int speed = 1;
    public int origXVelocity;
    public boolean attached = false;
                                                
    /** edu.ucsb.cs56.projects.games.pong.gameplay.Ball constructor to initialize location of edu.ucsb.cs56.projects.games.pong.gameplay.Ball onto the screen
     *  and draw it as a rectangle for a simpler and precise hitbox.
     *  @param x set initial x coordinate of ball
     *  @param y set initial y coordinate of ball 
     *  @param w set initial w of ball
     *  @param h set initial h of ball
     */

    // Constructor
    // inputs are start x, start y, width of ball, and height of ball
    public Ball( int x, int y, int w, int h )
    {
	super( x, y, w, h );
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
    public void startBall()
    {
	if(difficulty.getDifficulty()==80){
		speed= 1;
	}
	else if (difficulty.getDifficulty()==100){
		speed= 2;
	}
	else if (difficulty.getDifficulty()==130){
		speed= 3;
	}
	else if (difficulty.getDifficulty()==140){
		speed= 4;
	}
	else if (difficulty.getDifficulty()==170){
		speed= 5;
	}
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
	setXCoordinate(( Screen.w-difficulty.getWidth() ) / 2 );
	setYCoordinate(( Screen.h-difficulty.getHeight() ) / 2 );
    }
    ///work in progress below
    public void holdBallToPaddle(KeyEvent evt, double distance)/////////////////////////////
    {
   	 origXVelocity = getXVelocity();
   	 attached = true;
   	 if(evt.getKeyCode() == KeyEvent.VK_A && ( (int)distance < getWidth() ) ) {
   		 setXVelocity(0);
   		 setYVelocity(0);
   	 }
   	 
   	 if(evt.getKeyCode() == KeyEvent.VK_F && ( (int)distance < 1.5*getWidth() ) ) {
   		 setXVelocity(0);
   		 setYVelocity(0);
   	 }
    }
    
    public void releaseBallFromPaddle(KeyEvent evt, double distance)/////////////////////////////
    {
   	 attached = false;
   	 if(evt.getKeyCode() == KeyEvent.VK_A ) {
   		 setXVelocity(origXVelocity * -1);
   		 setYVelocity(speed);
   	 }
   	 
   	 if(evt.getKeyCode() == KeyEvent.VK_F && ( (int)distance < 1.5*getWidth() ) ) {
   		 setXVelocity(origXVelocity * -1);
   		 setYVelocity(speed);
   	 }
    }
    
    public void keyPressed(KeyEvent evt, double p1, double p2){

        if ( (evt.getKeyCode() == KeyEvent.VK_A) && ((int)p1 < getWidth()) && (attached == false)) {
       	 holdBallToPaddle(evt, p1);
        }
        if( evt.getKeyCode() == KeyEvent.VK_W && attached == true){
       	 setYVelocity( -5 );
        }
        if( evt.getKeyCode() == KeyEvent.VK_S && attached == true){
            setYVelocity( 5 );
        }
        
        
        if (evt.getKeyCode() == KeyEvent.VK_F && (int)p2 < 1.5*getWidth() && attached == false) {
       	 holdBallToPaddle(evt, p2);
        }
        if( evt.getKeyCode() == KeyEvent.VK_UP && attached == true){
       	 setYVelocity( -5 );
        }
        if( evt.getKeyCode() == KeyEvent.VK_DOWN && attached == true){
       	 setYVelocity( 5 );
        }
    }
    
    public void keyReleased(KeyEvent evt, double p1, double p2){
   		
   	 if ( evt.getKeyCode() == KeyEvent.VK_A && attached == true ) {
       	 releaseBallFromPaddle(evt, p1);
   	 }
        if( evt.getKeyCode() == KeyEvent.VK_W && attached == true){
       	 setYVelocity( 0 );
        }
        if( evt.getKeyCode() == KeyEvent.VK_S && attached == true){
            setYVelocity( 0 );
        }
        if (evt.getKeyCode() == KeyEvent.VK_F && attached == true) {
       	 releaseBallFromPaddle(evt,p2);
        }
        if( evt.getKeyCode() == KeyEvent.VK_UP && attached == true){
       	 setYVelocity( 0 );
        }
        if( evt.getKeyCode() == KeyEvent.VK_DOWN && attached == true){
       	 setYVelocity( 0 );
        }
   	    }
}
