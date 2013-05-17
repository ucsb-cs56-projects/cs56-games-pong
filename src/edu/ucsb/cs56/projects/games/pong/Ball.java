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

/** edu.ucsb.cs56.projects.games.pong.Ball is the class that will move the ball around the screen                                                                                                                      


 @author Timothy Fok  
 @author Jake Dumont
 @version CS56, Spring 2012, UCSB                                                                                                                                                
*/
public class Ball {

    int x,y;
    int dx,dy;
    int w,h;
    Rectangle rect;
    //  Oval c;                                                                                                                                                                      

    //int points = 0;                                                                                                                                                                

    //Paddle p1 = new Paddle(8,160);                                                                                                                                                 
    //Paddle p2 = new Paddle(50, 160, true);                                                                                                                                         

    /** edu.ucsb.cs56.projects.games.pong.Ball constructor to initialize location of edu.ucsb.cs56.projects.games.pong.Ball onto the screen                                                                                                                  
     *  and draw it as a rectangle for a simpler and precise hitbox.                                                                                                                     
     *  @param x set initial x coordinate of ball                                                                                                                                        
     *  @param y set initial y coordinate of ball                                                                                                                                        
     */
    public Ball(int x, int y, int w, int h){
	this.x = x;
	this.y = y;
	this.w = w;
	this.h = h;

	//points = 0;                                                                                                                                                                
	setdx(-2);
	setdy(1);
	rect = new Rectangle(this.x,this.y,20,20);
	//      c = new Oval(this.x,this.y, 20,20);                                                                                                                                  
    }

    /** sets a different x position for the ball                                                                                                                                         
     *  @param x chooses the new x position                                                                                                                                              
     */
    public void setXpos(int x){
	this.x = x;
	rect.x = x - 10;
    }

    /** sets a different y position for the ball                                                                                                                                         
     *  @param y chooses the new x position                                                                                                                                              
     */
    public void setYpos(int y){
	this.y = y;
	rect.y = y - 10;
    }

    /** sets a different speed of x position for the ball                                                                                                                                
     *  @param newdx chooses the new x speed                                                                                                                                                 
     */
    public void setdx(int newdx){
	dx = newdx;
    }

    /** sets a different speed of y position for the ball                                                                                                                                
	 *  @param newdy chooses the new y speed                                                                                                                                                 
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
	//      g.fillRect(b.x,b.y,b.width,b.height);                                                                                                                                
	g.fillOval(x,y,rect.width,rect.height);
    }
    /** resets the ball to the middle parts of the screen                                                                                                                                
     */
    public void resetBall(){
	if (x <= Screen.w - Screen.w){
	    
	    setXpos(Screen.w/2);
	    setYpos(Screen.h/2);
	}

    }

}
