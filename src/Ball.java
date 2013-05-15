import java.io.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.text.*;
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

/** Ball is the class that will move the ball around the screen


@author Timothy Fok
@version CS56, Spring 2012, UCSB
*/
public class Ball implements Runnable{

	int x,y;
	int dx,dy;
	int w,h;
	Rectangle b;
	//  Oval c;

	int points = 0;
	int ballsLost = 0;
	JTextField text;
	JScrollPane jScrollPane1;

	Paddle p1 = new Paddle(8,160);
	PaddleRight p2 = new PaddleRight(50, 160);

/** Ball constructor to initialize location of Ball onto the screen
*  and draw it as a rectangle for a simpler and precise hitbox.
*  @param x set initial x coordinate of ball
*  @param y set initial y coordinate of ball
*/
public Ball(int x, int y, int w, int h){
	this.x = x;
	this.y = y;
	this.w = w;
	this.h = h;
	text = new JTextField();
	ballsLost = 0;
	points = 0;
	setdx(-2);
	setdy(1);
	b = new Rectangle(this.x,this.y,20,20);
	//	c = new Oval(this.x,this.y, 20,20);
}   

/** sets a different x position for the ball
*  @param x chooses the new x position
*/
public void setXpos(int x){
	this.x = x;
}

/** sets a different y position for the ball
*  @param y chooses the new x position
*/
public void setYpos(int y){
	this.y = y;
}

/** sets a different speed of x position for the ball
*  @param x chooses the new x speed
*/
public void setdx(int newdx){
	dx = newdx;
}

/** sets a different speed of y position for the ball
*  @param x chooses the new y speed
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
	//	g.fillRect(b.x,b.y,b.width,b.height);  
	g.fillOval(b.x,b.y,b.width,b.height);

	//	g2.fill(c);
	if(ballsLost >= 1) //number of tries
	{

		gameLoss();
		//pointsReset();
		//setdx(0);
		// setdy(0);
		g.setFont(new Font("sansserif", Font.BOLD, 32));
		g.setColor(Color.WHITE);
		g.drawString("GAME OVER!",275,100);
	}

		}

/** runs the ball Thread, gets the ball animating
*/
public void run(){
	try{
		while(true){
			moveBall();
			Thread.sleep(8);}
		}
		catch(Exception e)
		{
		}
	}


/** resets the ball to the middle parts of the screen
*/
public void resetBall(){
	if (b.x <= Screen.w - Screen.w){
		b.x = Screen.w/2;
		b.y = Screen.h/2;
	}

}

/** handles players losing the game, stop the ball from moving
*/
public void gameLoss(){

	text.setVisible(true);
	text.setEditable(true);
	text.setBounds (245, 50, 60, 25);
	//jScrollPane1 = new JScrollPane(text);
	//	add(text);
	final JFrame f = new JFrame();
	JLabel label = new JLabel("Enter your name!");
	JPanel newF = new JPanel();
	final JTextField text = new JTextField();
	JButton button = new JButton("Enter");

	//	newF.setSize(500,500);
	newF.add(label);
	newF.add(text);
	newF.add(button);
	button.setPreferredSize(new Dimension(60,40));
	text.setPreferredSize(new Dimension(150,40)); 
	f.setSize(400,80);
	f.add(newF);
	f.setVisible(true);
	button.addActionListener(new ActionListener() {

		public void actionPerformed(ActionEvent e)
		{
			//Execute when button is pressed
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
				// Deal with the line

				// Done with the file
				br2.close();
				int lineSize = yo.size();
				String[] gameNames = new String[lineSize];
				String[] gameScores = new String[lineSize];
				if(lineSize > 0){
					for(int i = 0; i < lineSize; i++)
					{
						for(int j = 0; j < yo.get(i).length() - 1; j++)
						{
							if(yo.get(i).substring(j, j+1).equals(" ")){
								gameScores[i] = yo.get(i).substring(0, j); 
								gameNames[i] = yo.get(i).substring(j, yo.get(i).length());
								break;
							}
						}
					}	
				}
				// int check = 0;
				// 					 	for(int i = 0; i < lineSize; i++)
				// 					 	{
					// 							check=0;
					// 							for(int j = 0; j < 5; j++)
					// 							{
						// 								if(Integer.parseInt(gameScores[i]) > fifth[j])
						// 								{
							// 									if(4-check+1 != 5){
								// 										while(4-check > 0)
								// 										{
									// 											fifth[4-check+1] = fifth[4-check];
									// 											gameScores[4-check+1] = gameScores[4-check];
									// 											gameNames[4-check+1] = gameNames[4-check];
									// 											check++;
									// 											break;
									// 										}
									// 									} 
									// 									fifth[4-j] = Integer.parseInt(gameScores[i]);
									// 									gameScores[4-j] = gameScores[i];
									// 									gameNames[4-j] = gameNames[i];
									// 									break;
									// 								}
									// 									check++;
									// 							}
									// 								
									// 					 	}
									// 					
									// 						if(lineSize > 5)
									// 							for(int i= 5; i > 0; i--)
									// 						{
										// 							System.out.println("Name " + gameNames[i] + " " + gameScores[i]);
										// 						}
										// 						else
										// 						{
											// 							for(int i= lineSize; i > 0; i--)
											// 							{
												// 								System.out.println("Name " + gameNames[i] + " " + gameScores[i]);
												// 							}	
												// 						}	
												//insertion_srt(gameNames,gameScores, listSize);
												int[] scores = new int[lineSize];
												for(int i = 0; i < lineSize; i++)
												{
													scores[i] = Integer.parseInt(gameScores[i]);
												}	
												insertion_srt(scores,gameNames, lineSize);
												if(lineSize >= 5)
												for (int v= lineSize-1;v>lineSize-6;v--)
													System.out.println(scores[v] + gameNames[v]);
												else
												{
													for(int v = lineSize - 1; v >= 0; v--)
														System.out.println(scores[v] + gameNames[v]);
												}
												JFrame hs = new JFrame();
												JPanel npl = new JPanel();
												JLabel l1 = new JLabel("1st: " + gameNames[lineSize-1] + "," +scores[lineSize-1] + " ");
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
												hs.setSize(500,100);
												hs.setVisible(true);
													
											}catch (Exception ex){//Catch exception if any
												System.err.println("Error: " + ex.getMessage());
											}
									}
									});
									setdx(0);
									b.x =0;
									b.y =0;
									b = null;
								}

								public static void insertion_srt(int array[], String array2[], int n){
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
						//	}

/** handles players winning the game, stops the ball from moving
*/
public void gameWin(){
	setdx(0);
	setdy(0); 
	b.x =0;
	b.y =0;
	b = null;
	//	p1 = null;
	//	p2 = null; 
	//	Screen = null;
}

/** resets the points back to 0
*/
public void pointsReset(){
	points = 0;
}


/** moves the ball around and checks for if it hits walls and paddle. Changes
*  speed upon collision of walls and paddle.
*/
public void moveBall(){

	b.x += dx;
	b.y += dy;

	if(b.intersects(p1.p)){
		setdx(3);
	}

	if(b.intersects(p2.pad)){
		setdx(3);
	}

	if(b.x <= (Screen.w - Screen.w)){
		setdx(-3);
		//  points--;
		ballsLost++;
		resetBall();
	}
	if(b.x >= (Screen.w - 20)){
		setdx(-3);
		points++;
	}
	if(b.y >= (Screen.h - 20)){
		setdy(-3);
	}
	if(b.y <= (Screen.h - Screen.h + 30)){
		setdy(3);
	}
}

}