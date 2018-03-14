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
import java.util.ArrayList;


/** Screen is the GUI implementation of the Pong game
 * @author Timothy Fok 
 * @author Bhanu Khanijau, Sanchit Gupta   
 * @author Jake Dumont, Heneli Kailahi
 * @author Benjamin Hartl, Sarah Darwiche
 * @author Vincent Gandolfo, Krishna Lingampalli
 * @author Victoria Sneddon, Andrew Polk
 * @version CS56, Fall 2017, UCSB
*/
public class Screen{

    /** holds JFrame object */
    public static JFrame jf;

    /**holds width of screen */
    static int w;

    /**holds height of screen*/
    static int h;

    /** holds new Pong object */
    public Pong game;

    /** Graphics object */
    public Graphics doublebufferG;

    /** Image object*/
    public Image doublebufferImg;

    /** thread for ball */
    static Thread theball;

    /**draw panel */
    MyDrawPanel mdp;

    /**Number of balls*/
    int ballNum;

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

	ballNum = DifficultyLevel.getBallNum();
	
	game = new Pong();
	theball = new Thread(game);
	theball.start();
	
	jf.addKeyListener(new myKeyAdapter());

	edu.ucsb.cs56.projects.games.pong.Game.setWindowVisibility(false);
	//Opens window with a static method that can be called from anywhere
	setWindowVisibility(true);
    }

    /**sets window open or closed
     * @param visibility boolean if window is visible or not
     */
    public static void setWindowVisibility(boolean visibility){
	jf.setVisible(visibility);
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
	    g.drawString("Hits: " + game.getHits(), Screen.w/2 - 60, 40);
	    g.drawString( "player 1 ", 30, 40 );
	    g.drawString( "" + game.getPlayer1().getPoints(), 30, 70 );
	    g.drawString( "player 2 ", Screen.w - 180, 40 );
	    g.drawString( "" + game.getPlayer2().getPoints(), Screen.w - 70, 70 );
	    g.drawString( "Lives " + ( game.getPlayer1().ballCount ), 30, Screen.h - 47 );
	    g.drawString( "Lives " + ( game.getPlayer2().ballCount ), Screen.w - 140 , Screen.h - 47 );

	    //draws all the balls
	    for(int i = 0; i < ballNum; i++){
		game.b[i].draw(g);
	    }
	    
	    //If all the balls have stopped then pause the game //change Pong.isPaused
	    if(game.checkBallStopped()) {
		g.drawString( "Game Paused", Screen.w/2 - 100, Screen.h/2 - 100 );
		g.drawString( "Press M to return to Main Menu", Screen.w/2 - 220, Screen.h/2 + 100 );
	    }
	    game.getPlayer1().draw(g);
	    game.getPlayer2().draw(g);
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
	public void keyPressed(KeyEvent evt) {
	    game.getPlayer1().keyPressed(evt);
	    game.getPlayer2().keyPressed(evt);
	    for(int i = 0; i < ballNum; i++){
		ArrayList<Double> distance = distanceCalc(i);
		game.b[i].keyPressed(evt, distance);
	    }

	    //Starts all the balls once they are all sitting in the center and space is pressed
	    if(game.checkBallStopped()) {
		Pong.isPaused = true;
		for(int i = 0; i < ballNum; i++){
		    if( evt.getKeyCode() == KeyEvent.VK_SPACE ) {
			game.b[i].startBall();
			Pong.isPaused = false;
		    }if( evt.getKeyCode() == KeyEvent.VK_P ) {
 			if(Pong.isPaused) {
			    game.b[i].startBall();
			}
		    }
		    else 
			theball.yield();
		}
	    }
	    
	    if( evt.getKeyCode() == KeyEvent.VK_P ) {
		Pong.isPaused = !Pong.isPaused;
	    }
	    if(Pong.isPaused) {
		if( evt.getKeyCode() == KeyEvent.VK_M ) {
		    setWindowVisibility(false);
		    edu.ucsb.cs56.projects.games.pong.Game.setWindowVisibility(true);
		}
	    }
	}
	
	/** keyReleased checks if certain keys are released
	 * @param evt the KeyEvent
	 */
	public void keyReleased(KeyEvent evt){
	    for(int i = 0; i < ballNum; i++){
		ArrayList<Double> distance = distanceCalc(i);
		game.getPlayer1().keyReleased(evt);
		game.getPlayer2().keyReleased(evt);
		game.b[i].keyReleased(evt, distance);
	    }
	}
    }
    
    /** calculates distance and returns it in arrayList
     * @params i array index of ball being checked
     * @return ArrayList list of distances
     */ 
    public ArrayList<Double> distanceCalc(int i) {
    	ArrayList<Double> distance = new ArrayList<Double>();
    	
    	int p1x=game.getPlayer1().getXCoordinate();
	int p1y=game.getPlayer1().getYCoordinate();
	int p2x=game.getPlayer2().getXCoordinate();
	int p2y=game.getPlayer2().getYCoordinate();
	int bx =game.b[i].getXCoordinate();
	int by =game.b[i].getYCoordinate();
	
	double p1fromBall =Math.hypot(Math.abs(p1x-bx),Math.abs(p1y-by));
	double p2fromBall =Math.hypot(Math.abs(p2x-bx),Math.abs(p2y-by));
	
	double p1fromBottom = (double) Screen.h- p1y -DifficultyLevel.getPaddleHeight() - 25;
	double p2fromBottom = (double) Screen.h - p2y - DifficultyLevel.getPaddleHeight() - 25;
	
	distance.add(0, p1fromBall);
	distance.add(1, p2fromBall);
	distance.add(2, p1fromBottom);
	distance.add(3, p2fromBottom);
	distance.add(4, (double) p1y);
	distance.add(5, (double) p2y);
	
	return distance;
    }
}
