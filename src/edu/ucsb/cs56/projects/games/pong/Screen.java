package edu.ucsb.cs56.projects.games.pong;

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
 @author Benjamin Hartl, Sarah Darwiche
 @version CS56, Spring 2013, UCSB
*/

public class Screen{
    static JFrame jf;
    static int w;
    static int h;
    public Pong game;
    public Graphics doublebufferG;
    public Image doublebufferImg;
    static Thread theball;
    MyDrawPanel mdp;



    // Screen Constructor and mouseEntered function to unpause game
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

    public void setScreenSize( int width, int height )
    {
	w = width;
	h = height;
	jf.setSize( w, h );
	jf.setLocationRelativeTo( null );

    }

    class MyDrawPanel extends JPanel{
	// draw text, ball, paddle onto screen
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
	    
	    
	    game.b.draw(g);
	    game.p1.draw(g);
	    game.p2.draw(g);
	    jf.repaint();
	}
	
	// paint buffer graphics onto screen
	public void paint(Graphics g){
	    doublebufferImg = jf.createImage( jf.getWidth(), jf.getHeight());
	    doublebufferG = doublebufferImg.getGraphics();
	    draw( doublebufferG );
	    g.drawImage( doublebufferImg, 0, 0, jf );
	}
    }
	
   // Handles up and down keys for movement of paddle.  
    public class myKeyAdapter extends KeyAdapter {
	public void keyPressed(KeyEvent evt){
	    game.p1.keyPressed(evt);
	    game.p2.keyPressed(evt);
	    if( game.b.isStopped() )
		{
		    if( evt.getKeyCode() == evt.VK_SPACE )
			game.b.startBall();
		    else
			theball.yield();
		}
	}


	public void keyReleased(KeyEvent evt){
	    game.p1.keyReleased(evt);
	    game.p2.keyReleased(evt);
	}
    }  
}
