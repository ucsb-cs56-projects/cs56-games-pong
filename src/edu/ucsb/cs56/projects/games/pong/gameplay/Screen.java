package edu.ucsb.cs56.projects.games.pong.gameplay;

//code influence and ideas from http://www.dreamincode.net/forums/topic/172211-programing-an-applet-game-of-pong/
//http://www.youtube.com/watch?v=E-CJYELJa88
// https://foo.cs.ucsb.edu/56mantis/view.php?id=740

import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color; // class for Colors
import java.awt.Graphics;


/** Screen is the GUI implementation of the Pong game
 @author Timothy Fok 
 @author Bhanu Khanijau, Sanchit Gupta   
 @author Jake Dumont, Heneli Kailahi
 @author Benjamin Hartl, Sarah Darwiche
 @author Vincent Gandolfo, Krishna Lingampalli
 @version CS56, Winter 2015, UCSB
*/

public class Screen{
    public static JFrame jf;
    static int w;
    static int h;
    public Pong game;
    public Graphics doublebufferG;
    public Image doublebufferImg;
    static Thread theball;
    MyDrawPanel mdp;



    /** Screen Constructor and mouseEntered function to unpause game 
     * @param windowWidth width of the JFrame window
     * @param windowHeight height of the JFrame window
     */
      public Screen( int windowWidth, int windowHeight ) {
	  jf = new JFrame( "Pong" );
	  mdp = new MyDrawPanel();
	  jf.add( mdp );
	  setScreenSize( windowWidth, windowHeight );
	  jf.setBackground(Color.BLACK);
	  jf.setResizable( false );
	  jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  
	  game = new Pong();
	  theball = new Thread(game);
	  theball.start();
	  
	  jf.addKeyListener(new myKeyAdapter());
	  jf.setVisible( true );
    }
    /** setScreenSize sets the size of the screen 
     * @param width width of the screen
     * @param height height of the screen
     */
    public void setScreenSize( int width, int height )
    {
	w = width;
	h = height;
	jf.setSize( w, h );
	jf.setLocationRelativeTo( null );

    }
    /** MyDrawPanel draws the graphics onto the screen */
    class MyDrawPanel extends JPanel{
	/** the draw function draws text, ball, paddle onto screen
	 * @param g the graphics drawer
	 */
	public void draw(Graphics g){
	    g.setFont(new Font("sansserif", Font.BOLD, 28));
	    g.setColor(Color.WHITE);
	    g.drawString("Hits: " + game.getHits(), 280, 40);
	    g.drawString( "player 1 ", 30, 40 );
	    g.drawString( "" + game.p1.getPoints(), 30, 70 );
	    g.drawString( "player 2 ", Screen.w - 180, 40 );
	    g.drawString( "" + game.p2.getPoints(), Screen.w - 70, 70 );
	    g.drawString( "Lives " + ( game.p1.ballCount ), 30, Screen.h - 47 );
	    g.drawString( "Lives " + ( game.p2.ballCount ), Screen.w - 140 , Screen.h - 47 );
	    
	    if( game.b.isStopped() ) {
		g.drawString( "Game Paused", 200, 100 );
		g.drawString( "Press M to return to Main Menu", 60, 370 );
	    }
	     
		// if level difficulty blahblah
	    game.b.draw(g);
	    game.p1.draw(g);
	    game.p2.draw(g);
	    jf.repaint();

}
	 	
	/** the paint function paints buffer graphics onto screen
	 * @param g the graphics drawer
	 */
	public void paint(Graphics g){
	    doublebufferImg = jf.createImage( jf.getWidth(), jf.getHeight());
	    doublebufferG = doublebufferImg.getGraphics();
	    draw( doublebufferG );
	    g.drawImage( doublebufferImg, 0, 0, jf );
	}
    }
	
    /** myKeyAdapter handles up and down keys for movement of paddle. */  
    public class myKeyAdapter extends KeyAdapter {
	/** keyPressed checks if certain keys are pressed
	 * @param evt the KeyEvent
	 */
	public void keyPressed(KeyEvent evt){
	    game.p1.keyPressed(evt);
	    game.p2.keyPressed(evt);
	    
	    boolean ballintersectsp1 = game.b.rectangle.intersects( game.p1.rectangle);
	    boolean ballintersectsp2 = game.b.rectangle.intersects( game.p2.rectangle);
	    if( evt.getKeyCode() == evt.VK_F&&ballintersectsp1 )  /////////////////////////// If you press F, hold it down
		game.b.holdBallToPaddle(game.p1);               /////////////////////////////////////////////////////////
	    if( evt.getKeyCode() == evt.VK_F&&ballintersectsp2 )
		game.b.holdBallToPaddle(game.p2);
	    
	    if( game.b.isStopped())
		{
		    if( evt.getKeyCode() == evt.VK_SPACE )
			game.b.startBall();
		    if( evt.getKeyCode() == evt.VK_P )
			game.b.startBall();
		    if( evt.getKeyCode() == evt.VK_M ) {
			jf.setVisible(false);
		        
		    }
		    else 
			theball.yield();
		}
	    else {
		if( evt.getKeyCode() == evt.VK_P )
		    game.b.stopBall();
	    }
		
	}

	/** keyReleased checks if certain keys are released
	 * @param evt the KeyEvent
	 */
	public void keyReleased(KeyEvent evt){
	    game.p1.keyReleased(evt);
	    game.p2.keyReleased(evt);
	}
    }  
}
