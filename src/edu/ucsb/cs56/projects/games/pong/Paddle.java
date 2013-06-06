//package edu.ucsb.cs56.projects.games.pong;

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
 @author Sanchit Gupta, Bhanu Khanijau
 @author Jake Dumont, Heneli Kailahi
 @version CS56, Spring 2013, UCSB                                                                                                                                                
*/
public class Paddle {
    Rectangle p;
    int x,y;
    int dy;
    int dx;
    boolean right;
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

    /** Right paddle constructor to initialize intial x,y placement of paddle                                                                                                            
     @param x sets the x position of the paddle                                                                                                                                       
     @param y sets the y position of the paddle                                                                                                                                       
     @param sideRight sees if the paddle is the rightmost paddle                                                                                                                      
    */
    public Paddle(int x, int y, boolean sideRight){
    this.x = x;
    this.y = y;
    p = new Rectangle(x,y,10,paddleHeight);
    this.right = sideRight;
    }

    /** set the height of the paddle                                                                                                                                                     
     *   @param newHeight chooses the new height for the paddle                                                                                                                          
     */
    public void setPaddleHeight(int newHeight){
    this.paddleHeight = newHeight;
    }


   
    /** KeyPressed handles what to do if player hits up or down key, and Q and A key.                                                                                                                     
     *  Paddle should move up upon up key and Q key, and down upon down key and A key.                                                                                                                        
     *   @param evt finds which key on the keyboard was hit.                                                                                                                               
     */
    public void keyPressed(KeyEvent evt){
        if (this.right == false) {
            if(evt.getKeyCode() == evt.VK_Q){
                System.exit(0);
            }
            if(evt.getKeyCode() == evt.VK_W){
                setdy(-5);
            }
            if(evt.getKeyCode() == evt.VK_S){
                setdy(5);
            }
        
        }
        else {
            if(evt.getKeyCode() == evt.VK_UP){
                setdy(-5);
            }
            if(evt.getKeyCode() == evt.VK_DOWN){
                setdy(5);
            }
        }
    }

    /** KeyReleased handles what to do if player releases up or down key, or Q or A key.                                                                                                                     
     *   @param evt finds which key on the keyboard was hit.                                                                                                                               
     */


    public void keyReleased(KeyEvent evt){
    if (this.right == false) {
        if(evt.getKeyCode() == evt.VK_W){
        setdy(0);
        }

        if(evt.getKeyCode() == evt.VK_S){
        setdy(0);
        }
    }
    else {
        if(evt.getKeyCode() == evt.VK_UP){
        setdy(0);
        }

        if(evt.getKeyCode() == evt.VK_DOWN){
        setdy(0);
        }
    }
    }


    /** draw the paddle onto the screen as a rectangle                                                                                                                                   
     *   @param g graphics handles the drawing of the paddle                                                                                                                             
     */


    public void draw(Graphics g){
        Color paddleColor;
        double ballC = Math.random();
        Color purple = new Color (131,0,131) ;
        Color darkBlue = new Color (24,52,111);
        if(ballC < 0.1){
            paddleColor = Color.RED;
        }
        else if(ballC < 0.2){
            paddleColor = darkBlue;
            }
        else if(ballC < 0.3){
            paddleColor = Color.ORANGE;
        }
        else if(ballC < 0.4){
            paddleColor = Color.CYAN;
        }
        else if(ballC < 0.5){
            paddleColor = Color.YELLOW;
        }
        else if(ballC < 0.6){
            paddleColor = purple;
            }
        else if(ballC < 0.7){
            paddleColor = Color.GREEN;
        }
        else{
            paddleColor = Color.BLUE; //twice as likely to get Blue
        }
        g.setColor(paddleColor);
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
     *   @param newY chooses the new speed                                                                                                                                              
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
     *  go to.
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
    public void movePaddle(){
    if(p.y <= this.getPaddleBotHit()){
        setYpos(this.getPaddleBotHit());
    }
    if(p.y >= this.getPaddleTopHit()){
        setYpos(this.getPaddleTopHit());
    }

    p.y += dy;
    }


}
