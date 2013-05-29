//package edu.ucsb.cs56.projects.S13.cs56_games_pong;

import javax.swing.*;
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

/** Paddle is the class that will move the user-controlled paddle
	around the screen

	@author Timothy Fok
	@author Bhanu Khanijau
	@author Sanchit Gupta
	@version CS56, Spring 2013, UCSB
*/
public class Paddle implements Runnable{
	Rectangle p;
	int x,y;
	int dy;
	int dx;
	public static Integer paddleHeight = 90;

/** Paddle contructor to initialize intial x,y placement of paddle
    @param x sets the x position of the paddle.
    @param y sets the y position of the paddle.
*/
	public Paddle(int x, int y){
		this.x = x;
		this.y = y;
		p = new Rectangle(x,y,10,paddleHeight);
	}

/** set the height of the paddle
 *   @param newHeight chooses the new height for the paddle
*/
	public void setPaddleHeight(int newHeight){
		this.paddleHeight = newHeight;
	}

/** runs the paddle thread and starts animating it.
*/
	public void run(){
		try{
	    	while(true){
				movePaddleLeft();
				Thread.sleep(9);
	    	}
		}catch(Exception e){}
}

/** KeyPressed handles what to do if player hits up or down key.
 *  Paddle should move up upon up key and down upon down key.
 *   @param e finds which key on the keyboard was hit.
*/
	public void keyPressed(KeyEvent evt){
		if(evt.getKeyCode() == evt.VK_Q){
	    	setdy(-5);
		}
		if(evt.getKeyCode() == evt.VK_A){
	    	setdy(5);
		}
	}
    

/** KeyReleased handles what to do if player releaseds up or down key.
 *  Paddle should stop upon key release.
 *   @param e finds which key on the keyboard was released.
*/
	public void keyReleased(KeyEvent evt){
		if(evt.getKeyCode() == evt.VK_Q){
			setdy(0);
		}
	
		if(evt.getKeyCode() == evt.VK_A){
			setdy(0);
		}
	}

/** draw the paddle onto the screen as a rectangle
 *   @param g graphics handles the drawing of the paddle
*/
	public void draw(Graphics g){
			Color ballColor;
			double ballC = Math.random();
			Color purple = new Color (131,0,131) ;
			Color darkBlue = new Color (24,52,111);
			if(ballC < 0.1){
				ballColor = Color.RED;
			}
			else if(ballC < 0.2){
				ballColor = darkBlue;
				}
				else if(ballC < 0.3){
					ballColor = Color.ORANGE;
				}
				else if(ballC < 0.4){
					ballColor = Color.CYAN;
					}
				else if(ballC < 0.5){
					ballColor = Color.YELLOW;
				}
				else if(ballC < 0.6){
					ballColor = purple;
					}
				else if(ballC < 0.7){
					ballColor = Color.GREEN;
				}
				else if(ballC < 0.8){
					ballColor = ballColor;
					}
				else{
					ballColor = Color.BLUE; //twice as likely to get Blue
				}
		g.setColor(ballColor);
		g.fillRect(p.x,p.y,p.width,p.height);
	}


/** set the speed of the change of y position
 *   @param newdy chooses the new speed
*/
	public void setdy(int newdy){
		dy = newdy;
	}

/** return the dy of the paddle
*/
	public int getdy(){
		return this.dy;
	}

/** set the speed of the change of x position
 *   @param newdx chooses the new speed
*/
	public void setYpos(int newY){
		p.y =  newY;
	}

/** returns the Y position of the paddle
*/
	public int getYpos(){
		return this.y;
	}

/** returns the X position of the paddle
*/
	public int getXpos(){
		return this.x;
	}

/**
*  returns the Ypos of the paddle, which is
* the top of the screen where the paddle can highest
*  go to
*/
	public int getPaddleTopHit(){
		int Ypos = Screen.h - 97;
		return Ypos;
	}
    
/**
* returns the Ypos2 of the paddle, which is the lowest point
* the paddle can go to. 
*/
	public int getPaddleBotHit(){
		int Ypos2 = Screen.h - (Screen.h-37);
		return Ypos2;
	}

/** move handles the changing position of the paddle,
 *  keeps the paddle from going offscreen.
*/
	public void movePaddleLeft(){
		if(p.y <= this.getPaddleBotHit()){
			setYpos(this.getPaddleBotHit());
		}
		if(p.y >= this.getPaddleTopHit()){
			setYpos(this.getPaddleTopHit());
		}
		p.y += dy;
    }


}