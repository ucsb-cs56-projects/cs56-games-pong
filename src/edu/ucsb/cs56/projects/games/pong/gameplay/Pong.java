package edu.ucsb.cs56.projects.games.pong.gameplay;

import edu.ucsb.cs56.projects.games.pong.sound.SoundEffect;
import edu.ucsb.cs56.projects.games.pong.menu.PlayTextComponent;

/** edu.ucsb.cs56.projects.games.pong.gameplay.Pong is the class that will facilitate
 * the game of Pong being run 
 @author Sanchit Gupta, Bhanu Khanijau
 @author Heneli Kailahi, Jake Dumont  
 @author Benjamin Hartl, Sarah Darwiche
 @author Vincent Gandolfo, Krishna Lingampalli
 @author Angel Ortega
 @author Millan Batra and Alexander Ngo
 @version CS56, Fall 2016, UCSB
*/

public class Pong implements Runnable {

    int hits;                      // times it hits a paddle
    int moreSpeed=1;             // to increase speed every 5 hits
    
    Paddle p1;                     // Left Paddle
    Paddle p2;                     // Right Paddle
    Paddle winner;                 // the paddle that wins
    
    Ball b;                        // The Ball    
    Ball b1;
    
    boolean gameIsGoing = true;
    SoundEffect collision = new SoundEffect("4359__noisecollector__pongblipf4.wav");

    /** The Pong constructor initializes 2 paddle objects, a ball object, and 
     * a points value 
     */
    public Pong() {
    	p1 = new Paddle( 8, Screen.h/2 - (DifficultyLevel.getPaddleHeight())/2, DifficultyLevel.getPaddleHeight());                        // Left Paddle
        p2 = new Paddle( Screen.w - 38 , Screen.h/2 - (DifficultyLevel.getPaddleHeight())/2, DifficultyLevel.getPaddleHeight(),true );     // Right Paddle
	
	
			  
        b = new Ball( ((Screen.w-DifficultyLevel.getWidth()) /2),
		      ((Screen.h-DifficultyLevel.getHeight()) / 2),
		     DifficultyLevel.getHeight(),
		      DifficultyLevel.getHeight());
        
        if(DifficultyLevel.getDifficulty()==90)
	    {
        	b1 = new Ball( (int)((Screen.w-DifficultyLevel.getWidth() ) /2),
		      (int)((Screen.h-4*DifficultyLevel.getHeight()) / 2),
		      DifficultyLevel.getHeight(),
		      DifficultyLevel.getHeight());
	    }
        
        hits = 0;                                      // # of times of wall
        moreSpeed = 1;
    }
    /** getHits() returns the number of times the ball hits any paddle */
    public int getHits( ){ return hits; }     
    /** incrementHits() increments the number of hits when it hits a paddle */
    public void incrementHits(){ hits++; }    
    /** hitsReset() sets hits to 0 when a paddle misses a ball */
    public void hitsReset(){ hits = 0; }      
    /** getWinner() returns the paddle that just won the points */
    public Paddle getWinner(){ return winner; }
    /** setWinner takes a Paddle object as a parameter, then sets
     * the winner to that Paddle argument
     * @param a the Paddle that just won
     */




    public void setWinner(Paddle a) { winner = a; }

    /** toString() returns which player has won in a string */ 
    public String toString() {
	if( winner.right == true )
	    return "Player 2";
	else
	    return "Player 1";
    }

    /** checkGameStatus() checks each time a ball is lost if they 
     *  have any lives left 
     */
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
  
    /** gameLoss brings up a frame to enter the user's name */
    public void gameLoss( Paddle p )
    {
	GameOver gameOver = new GameOver( toString(), winner.getPoints() );
	Screen.jf.dispose();
	kill();                 // kills the thread 
    }
    /** moveGame() allows the ball and paddles in the game to be moved */








    public void moveGame() { // every iterations of thread the ball calls this
        p1.movePaddle();     // draws paddles at new location
        p2.movePaddle();      
	
	// sets the new locations
        b.setXCoordinate( b.getXCoordinate() + b.getXVelocity() );
        b.setYCoordinate( b.getYCoordinate() + b.getYVelocity() );
        
        if(DifficultyLevel.getDifficulty()==90)
    	{
        	b1.setXCoordinate( b1.getXCoordinate() - b1.getXVelocity() );
        	b1.setYCoordinate( b1.getYCoordinate() - b1.getYVelocity() );
    	}
        
	// checks if it hit a paddle
        paddleCollision();
        wallCollision();
	
    }
    
    /** paddleCollision() detects whether ball hits a paddle
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
    		playPaddleCollisionAudio();
    		b.setXVelocity( -1 * ( b.getXVelocity() - moreSpeed ) );
    		incrementHits();

    	}
	
	// checks if it hits p2
    	else if( ( b.rectangle ).intersects( p2.rectangle ) ){
    		playPaddleCollisionAudio();
    		b.setXVelocity( -1 * ( b.getXVelocity() + moreSpeed ) );
    		incrementHits();
    	}
	
	if(DifficultyLevel.getDifficulty()==90){

	    if(  (b1.rectangle ).intersects( p1.rectangle ) ){
	    	playPaddleCollisionAudio();
	    	b1.setXVelocity( -1 * ( b1.getXVelocity() - moreSpeed ) );
	    	incrementHits();
	    }

	    // checks if it hits p2
	    else if( ( b1.rectangle ).intersects( p2.rectangle ) ){
	    	playPaddleCollisionAudio();
	    	b1.setXVelocity( -1 * ( b1.getXVelocity() + moreSpeed ) );
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

    /** wallCollision() detects whether the ball hits a wall */
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
        
        if(DifficultyLevel.getDifficulty()==90) {
        	if( b.getXCoordinate() <= ( 0 ) )
    	    {
    		p1.playerMissed( b, getHits(), p2 );
    		b1.resetBall();

    		gameObject.isGoingRight = true;
    		hitsReset();
    	    }
    	// check if p2 misses
            else if( b.getXCoordinate() >= ( Screen.w - 20 ) )
    	    {
    		p2.playerMissed( b, getHits(), p1 );
    		gameObject.isGoingRight = false;
    		hitsReset();
    		b1.resetBall();
    	    }
        	
        	if(  (b1.getXCoordinate() <=  0)) {
        		p1.playerMissed( b1, getHits(), p2 );
        		gameObject.isGoingRight = true;
        		hitsReset();
        		b.resetBall();
        	}
        	// check if p2 misses
        	if(   ( b1.getXCoordinate() >= (Screen.w - 20) ) ) {
        		p2.playerMissed( b1, getHits(), p1 );
        		//p2.playerMissed( b1, getHits(), p1 );
        		gameObject.isGoingRight = false;
        		hitsReset();
        		b.resetBall();
        	}
        }

	// If the ball hits the top or bottom of the screen,
	//   then the Y velocity is reversed to stay on screen

	// checks if ball hits the bottom of the screen
        if( b.getYCoordinate() >= ( Screen.h - 60 ) )
	    {
        	b.setYVelocity( -1 * b.getYVelocity() );
	    }
       

	// checks if ball hits the top of the screen
        else if( b.getYCoordinate() <=  0 )
	    {
        	b.setYVelocity( -1 * b.getYVelocity() );
	    }

        
        if(DifficultyLevel.getDifficulty()==90) {
        	if( b1.getYCoordinate() >= ( Screen.h - 60 ) ) {
        		b1.setYVelocity( -1 * b1.getYVelocity() );
        	}
        	
        	else if( b1.getYCoordinate() <=  0 ) {
            	b1.setYVelocity( -1 * b1.getYVelocity() );
    	    }
        }
	checkGameStatus();
    }

    /** run() checks the movements every 15 milliseconds */
    public void run(){
	b.stopBall();
	if(DifficultyLevel.getDifficulty()==90) { b1.stopBall(); }
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
    

  
