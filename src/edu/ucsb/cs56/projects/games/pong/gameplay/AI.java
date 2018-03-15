package edu.ucsb.cs56.projects.games.pong.gameplay;

import java.awt.event.KeyEvent;
import java.awt.Graphics;
import java.util.Random;


public class AI extends gameObject{

    /**Number of points a player has*/
    protected int points;

    /**Holds the number of ballsLeft*/
    protected int ballCount;

    /**If this is the right side paddle*/
    protected boolean right;

    /**True if paddle is moving*/
    private boolean paddleMoving;


    /** AI contructor to initialize intial x,y placement of paddle
     * @param x set initial x coordinate of paddle
     * @param y set initial y coordinate of paddle
     * @param rectH paddle height
     * @param ballNumber number of balls to be used in game
     */
    public AI(int x, int y, int rectH, int ballNumber){
	this( x, y, rectH, ballNumber, false );
    }
    
    /** Right paddle constructor to initialize initial x,y placement of paddle
     * @param x set initial x position of the paddle
     * @param y set initial y position of the paddle
     * @param rectH paddle height
     * @param ballNumber need three times the number of ball in play to win
     * @param sideRight sees if the paddle is the rightmost paddle
     */
    public AI(int x, int y, int rectH, int ballNumber, boolean sideRight){
	super( x, y, rectH );
	
	setBallCount(3*ballNumber);
	setPoints(0);
	setRight(sideRight);
    }
    
 
    /** keyPressed controls the movement up and down for the paddle    
     * @param evt Event for a key press
     */

    /** the draw function gets a new random color to draw the paddle and then redraws it 
     * @param g Graphics object for drawing
     */
    public void draw(Graphics g)
    {
        g.setColor(this.color);
        g.fillRect( getXCoordinate(), getYCoordinate(), 
		    getWidth(), getHeight() );
    }

    /** the draw2 function runs when ExtremeType2 is being played 
     * @param g Graphics object for drawing
     */
    public void draw2(Graphics g)
    {
        g.setColor( getRandomColor() );
        g.fillRect( getXCoordinate(), getYCoordinate(),
                    getWidth()+15 , getHeight()-60 );
    }

    /** getPaddleTopHit(): Actually is the bottom of screen 
     * @return int location paddle should stop moving
     */
    public int getPaddleTopHit(){ return ( Screen.h - DifficultyLevel.getPaddleHeight() - 30); }
    
    /** getPaddleBotHit(): Actually is the top of screen 
     * @return int location paddle should stop moving
     */
    public int getPaddleBotHit(){ return DifficultyLevel.getPaddleHeight()/30; }

    /** decrementBalls() decrements ballCount when a player loses a life 
     */
    public void decrementBalls(){ ballCount--; }
    
    /** incrementPoints adds the number of hits to the user's score 
     * @param numOfPoints number of points to add to score
     */
    public void incrementPoints( int numOfPoints ){ points += numOfPoints; }

    /** getPoints() returns the score of the player 
     * @return int Points of player
     */
    public int getPoints(){ return points; }

    /**playerMissed() occurs when the ball hits the wall behind the paddle. It resets the ball to the middle of the screen, stops it and switches the velocity to go the opposite way 
     * @param ball the ball in the game
     * @param numOfPoints number of points to add to the score
     * @param winner the paddle that just won the points
     */
    public void playerMissed( Ball ball, int numOfPoints, Paddle winner ) {
	decrementBalls();
	ball.setXVelocity( -1 * ball.getXVelocity() );
	winner.incrementPoints( numOfPoints );
    }
    
    /** movePaddle() gets activated when up or down key is pressed then sets the new coordinates for the paddle to be drawn
     */
    public void movePaddle(){
	paddleMoving = true;
	
	if( getYCoordinate() <= this.getPaddleBotHit() ){
	    setYCoordinate( this.getPaddleBotHit() );
	    paddleMoving = false;
	} else if( getYCoordinate() >= this.getPaddleTopHit() ){
	    setYCoordinate( this.getPaddleTopHit() );
	    paddleMoving = false;
	}
	Random r = new Random();
	int [] randVelocity = new int[2];
	randVelocity[0] = 15;//for positive y direction
	randVelocity[1] = -15;//for negative y direction
	int randChoice = r.nextInt(2);
	
	setYCoordinate( getYCoordinate() + randVelocity[randChoice] );
    }

    public boolean isRight() {
        return right;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setBallCount(int ballCount) {
        this.ballCount = ballCount;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    /**isPaddleMoving() return is the paddle is moving or not
     * @return boolean if paddle is moving
     */
    public boolean isPaddleMoving() { return paddleMoving; }
}

