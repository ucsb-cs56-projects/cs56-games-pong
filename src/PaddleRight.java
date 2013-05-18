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

/** PaddleRight is the class that will move green user-controlled paddle
    around the screen

	@author Timothy Fok
	@author Bhanu Khanijau
	@author Sanchit Gupta
	@version CS56, Spring 2012, UCSB
*/
public class PaddleRight implements Runnable{
	Rectangle pad;
	int x,y;
	int dy;
	int dx;
	public static Integer paddleHeight = 90;
 	//public static int newPH;

/** PaddleRight contructor to initialize intial x,y placement of paddle
    @param x sets the x position of the paddle.
    @param y sets the y position of the paddle.
*/
	public PaddleRight(int x, int y){
		this.x = x;
		this.y = y;
		//	this.setPaddleHeight(newPH);
		pad = new Rectangle(x,y,10,paddleHeight);
    }

/** set the height of the paddleRight
 *   @param newHeight chooses the new height for the paddle
*/
	public void setPaddleHeight(int newHeight){
		this.paddleHeight = newHeight;
	}

/** runs the paddleRight thread and starts animating it.
*/
	public void run(){
		try{
			while(true){
			movePaddleRight();
			Thread.sleep(9);
			}
		}catch(Exception e){
			System.err.println(e.getMessage());
	    }
	}

/** KeyPressed handles what to do if player hits up or down key.
 *  PaddleRight should move up upon up key and down upon down key.
 *   @param e finds which key on the keyboard was hit.
*/
	public void keyPressed(KeyEvent evt){
		if(evt.getKeyCode() == evt.VK_UP){
			setdy(-5);
		}	
		if(evt.getKeyCode() == evt.VK_DOWN){
			setdy(5);
		}
	}    

/** KeyReleased handles what to do if player releaseds up or down key.
 *  PaddleRight should stop upon key release.
 *   @param e finds which key on the keyboard was released.
*/
	public void keyReleased(KeyEvent evt){
		if(evt.getKeyCode() == evt.VK_UP){
			setdy(0);
		}
		if(evt.getKeyCode() == evt.VK_DOWN){
			setdy(0);
		}
	}    

/** draw the paddleRight onto the screen as a rectangle
 *   @param g graphics handles the drawing of the paddle
*/
	public void draw(Graphics g){
		g.setColor(Color.BLUE);
		g.fillRect(pad.x,pad.y,pad.width,pad.height);
	}

/** set the speed of the change of y position
 *   @param newdy chooses the new speed
*/
	public void setdy(int newdy){
		dy = newdy;
	}

/** return the dy of the paddleRight
*/
	public int getdy(){
		return this.dy;
	}

/** set the speed of the change of x position
 *   @param newdx chooses the new speed
*/
	public void setYpos(int newY){
		pad.y =  newY;
	}


/** returns the Y position of the paddleRight
*/
	public int getYpos(){
		return this.y;
	}

/** returns the X position of the paddleRight
*/
	public int getXpos(){
		return this.x;
	}

/**
 *  returns the Ypos of the paddleRight, which is
 * the top of the screen where the paddle can highest
 *  go to
*/
	public int getPaddleTopHit(){
		int Ypos = Screen.h - 97;
		return Ypos;
	}
    
/**
 * returns the Ypos2 of the paddleRight, which is the lowest point
 * the paddleRight can go to. 
*/
	public int getPaddleBotHit(){
		int Ypos2 = Screen.h - (Screen.h-37);
	    return Ypos2;
	}
   
/** move handles the changing position of the paddleRight,
 *  keeps the paddleRight from going offscreen.
*/
	public void movePaddleRight(){
		if(pad.y <= this.getPaddleBotHit()){
	    	setYpos(this.getPaddleBotHit());
		}
		if(pad.y >= this.getPaddleTopHit()){
	    	setYpos(this.getPaddleTopHit());
		}
		pad.y += dy;
    }


}