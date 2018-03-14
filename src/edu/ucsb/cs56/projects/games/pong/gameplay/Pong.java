package edu.ucsb.cs56.projects.games.pong.gameplay;

import edu.ucsb.cs56.projects.games.pong.sound.SoundEffect;
import edu.ucsb.cs56.projects.games.pong.menu.PlayTextComponent;
import edu.ucsb.cs56.projects.games.pong.menu.ColorPrompt;

/** edu.ucsb.cs56.projects.games.pong.gameplay.Pong is the class that will facilitate
 * the game of Pong being run 
 * @author Sanchit Gupta, Bhanu Khanijau
 * @author Heneli Kailahi, Jake Dumont  
 * @author Benjamin Hartl, Sarah Darwiche
 * @author Vincent Gandolfo, Krishna Lingampalli
 * @author Angel Ortega
 * @author Millan Batra and Alexander Ngo
 * @author Andrew Polk, Victoria Sneddon
 * @version CS56, Fall 2017, UCSB
 */
public class Pong implements Runnable {

    /**Times ball hits a paddle*/
    int hits;

    /**Used to increase speed every 5 hits*/
    int moreSpeed=1;             

    /**Left Paddle*/
    static Paddle p1;

    /**Right Paddle*/
    static Paddle p2;

    /**Paddle that wins*/
    Paddle winner;                 

    /**The balls*/
    Ball b[];
    /**Number of balls*/
    int ballNum;

    /**If game is paused or not*/
    boolean gameIsGoing = true;

    /**SoundEffect for ball collision*/
    SoundEffect collision = new SoundEffect("4359__noisecollector__pongblipf4.wav");

    /**isPaused pauses the game if = true*/
    public static boolean isPaused = true;
    
    /** The Pong constructor initializes 2 paddle objects, a ball object, and points value 
     */
    public Pong() {
	isPaused = true;
	ballNum = DifficultyLevel.getBallNum();
	
    	p1 = new Paddle( 8, Screen.h/2 - (DifficultyLevel.getPaddleHeight())/2, DifficultyLevel.getPaddleHeight(), ballNum); // Left Paddle
        p2 = new Paddle( Screen.w - 38 , Screen.h/2 - (DifficultyLevel.getPaddleHeight())/2, DifficultyLevel.getPaddleHeight(), ballNum, true ); // Right Paddle
	p1.setColor(ColorPrompt.getColorA());
	p2.setColor(ColorPrompt.getColorB());

	b = new Ball[ballNum];
	
	for(int i = 0; i < ballNum; i++) {
	    boolean dir = false;
	    if(i%2 == 0)
		dir = true;
	    else
		dir = false;
	    
	    b[i] = (new Ball( ((Screen.w-DifficultyLevel.getWidth()) /2),
			      ((Screen.h-(4*i)*DifficultyLevel.getHeight()) /2),
			       DifficultyLevel.getHeight(),
			       DifficultyLevel.getHeight(),
			       dir));
	}
        
        hits = 0;                                      // # of times of wall
        moreSpeed = 1;
    }
    
    /** getHits() returns the number of times the ball hits any paddle
     * @return int hits
     */
    public int getHits( ){ return hits; }     

    /** incrementHits() increments the number of hits when it hits a paddle*/
    public void incrementHits(){ hits++; }    

    /** hitsReset() sets hits to 0 when a paddle misses a ball*/
    public void hitsReset(){ hits = 0; }      

    /** getWinner() returns the paddle that just won the points 
     * @return Paddle The object for the winner player
     */
    public Paddle getWinner(){ return winner; }

    /** setWinner takes a Paddle object as a parameter, then sets
     * the winner to that Paddle argument
     * @param a the Paddle that just won
     */
    public void setWinner(Paddle a) { winner = a; }

    /**Returns gameobject for player1
     * @return Paddle player1
     */
    public static Paddle getPlayer1() {return p1;}

    /**Returns gameobject for player2
     * @return Paddle player2
     */
    public static Paddle getPlayer2() {return p2;}
    
    /** toString() returns which player has won in a string
     * @return String toString Method
     */ 
    public String toString() {
	if( winner.right == true )
	    return "Player 2";
	else
	    return "Player 1";
    }

    /** checkGameStatus() checks each time a ball is lost if they have any lives left*/
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

    /** checkBallsStopped() checks if all the balls in play are stopped
     * @return boolean return 1 if all balls are stopped
     */
    public boolean checkBallStopped() {
	int stoppedBalls = 0;
	for(int i = 0; i < ballNum; i++){
	    //Balls only stopped if they have collided with the wall and been reset to the center
	    if(b[i].isStopped())
		stoppedBalls++;
	}
	return (stoppedBalls == ballNum) ? true : false;
    }
    
    /** gameLoss brings up a frame to enter the user's name 
     * @param p Not Used
     */   
    public void gameLoss( Paddle p )
    {
	GameOver gameOver = new GameOver( toString(), winner.getPoints() );
	Screen.jf.dispose();
	kill();                 // kills the thread 
    }
    
    /** moveGame() allows the ball and paddles in the game to be moved*/
    public void moveGame() { // every iterations of thread the ball calls this
	//Doesnt move the game if the game is paused
	if(!isPaused){
	    p1.movePaddle();     // draws paddles at new location
	    p2.movePaddle();      
	    
	    // sets the new locations
	    for(int i = 0; i < ballNum; i++){
		b[i].setXCoordinate( b[i].getXCoordinate() + b[i].getXVelocity() );
		b[i].setYCoordinate( b[i].getYCoordinate() + b[i].getYVelocity() );
	    }
	    
	    // checks if it hit a paddle
	    paddleCollision();
	    wallCollision();
	}
    }
    
    /** paddleCollision() detects whether ball hits a paddle*/
    public void paddleCollision() { // speed starts out at 1
    	if( getHits() % 5 == 0 )    // every 5 hits increases speed by 1,
	    moreSpeed = 1;
    	else
	    moreSpeed = 0;

	// Sets the new velocity if it hits either paddle, p1 or p2
	//   and adds the increments the number of hits 
	
	for(int i = 0; i < ballNum; i++){
	    // checks if it hits p1
	    if( ( b[i].rectangle ).intersects( p1.rectangle ) ){
		playPaddleCollisionAudio();
		b[i].setXVelocity( -1 * ( b[i].getXVelocity() - moreSpeed ) );
        if((b[i].getYVelocity() >0) && p1.getYVelocity() >0){
            b[i].setYVelocity(b[i].getYVelocity()+2);
        }
        if((b[i].getYVelocity() <0) && p1.getYVelocity() <0){
            b[i].setYVelocity(b[i].getYVelocity()-2);
        }
        if((b[i].getYVelocity() >0) && p1.getYVelocity() <0){
            b[i].setYVelocity(b[i].getYVelocity()-2);
        }
        if((b[i].getYVelocity() <0) && p1.getYVelocity() >0){
            b[i].setYVelocity(b[i].getYVelocity()+2);
        }
        incrementHits();   
	    }
	
	    // checks if it hits p2
	    else if( ( b[i].rectangle ).intersects( p2.rectangle ) ){
    		playPaddleCollisionAudio();
    		b[i].setXVelocity( -1 * ( b[i].getXVelocity() + moreSpeed ) );
        if((b[i].getYVelocity() >0) && p1.getYVelocity() >0){
            b[i].setYVelocity(b[i].getYVelocity()+2);
        }
        if((b[i].getYVelocity() <0) && p1.getYVelocity() <0){
            b[i].setYVelocity(b[i].getYVelocity()-2);
        }
        if((b[i].getYVelocity() >0) && p1.getYVelocity() <0){
            b[i].setYVelocity(b[i].getYVelocity()-2);
        }
        if((b[i].getYVelocity() <0) && p1.getYVelocity() >0){
            b[i].setYVelocity(b[i].getYVelocity()+2);
        }
 		
            incrementHits();
	    }
	}	
    }
    
    /**
     * Load collision file for paddles and play collision afterwards
     * Credit for audio file goes to NoiseCollector @: http://www.freesound.org/people/NoiseCollector/packs/254/
     */
    protected void playPaddleCollisionAudio() {
	// Audio credit goes to NoiseCollector via: http://www.freesound.org/people/NoiseCollector/packs/254/
	collision.playClip();
            
    }

    /** wallCollision() detects whether the ball hits a wall*/
    public void wallCollision() {
	// if p1 misses / hits the wall behind it
	//   then increment balls lost, sets the ball 
	//   to the middle and gives points to other player
	for(int i = 0; i < ballNum; i++){
	    // check if p1 misses
	    if( b[i].getXCoordinate() <= ( 0 ) ) {
		p1.playerMissed( b[i], getHits(), p2 );
		b[i].isGoingRight = true;
		hitsReset();
		b[i].resetBall(i);
	    }
	    // check if p2 misses
	    else if( b[i].getXCoordinate() >= ( Screen.w - 20 ) ) {
		p2.playerMissed( b[i], getHits(), p1 );
		b[i].isGoingRight = false;
		hitsReset();
		b[i].resetBall(i);
	    }
	}
    
	// If the ball hits the top or bottom of the screen,
	//   then the Y velocity is reversed to stay on screen
	for(int i = 0; i < ballNum; i++){
	    // checks if ball hits the bottom of the screen
	    if( b[i].getYCoordinate() >= ( Screen.h - 60 ) ) {
		b[i].setYVelocity( -1 * b[i].getYVelocity() );
	    }
	    // checks if ball hits the top of the screen
	    else if( b[i].getYCoordinate() <=  0 ) {
		b[i].setYVelocity( -1 * b[i].getYVelocity() );
	    }
	}
       
	checkGameStatus();
    }
    
    /** run() checks the movements every 15 milliseconds*/
    public void run(){
	for(int i = 0; i < ballNum; i++){
	    b[i].stopBall();
	}
        try{
            while( gameIsGoing ){
                moveGame();
                Thread.sleep( 15 );
            }
        }catch(Exception e){}
	
    }
    
    /** kill() stops the thread */
    public void kill()
    {
    	gameIsGoing = false;
    	Screen.theball.stop();
    }
}
    

  
