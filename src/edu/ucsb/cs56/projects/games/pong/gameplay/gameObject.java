package edu.ucsb.cs56.projects.games.pong.gameplay;

import java.awt.*;

/** edu.ucsb.cs56.projects.games.pong.gameplay.gameObject is used to change velocities of objects used in the game pong
 @author Vincent Gandolfo, Krishna Lingampalli
 @author Andrew Polk, Victoria Sneddon
 @version CS56, Fall 2017, UCSB
*/
class gameObject{
    
    /** Gameobject horizontal speed (x)*/
    protected int xVelocity;

    /** Gameobject vertival speed (y)*/
    protected int yVelocity;

    /**Holds x and y coordinates and width and height */
    protected Rectangle rectangle;

    /** Holds the color of the gameObject*/                                     
    protected Color color;
    
    /** Default constructor, not used */
    gameObject() {  }            

    /** Constructor used by both the Paddles, so all paddles are the same size 
     * @param x X position
     * @param y Y position
     * @param rectH rectangle height
     */
    gameObject( int x, int y, int rectH) {    
	this( x, y, 10, rectH);
    }
    
    /** This constructor is used to set coordinates and size, used by subclasses Ball and Paddle 
     * @param x X position
     * @param y Y position
     * @param rectH rectangle height
     * @param rectW rectangle width
     */
    gameObject( int x, int y, int rectW, int rectH ) {
	setXVelocity(0);
	setYVelocity(0);
	rectangle = new Rectangle( x, y, rectW, rectH );
	this.color = getRandomColor();
    }
    
    // ( x, y ) coordinates are to the upper left hand corner
    
    // The x Coordinate to the left hand side
    /** getXCoordinate() returns the x coordinate of the Paddle 
     * @return int X coordinte
     */
    public int getXCoordinate() { return rectangle.x; }
    
    /** setXCoordinate sets the x coordinate of the Paddle
     * @param x x coordinate of the Paddle
     */
    public void setXCoordinate( int x ) { rectangle.x = x; }
	
    /**set the color of gameobject 
     * @param newColor new color object
     */
    public void setColor(Color newColor) {color = newColor;}
    
    // The y Coordinate to the top
    /** getYCoordinate() returns the y coordinate of the Paddle 
     * @return int y coordinate
     */
    public int getYCoordinate() { return rectangle.y; }

    /** setYCoordinate sets the y coordinate of the Paddle
     * @param y y coordinate of the Paddle
     */
    public void setYCoordinate( int y ) { rectangle.y = y; }

    // Stored in the rectangle
    /** getWidth() returns the width of the Paddle 
     * @return int the gameobject width
     */
    public int getWidth() { return rectangle.width; }

    /** setWidth sets the width of the Paddle 
     * @param w width of the Paddle
     */
    public void setWidth( int w ) { rectangle.width = w; }

    // Stored in the rectangle
    /** getHeight() returns the height of the Paddle 
     * @return int gameobject height
     */
    public int getHeight() { return rectangle.height; }

    /** setHeight sets the height of the Paddle 
     * @param h height of the Paddle
     */
    public void setHeight( int h ) { rectangle.height = h; }

    /** getXVelocity() returns the x velocity of the Ball 
     * @return int X velocity
     */
    public int getXVelocity() { return xVelocity; }

    /** setXVelocity sets the x velocity of the Ball
     * @param dx the x velocity of the Ball
     */
    public void setXVelocity( int dx ) { xVelocity = dx; }

    /** getYVelocity() returns the y velocity of the Ball 
     * @return int y velocity
     */
    public int getYVelocity() { return yVelocity; }

    /** setYVelocity sets the y velocity of the Ball
     * @param dy the y velocity of the ball
     */
    public void setYVelocity( int dy )  { yVelocity = dy; }
	
    /** getRandomColor() returns a new color that was randomly generated 
     * @return Color random color
     */
    public Color getRandomColor() {
	int red = (int) (Math.random() * 250);
	int green = (int) (Math.random() * 250);
	int blue  = (int) (Math.random() * 250);

	return ( new Color( red, green, blue ) );
    }
}

    
