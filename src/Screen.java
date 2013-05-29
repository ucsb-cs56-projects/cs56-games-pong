//code influence and ideas from http://www.dreamincode.net/forums/topic/172211-programing-an-applet-game-of-pong/
//http://www.youtube.com/watch?v=E-CJYELJa88
// https://foo.cs.ucsb.edu/56mantis/view.php?id=740
//package edu.ucsb.cs56.projects.S13.cs56_games_pong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.BasicStroke;
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

/** Screen is the GUI implementation of the Pong game
	@author Timothy Fok 
	@author Bhanu Khanijau
	@author Sanchit Gupta
	@version CS56, Spring 2013, UCSB
*/

public class Screen extends JFrame{
    public static int w;
    public static int h;
    public static Integer newW;    
    public static Integer newY;
	public Color backgroundColor = Color.BLACK;

/**
     *Create a static Ball so we can work with it
     * and buffer graphics to ease performance issues
     */
    static Ball b1 = new Ball(193,143,20,20);
    //	Thread theball = new Thread(b1);
    Graphics doublebufferG;
    Image doublebufferImg;


/** sets the width of the screen
 *   @param width the width of the Screen
*/
    public void setScreenWidth(int width){
	this.w = width;
    }

/** sets the height of the screen
 *   @param height the height of the Screen
*/
    public void setScreenHeight(int height){
	this.h = height;
	    }

/** returns the width of the screen
*/
    public int getScreenWidth(){
	return this.w;
    }

/** returns the height of the screen
*/
    public int getScreenHeight(){
	return this.h;
    }

/** Screen Constructor and mouseEntered function to unpause game.
 * @param e MouseEvents to handle running game when mouse is on Screen.
*/
    public Screen(){

	getContentPane().addMouseListener(
	     new MouseAdapter(){
		 
		 public void mouseEntered(MouseEvent e){
		     //    this.theComp.interrupt();
		     Thread theball = new Thread(b1);
	theball.start();
		 }
	     }
	      );

 	this.addKeyListener(new myKeyAdapter());
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setScreenWidth(newW);
	this.setScreenHeight(newY);
	this.setSize(w,h);
	this.setBackground(backgroundColor);
	this.setResizable(false);

	this.setTitle("A Game of Pong. MOUSE OVER TO UNPAUSE AND INCREASE SPEED");
	this.setVisible(true);	
    }


/** draw text, ball, paddle onto screen
 *
 *   @param g graphics perform drawing operations
 *
*/
    public void draw(Graphics g){
	g.setFont(new Font("sansserif", Font.BOLD, 28));
	g.setColor(Color.WHITE);
	g.drawString("Points: ", 280, 70);

	g.setFont(new Font("sansserif", Font.BOLD, 32));
	g.setColor(Color.WHITE);
	g.drawString(b1.points + "",400,70);

	b1.draw(g);
//	b1.p1.draw(g);
//	repaint();
	b1.p2.draw(g);
	repaint();
}	

/** paint buffer graphics onto screen
 *
 *   @param g graphics perform paint operations
 *
*/
public void paint(Graphics g){
    doublebufferImg = createImage(getWidth(), getHeight());
    doublebufferG = doublebufferImg.getGraphics();
    draw(doublebufferG);
    g.drawImage(doublebufferImg,0,0,this);

}

/** myKeyAdapter handles keyboard events.
 *  it handles up and down keys in particular 
 *  for movement of paddle.
 */
public class myKeyAdapter extends KeyAdapter {
    public void keyPressed(KeyEvent evt){
	//b1.p1.keyPressed(evt);
	b1.p2.keyPressed(evt);
    }

/** myKeyAdapter handles keyboard released events.
 *  it handles up and down keys in particular 
 *  for movement of paddle.
 */
    public void keyReleased(KeyEvent evt){
//	b1.p1.keyReleased(evt);
	b1.p2.keyReleased(evt);
    }

}
/** create the screen and start the threads of the ball and paddle
 *  so they can start animating.
 *   @param args no return
 *
*/
    public static void main (String[] args) {
	
	if(args.length == 0)
	    {
	    newW = 800;
	    newY= 600;
	    // Paddle.newPH = 90;
	}

	else if(args.length == 1)
    {
		newW = Integer.parseInt(args[0]);	
		newY = 600;
	}
	
	else
	{
		newW = Integer.parseInt(args[0]);
		newY = Integer.parseInt(args[1]);
	}


	//Thread LeftPaddle = new Thread(b1.p1);
	//LeftPaddle.start();

	Screen myScreen = new Screen();

	Thread RightPaddle = new Thread(b1.p2);
	RightPaddle.start();

    }


}

