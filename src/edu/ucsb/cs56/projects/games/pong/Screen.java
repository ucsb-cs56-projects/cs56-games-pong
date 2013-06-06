//package edu.ucsb.cs56.projects.games.pong;

//code influence and ideas from http://www.dreamincode.net/forums/topic/172211-programing-an-applet-game-of-pong/                                                                    
//http://www.youtube.com/watch?v=E-CJYELJa88                                                                                                                                         
// https://foo.cs.ucsb.edu/56mantis/view.php?id=740                                                                                                                                  

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
 @author Bhanu Khanijau, Sanchit Gupta   
 @author Jake Dumont, Heneli Kailahi
 @version CS56, Spring 2013, UCSB

*/

public class Screen extends JFrame {
    public static int w;
    public static int h;
    public static Integer newW;
    public static Integer newY;

    /**
     *Create a static edu.ucsb.cs56.projects.games.pong.Ball so we can work with it                                                                                                                                    
	 * and buffer graphics to ease performance issues                                                                                                                                
	 */
    static Pong game = new Pong();
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
    public Screen() {
	getContentPane().addMouseListener(
					  new MouseAdapter(){

					      public void mouseEntered(MouseEvent e){
						                                                                                                                         
						  Thread theball = new Thread(game);
						  theball.start();
					      }
					  }
					  );
        
	this.addKeyListener(new myKeyAdapter());
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setScreenWidth(newW);
	this.setScreenHeight(newY);
	this.setSize(w,h);
	this.setBackground(Color.BLACK);
	this.setResizable(false);

	this.setTitle("Cooperative PONG. WIN: 10 LOSE: -3. MOUSE OVER TO UNPAUSE AND INCREASE SPEED");
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
	g.drawString(game.points + "",400,70);

	game.draw(g);
	game.p1.draw(g);
	repaint();
	game.p2.draw(g);
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
	    game.p1.keyPressed(evt);
	    game.p2.keyPressed(evt);
	}

	/** myKeyAdapter handles keyboard released events.                                                                                                                                   
	 *  it handles up and down keys in particular                                                                                                                                        
	 *  for movement of paddle.                                                                                                                                                          
	 */
	public void keyReleased(KeyEvent evt){
	    game.p1.keyReleased(evt);
	    game.p2.keyReleased(evt);
	}

    }

    /** create the screen and start the threads of the ball and paddle                                                                                                                   
     *  so they can start animating.                                                                                                                                                     
     *   @param args no return                                                                                                                                                           
     *
     */
    public static void main (String[] args) {

    	Object[] options = {"Easy", "Medium", "Hard"};
    	int multiplier = 100;
        JFrame frame = new JFrame();
    	int n = JOptionPane.showOptionDialog(frame,
    			"What level would you like to play?"
    			+ "",
    			"",
    			JOptionPane.YES_NO_CANCEL_OPTION,
    			JOptionPane.QUESTION_MESSAGE,
    			null,
    			options,
    			options[2]);
    			if(n == 0){
    			multiplier = 80;
    			}
    			else if(n == 1){
    			multiplier = 100;
    			}
    			else if(n == 2){
    			multiplier = 120;
    			}	
    	
	newW = 8 * multiplier;
	newY= 6 * multiplier;
	Screen myScreen = new Screen();
                                                                                                                                               
    }


}
