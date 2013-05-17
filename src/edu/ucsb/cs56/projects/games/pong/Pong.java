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


 @author Heneli Kailahi, Jake Dumont                                                                                                                                             
 @version CS56, Spring 2012, UCSB                                                                                                                                                
*/
public class Pong implements Runnable {

    int points;
    Paddle p1;
    Paddle p2;
    Ball b;
    Ball b2;
    
    public Pong() {
	this.p1 = new Paddle(8,160);
	this.p2 = new Paddle(50, 160, true);
	this.b = new Ball(300,300,20,20);
    }

    public int getPoints() {
	return points;
    }
    

    public void setPoints(int newPoints) {
	this.points = newPoints;
    }

    public void draw(Graphics g) {
	b.draw(g);
	if (b2 != null)
	    b2.draw(g);
	//System.out.println(points);
	if (points >= 10){
	    pointsReset();
	    //System.out.println("game over");
	    //gameWin();
	    b.setdx(0);
	    b.setdy(0);
	    g.setFont(new Font("sansserif", Font.BOLD, 32));
	    g.setColor(Color.WHITE);
	    g.drawString("YOU WIN!",275,100);
	    gameWin();
	}

	else if (points <= -3){
	    pointsReset();
	    gameLoss();
	    g.setFont(new Font("sansserif", Font.BOLD, 32));
	    g.setColor(Color.WHITE);
	    g.drawString("YOU LOST, GAME OVER!",100,100);

	}
	
	else if (points == 3) {
	    if (b2 != null) {
		b2 = new Ball(300,300,20,20);
	    }
	}
    }

    public void gameWin(){
	b.setdx(0);
	b.setdy(0);
	b.setXpos(0);
	b.setYpos(0);
	b = null;
	//      p1 = null;                                                                                                                                                           
	//      p2 = null;                                                                                                                                                           
	//      Screen = null;                                                                                                                                                       
    }

    /** handles players losing the game, stop the ball from moving                                                                                                                       
     */

    public void gameLoss(){
	b.setdx(0);
	b.setdy(0);
	b.setXpos(0);
	b.setYpos(0);
	b = null;
    }

    /** resets the points back to 0                                                                                                                                                      
     */
    public void pointsReset(){
	this.points = 0;
    }

    public void moveGame() {
	p1.movePaddleLeft();
	p2.movePaddleLeft();
	b.setXpos(b.getXpos()+b.getdx());
	b.setYpos(b.getYpos()+b.getdy());
	paddleCollision();
	wallCollision();
    }

    public void paddleCollision() {
	if((b.rect).intersects(p1.p)){
	    b.setdx(3);
	}

	if((b.rect).intersects(p2.p)){
	    b.setdx(3);
	}
    }

    public void wallCollision() {
	if(b.getXpos() <= (Screen.w - Screen.w)){
	    b.setdx(-3);
	    this.points--;
	    b.resetBall();
	}
	if(b.getXpos() >= (Screen.w - 20)){
	    b.setdx(-3);
	    this.points++;
	}
	if(b.getYpos() >= (Screen.h - 20)){
	    b.setdy(-3);
	}
	if(b.getYpos() <= (Screen.h - Screen.h + 30)){
	    b.setdy(3);
	}
    }

    public void run(){
	try{
	    while(true){
		moveGame();
		Thread.sleep(8);}
	}
	catch(Exception e)
	    {
	    }
    }
}
