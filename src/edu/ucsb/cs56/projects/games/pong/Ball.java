package edu.ucsb.cs56.projects.games.pong;

import javax.swing.*;
import java.awt.*;
import java.awt.BasicStroke;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color; // class for Colors
import java.awt.Graphics;
import java.awt.Rectangle;  // squares and rectangles
import java.awt.Shape; // general class for shapes
import java.awt.Stroke;
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.geom.Ellipse2D;  // ellipses and circles
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.Line2D;  // single lines
import java.awt.geom.Rectangle2D; // for the bounding box

/** Ball is the class that will move the ball around the screen


     @author Timothy Fok
     @version CS56, Spring 2012, UCSB
*/
public class Ball implements Runnable{

    int x,y;
    int dx,dy;
    int w,h;
    Rectangle b;
    //  Oval c;

    int points = 0;

    Paddle p1 = new Paddle(8,160);
    Paddle p2 = new Paddle(50, 160, true);
    
/** Ball constructor to initialize location of Ball onto the screen
 *  and draw it as a rectangle for a simpler and precise hitbox.
 *  @param x set initial x coordinate of ball
 *  @param y set initial y coordinate of ball
*/
    public Ball(int x, int y, int w, int h){
	this.x = x;
	this.y = y;
	this.w = w;
	this.h = h;

	points = 0;
	setdx(-2);
	setdy(1);
		b = new Rectangle(this.x,this.y,20,20);
	//	c = new Oval(this.x,this.y, 20,20);
    }   

/** sets a different x position for the ball
 *  @param x chooses the new x position
 */
    public void setXpos(int x){
	this.x = x;
    }

/** sets a different y position for the ball
 *  @param y chooses the new x position
 */
    public void setYpos(int y){
	this.y = y;
    }

/** sets a different speed of x position for the ball
 *  @param x chooses the new x speed
 */
    public void setdx(int newdx){
	dx = newdx;
    }

/** sets a different speed of y position for the ball
 *  @param x chooses the new y speed
 */
   public void setdy(int newdy){
	dy = newdy;
    }


/** returns the coordinate of the x location of the ball
 */
    public int getXpos(){
	return this.x;
    }

/** returns the coordinate of the y location of the ball
 */
    public int getYpos(){
	return this.y;
    }
 
/** returns the dx of the ball
 */
    public int getdx(){
	return this.dx;
    }

/** returns the dy of the ball
 */
    public int getdy(){
	return this.dy;
    }


/** draw a pink ball and fill the rectangle to represent the ball
 *  @param g graphics draws the pink ball.
 */
    public void draw(Graphics g){

	//Graphics2D g2 = (Graphics2D) g;

	g.setColor(Color.PINK);
	//	g.fillRect(b.x,b.y,b.width,b.height);  
	g.fillOval(b.x,b.y,b.width,b.height);

	//	g2.fill(c);

	if (points >= 10){
	    pointsReset();
	    gameWin();
	    //setdx(0);
	    // setdy(0);
	g.setFont(new Font("sansserif", Font.BOLD, 32));
	g.setColor(Color.WHITE);
	g.drawString("YOU WIN!",275,100);
	}

	else if (points <= -3){
	    pointsReset();
	    gameLoss();
	g.setFont(new Font("sansserif", Font.BOLD, 32));
	g.setColor(Color.WHITE);
	g.drawString("YOU LOST, GAME OVER!",100,100);
	   

	}
    }

/** runs the ball Thread, gets the ball animating
 */
    public void run(){
	try{
	    while(true){
			moveBall();
		Thread.sleep(8);}
	}
	catch(Exception e)
	    {
	     }
    }


/** resets the ball to the middle parts of the screen
 */
    public void resetBall(){
	if (b.x <= Screen.w - Screen.w){
	    b.x = Screen.w/2;
	    b.y = Screen.h/2;
	}

    }

/** handles players losing the game, stop the ball from moving
 */
    public void gameLoss(){
	setdx(0);
	b.x =0;
	b.y =0;
	b = null;
    }
    
/** handles players winning the game, stops the ball from moving
 */
    public void gameWin(){
	setdx(0);
	setdy(0); 
	b.x =0;
	b.y =0;
	b = null;
	//	p1 = null;
	//	p2 = null; 
	//	Screen = null;
    }

/** resets the points back to 0
 */
    public void pointsReset(){
	points = 0;
    }
    

/** moves the ball around and checks for if it hits walls and paddle. Changes
 *  speed upon collision of walls and paddle.
 */
    public void moveBall(){

	b.x += dx;
	b.y += dy;

	if(b.intersects(p1.p)){
	    setdx(3);
	}

	if(b.intersects(p2.p)){
	    setdx(3);
	}

	if(b.x <= (Screen.w - Screen.w)){
	    setdx(-3);
	    points--;
	    resetBall();
	}
	if(b.x >= (Screen.w - 20)){
	    setdx(-3);
	    points++;
	}
	if(b.y >= (Screen.h - 20)){
	setdy(-3);
	}
	if(b.y <= (Screen.h - Screen.h + 30)){
	setdy(3);
	}
    }

}