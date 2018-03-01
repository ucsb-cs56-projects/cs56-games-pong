package edu.ucsb.cs56.projects.games.pong.gameplay;
/** edu.ucsb.cs56.projects.games.pong.gameplay.Difficultylevel is the class that holds the diffculty and other parameters associated with varying difficulty levels
 * @author Millan Batra, Alex Ngo
 * @author Andrew Polk, Victoria Sneddon
 * @version CS56, Fall 2017, UCSB
 */

public class DifficultyLevel {
    
    /** The game difficulty level */
    protected static int diflevel;

    /** The screen multiplier factor */
    protected static int screenfactor;

    /** New screen width */
    protected static int width;

    /** New screen height */
    protected static int height;

    /** The original size of the ball */
    protected static int origballsize=5;

    /** New paddle height */
    protected static int paddleHeight;

    /** New ball speed */
    protected static int speed;

    /** How many balls there are in game */
    protected static int ballNum;
    
    /** edu.ucsb.cs56.projects.games.pong.gameplay.DifficultyLevel constructor to initialize difficulty of game onto the screen 
     * @param difficultylevel set game difficulty    
     */

    // Constructor
    // inputs are game difficulty [80,100,120,130,140,170]
    public DifficultyLevel(int difficultylevel)
    {
	setDiflevel(difficultylevel);
	setBallNum(1);
	if(getDifficulty()==80)//supereasy
	    {
		setScreenfactor(10);
		setWidth(getOrigballsize()*getScreenFactor());
		setHeight(getOrigballsize()*getScreenFactor());
		setPaddleHeight(110);
		setSpeed(1);
	    }
	else if(getDifficulty()==100)//easy
	    {
			setScreenfactor(8);
			setWidth(getOrigballsize()*getScreenFactor());
			setHeight(getOrigballsize()*getScreenFactor());
			setPaddleHeight(100);
			setSpeed(2);
	    }
	else if(getDifficulty()==120)//medium
	    {
			setScreenfactor(6);
			setWidth(getOrigballsize()*getScreenFactor());
			setHeight(getOrigballsize()*getScreenFactor());
			setPaddleHeight(90);
			setSpeed(3);
	    }
	else if(getDifficulty()==130)//hard
	    {
			setScreenfactor(4);
			setWidth(getOrigballsize()*getScreenFactor());
			setHeight(getOrigballsize()*getScreenFactor());
			setPaddleHeight(80);
			setSpeed(3);
	    }
	else if(getDifficulty()==140)//extreme
	    {
			setScreenfactor(2);
			setWidth(getOrigballsize()*getScreenFactor());
			setHeight(getOrigballsize()*getScreenFactor());
			setPaddleHeight(70);
			setSpeed(4);
	    }
	else if(getDifficulty()==170)//chaos
	    {
			setScreenfactor(1);
			setWidth(getOrigballsize()*getScreenFactor());
			setHeight(getOrigballsize()*getScreenFactor());
			setPaddleHeight(60);
			setSpeed(5);
	    }
    }
    
    /** getDifficulty() returns the current difficulty of the game 
     * @return int Difficulty level in int form
     */
    public static int getDifficulty() { return diflevel; }

    /** getHeight() returns the screen height based on difficulty 
     * @return int The Height of the Game window*/
    public static int getHeight() { return height; }

    /** getWidth() returns the screen width based on difficulty 
     * @return int The width of the Game window
     */
    public static int getWidth() { return width; }

    /** getScreenFactor() returns the multiply factor of the screen size 
     * @return int The multiply factor of the screen
     */
    public static int getScreenFactor() { return screenfactor; }

    /** getPaddleHeight() returns the height height based on difficulty 
     * @return int The Paddle heights to be used
     */
    public static int getPaddleHeight() { return paddleHeight; }

    /** getSpeed() returns the ball speed based on difficulty 
     * @return int The speed of the Ball
     */
    public static int getSpeed() {return speed; }

    /** getBallNum() returns the number of balls int eh game
     * @return int number of balls
     */
    public static int getBallNum() {return ballNum; }

	public static int getOrigballsize() {
		return origballsize;
	}

	/** setters
	 */
	public static void setBallNum(int ballNumber) {
	if(ballNumber >= 1 && ballNumber <= 5){
	    ballNum = ballNumber;}
    }

	public static void setDiflevel(int diflevel) {
		DifficultyLevel.diflevel = diflevel;
	}

	public static void setScreenfactor(int screenfactor) {
		DifficultyLevel.screenfactor = screenfactor;
	}

	public static void setWidth(int width) {
		DifficultyLevel.width = width;
	}

	public static void setHeight(int height) {
		DifficultyLevel.height = height;
	}

	public static void setOrigballsize(int origballsize) {
		DifficultyLevel.origballsize = origballsize;
	}

	public static void setPaddleHeight(int paddleHeight) {
		DifficultyLevel.paddleHeight = paddleHeight;
	}

	public static void setSpeed(int speed) {
		DifficultyLevel.speed = speed;
	}
}
