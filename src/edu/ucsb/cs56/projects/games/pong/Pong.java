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

    int points;
    Paddle p1;
    Paddle p2;
    Ball b;
    
    int ballsLost = 0;
    JTextField text;
    JScrollPane jScrollPane1;
    
    /** Pong constructor to initialize 2 paddle objects, a ball object, and points value
     */

    public Pong() {
        this.p1 = new Paddle(8,160);
        this.p2 = new Paddle(Screen.w - 18 , 160, true);
        this.b = new Ball((int)(Screen.w / 2),(int)(Screen.h / 2),20,20);
        this.points = 0;
        this.text = new JTextField();
        this.ballsLost = 0;
    }

    /** returns the current value of points
     */

    public int getPoints() {
        return points;
    }
    
    /** sets points value to newPoints
     *  @param newPoints chooses a new amount of points
     */

    public void setPoints(int newPoints) {
        this.points = newPoints;
    }

    /** draw a ball to the screen, draw Win or Lose game depending on points value
     *  @param g graphics draws the pink ball.
     */

    public void draw(Graphics g) {
        b.draw(g);
    
	if(ballsLost >= 3) {
	    gameLoss();
	    g.setFont(new Font("sansserif", Font.BOLD, 32));
	    g.setColor(Color.WHITE);
	    g.drawString("GAME OVER!",275,100);
	}
    }

    /** handles player winning the game,  reset ball values to 0 and stop the ball from moving
     */

    public void gameWin(){
        b.setdx(0);
        b.setdy(0);
        b.setXpos(0);
        b.setYpos(0);
        b = null;
    }

    /** handles players losing the game, stop the ball from moving
     */

    public void gameLoss(){
        final JFrame f = new JFrame();
	JLabel label = new JLabel("Enter your name!", JLabel.CENTER);
        JPanel newF = new JPanel();
        final JTextField text = new JTextField();
        JButton button = new JButton("Enter");
	newF.setLayout(new GridLayout(5,3,0,10));

	newF.add(new JLabel(""));
	newF.add(new JLabel(""));
	newF.add(new JLabel(""));	
	newF.add(new JLabel(""));
	
	newF.add(label);	
	newF.add(new JLabel(""));	
	newF.add(new JLabel(""));
        
	newF.add(text);
	newF.add(new JLabel(""));
	newF.add(new JLabel(""));
        
	newF.add(button);
	newF.add(new JLabel(""));	
	newF.add(new JLabel(""));	
	newF.add(new JLabel(""));	
	newF.add(new JLabel(""));

        f.setSize(Screen.w,Screen.h);
        f.add(newF);
        f.setVisible(true);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {//Execute when button is pressed
                try{
                    // Create file 
                    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("scores.txt", true)));
                    out.write(points + " " + text.getText() + "\n");
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
                    
                }catch (Exception ex){//Catch exception if any
                    System.err.println("Error: " + ex.getMessage());
                }
            }
        });
        
        b.setdx(0);
        b.x =0;
        b.y =0;
        b = null;
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

    /** resets the points back to 0
     */

    public void pointsReset(){
        this.points = 0;
    }

    /** Move the paddles and the ball. Check for collision 
     */

    public void moveGame() {
        p1.movePaddle();
        p2.movePaddle();
        b.setXpos(b.getXpos()+b.getdx());
        b.setYpos(b.getYpos()+b.getdy());
        paddleCollision();
        wallCollision();
        }
    
        /** Detect whether ball hits a paddle
         */

        public void paddleCollision() {
        if((b.rect).intersects(p1.p)){
            b.setdx(3);
        }
    
        if((b.rect).intersects(p2.p)){
            b.setdx(3);
        }
    }

    /** Detect whether the ball hits a wall
     */

    public void wallCollision() {
        if(b.getXpos() <= (Screen.w - Screen.w)){
            b.setdx(-3);
            this.ballsLost++;
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

    /** Run thread to move paddles and ball
     */

    public void run(){
        try{
            while(true){
                moveGame();
                Thread.sleep(15);
            }
        }catch(Exception e){}
    }   
}
