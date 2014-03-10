package edu.ucsb.cs56.projects.games.pong;

import javax.swing.*;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color; // class for Colors
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;  // squares and rectangles
import java.awt.Shape; // general class for shapes
import java.awt.Stroke;
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.geom.Ellipse2D;  // ellipses and circles
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.Line2D;  // single lines
import java.awt.geom.Rectangle2D; // for the bounding box
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

/** edu.ucsb.cs56.projects.games.pong.Ball is the class that will move the ball around the screen

 @author Sanchit Gupta, Bhanu Khanijau
 @author Heneli Kailahi, Jake Dumont  
 @author Benjamin Hartl, Sarah Darwiche
 @version CS56, Winter 2014, UCSB
*/

public class Pong implements Runnable {

    int hits;               // times it hits a paddle
    Paddle p1;              // Left Paddle
    Paddle p2;              // Right Paddle
    Ball b;                 // the ball
    int moreSpeed = 1;      // to increase speed every 4 hits
    boolean gameIsGoing = true;
    Paddle winner;
    
    /** Pong constructor to initialize 2 paddle objects, a ball object, and points value
     */

    public Pong() {
     
        p1 = new Paddle( 8, 160 );                      // Left Paddle
        p2 = new Paddle( Screen.w - 18 , 160, true );  // Right Paddle
        b = new Ball( (int)(Screen.w / 2), (int)(Screen.h / 2), 20, 20 );
        hits = 0;                                      // # of times of wall
    }

    /** returns the current value of times it hits a wall
     */

    public int getHits( ) { return hits; }      // times it hit any paddle
    
    public void incrementHits() { hits++; }    // whenever it hits a paddle

    public void hitsReset(){ hits = 0; }       // when a paddle misses the ball

    public void setWinner(Paddle a) { winner = a; }

    public Paddle getWinner(){ return winner;}

    public String toString() {
	if( winner.right == true)
	    return "Player 2";
	else
	    return "Player 1";
	    }

    public void checkGameStatus(){
	if(p2.ballCount <= 0 ){
	    System.out.println("player 2 lost");
	    setWinner(p1);
	     gameLoss(p2);
	}
	else if(p1.ballCount <= 0 ){
	    System.out.println("player 1 lost");
	    setWinner(p2);
	    gameLoss(p1);
	}
    }

    public void draw(Graphics g) {             // to draw the ball
        b.draw(g);
	
	/**	if( p2.ballsLost >= 3 )                // each player has 3 lives
	    {
		////////////////////////////////////////////
		// infinite loop
		gameLoss( p2 );                // will print p2 lost
	    }

	else if( p1.ballsLost >= 3 ) 
	    {
	    //g.setFont(new Font("sansserif", Font.BOLD, 32));
	    //g.setColor(Color.WHITE);
	    //g.drawString("GAME OVER!",275,100);
		gameLoss( p1 );
		}*/
    }

   
    public void gameLoss( Paddle p )
    {
	
        gameEnd();
	kill();
	
    }

    public void gameEnd(){
        
	final JFrame f = new JFrame();
	JLabel label = new JLabel( toString() + " wins!", JLabel.CENTER);
	JLabel label2 = new JLabel("Enter your name!", JLabel.CENTER);
        JPanel newF = new JPanel();
        final JTextField text = new JTextField();
        JButton button = new JButton("Enter");
	newF.setLayout(new GridLayout(5,3,0,10));

	newF.add(new JLabel("")); ////////////////////////////////////
	newF.add(label);
	newF.add(new JLabel(""));	
	newF.add(new JLabel(""));
	
	newF.add(label2);	
	newF.add(new JLabel("")); // set empty labels to fill grid layout
	newF.add(new JLabel(""));
        
	newF.add(text);
	newF.add(new JLabel(""));
	newF.add(new JLabel(""));
        
	newF.add(button);
	newF.add(new JLabel(""));	
	newF.add(new JLabel(""));	
	newF.add(new JLabel(""));	
	newF.add(new JLabel("")); ///////////////////////////////////

        f.setSize(Screen.w,Screen.h);
        f.add(newF);
        f.setVisible(true);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {//Execute when button is pressed
                try{
                    // Create file 
                    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("scores.txt", true)));
                    out.write(hits + " " + text.getText() + "\n");
                    out.close();
                    f.dispose();    
                    ArrayList<String> yo = new ArrayList<String>();         
                    BufferedReader br2 = new BufferedReader(new FileReader("scores.txt"));
                    String line;
                    int[] fifth  = {0,0,0,0,0};
                    while ((line = br2.readLine()) != null) {
                        yo.add(line);
                    }
                    br2.close();
                    int lineSize = yo.size();
                    
                    while(lineSize < 5){
                        out = new PrintWriter(new BufferedWriter(new FileWriter("scores.txt", true)));
                        out.write(0 + " null\n");
                        out.close();
                        lineSize++;
                    }               
                    
                    br2 = new BufferedReader(new FileReader("scores.txt"));
                    int r = 0;
                    
                    while(yo.size() != 0){
                        yo.remove(r);
                    }
                    
                    while ((line = br2.readLine()) != null) {
                            yo.add(line);
                    }
                    
                    String[] gameNames = new String[lineSize];
                    String[] gameScores = new String[lineSize];
                    
                    for(int i = 0; i < 5; i++){
                        gameNames[i] = "0";
                        gameScores[i] = "0";
                    }
                    
                    if(lineSize > 0){
                        for(int i = 0; i < lineSize; i++){
                            for(int j = 0; j < yo.get(i).length() - 1; j++){
                                if(yo.get(i).substring(j, j+1).equals(" ")){
                                    gameScores[i] = yo.get(i).substring(0, j); 
                                    gameNames[i] = yo.get(i).substring(j, yo.get(i).length());
                                    break;
                                }
                            }
                        }   
                    }
                    
                    int[] scores = new int[lineSize];
                    
                    for(int i = 0; i < lineSize; i++){
                        scores[i] = Integer.parseInt(gameScores[i]);
                    }   
                    
                    sortArray(scores,gameNames,lineSize);
                    
                    if(lineSize >= 5){
                        for (int v= lineSize-1;v>lineSize-6;v--)
                            System.out.println(scores[v] + gameNames[v]);
                    }               
                    else{
                        for(int v = lineSize - 1; v >= 0; v--)
                            System.out.println(scores[v] + gameNames[v]);
                    }
                    
                    JFrame hs = new JFrame();
                    JPanel npl = new JPanel();
                    JLabel l1 = new JLabel("1st: " + gameNames[lineSize-1] + "," +scores[lineSize-1] + " \n");
                    JLabel l2 = new JLabel("2nd: " + gameNames[lineSize-2] + "," +scores[lineSize-2] + " ");
                    JLabel l3 = new JLabel("3rd: " + gameNames[lineSize-3] + "," +scores[lineSize-3] + " ");
                    JLabel l4 = new JLabel("4th: " + gameNames[lineSize-4] + "," +scores[lineSize-4] + " ");
                    JLabel l5 = new JLabel("5th: " + gameNames[lineSize-5] + "," +scores[lineSize-5] + " ");
                    npl.add(l1);
                    npl.add(l2);
                    npl.add(l3);
                    npl.add(l4);
                    npl.add(l5);
                    hs.add(npl);
                    hs.pack();
                    hs.setTitle("High Scores!");
                    hs.setSize(500,100);
                    hs.setVisible(true);
                    
                }catch (Exception ex){  //Catch exception if any
                    System.err.println("Error:******** " + ex);
		    // returns java.lang.NumberFormatException: null
                }
            }
        });
        
	////////////////////////////////////// dont need if set b = null
        //b.setXVelocity( 0 );
        //b.setXCoordinate( 0 );
        //b.setYCoordinate( 0 );
        b = null;
      
	//b = null;   // removes ball
	//System.out.println( "gameLoss, stub" );
   }

    /** sort 2 arrays using insertsort method to help make leaderboard
    *  @param array[] sort game scores
    *  @param array2[] sort player names according to game scores sorting
    */

    public static void sortArray(int array[], String array2[], int n){
        for (int i = 1; i < n; i++){
            int j = i;
            int B = array[i];
            String C = array2[i];
            while ((j > 0) && (array[j-1] > B)){
                array[j] = array[j-1];
                array2[j] = array2[j-1];
                j--;
            }
            array[j] = B;
            array2[j]=C;
        }
    }

    public void moveGame() { // every iterations of thread the ball calls this
        p1.movePaddle();     // draws paddles at new location
        p2.movePaddle();      
	//                   // sets the new locations
	b.setXCoordinate( b.getXCoordinate() + b.getXVelocity() );
        b.setYCoordinate( b.getYCoordinate() + b.getYVelocity() );
	//                   // checks if it hit a paddle
	paddleCollision();
	//                   // checks if it hit a wall
        wallCollision();
    }
    
    /** Detect whether ball hits a paddle
     */
    
    public void paddleCollision() {// speed starts out at 1
	if( getHits() % 5 == 0 )   // every 5 hits increases speed by 1,
	    moreSpeed = 1;
	else
	    moreSpeed = 0;	       

	// Sets the new velocity if it hits either paddle, p1 or p2
	if( ( b.rectangle ).intersects( p1.rectangle ) ){  // if ball hits p1
	    b.setXVelocity( -1 * ( b.getXVelocity() - moreSpeed ) );
	    incrementHits();                               // count hits
	}
	
	else if( ( b.rectangle ).intersects( p2.rectangle ) ){// if ball hits p2
            b.setXVelocity( -1 * ( b.getXVelocity() + moreSpeed ) );
	    incrementHits();                               // count hits
        }
    }
    
    /** Detect whether the ball hits a wall
     */

    public void wallCollision() 
    {
	//  when p1 misses / hits the wall behind it
        if( b.getXCoordinate() <= ( 0 ) )
	    {
		// increments ballsLost for p1, only get 3
		// sets velocity facing opposite direction
		// resets ball to the middle
		// adds points, 
		p1.playerMissed( b, getHits(), p2 );  // increment ballsLost for p1
		gameObject.isGoingRight = true;
		hitsReset();
	    }
        else if( b.getXCoordinate() >= ( Screen.w - 20 ) )
	    {
		p2.playerMissed( b, getHits(), p1 );
		gameObject.isGoingRight = false;
		hitsReset();
	    }
	
	if( b.getYCoordinate() >= ( Screen.h - 20 ) )
	    {
		b.setYVelocity( -1 * b.getYVelocity() );
	    }
        else if( b.getYCoordinate() <=  30 )
	    {
		b.setYVelocity( -1 * b.getYVelocity() );
	    }

	checkGameStatus();
    }

    /** Run thread to move paddles and ball
     */

    public void run(){
	b.stopBall();
        try{
            while( gameIsGoing ){
                moveGame();
                Thread.sleep(15);
            }
        }catch(Exception e){}
	
    }
    public void kill()
    {
	gameIsGoing = false;
	Screen.theball.stop();
    }
}
    
