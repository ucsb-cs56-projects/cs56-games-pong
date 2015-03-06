package edu.ucsb.cs56.projects.games.pong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/** edu.ucsb.cs56.projects.games.pong.Instructions is the classs that displays the instructions to the game when the user presses the instructions button
 @author Vincent Gandolfo, Krishna Lingampalli
 @version CS56, Winter 2015, UCSB
*/

public class Instructions{
    JFrame jf;         
    
    /** Constructor that sets up the JFrame and Components that allow the instructions to be displayed */
    Instructions()
    {
	setUpFrame();
	setUpFrameComponents();
    }

    /** setUpFrame() creates the Frame, names it, and sets the size of the frame */
    public void setUpFrame()
    {
	jf = new JFrame( "Instructions" );
	jf.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	jf.setSize( 640, 480 );
	
	jf.setLocationRelativeTo( null );
	jf.setResizable( false );
	setToVisible();

    }
    
    /** setUpFrameComponents()  sets up the layout on the frame and puts on the Instructions and the "Back To Main Menu" button */
    public void setUpFrameComponents()
    {
	JButton backToMain = new JButton( "Back To Main Menu" );
	backToMain.addActionListener( new BackToMainListener() );
	jf.add( backToMain, BorderLayout.SOUTH );

	JPanel jp = new JPanel();
	jf.add( jp );
	
	JLabel l = new JLabel( displayInstructions(), SwingConstants.CENTER );
 	jp.add( l );
    }
    
    /** setToVisible()  Sets the frame to visible */
    public void setToVisible()
    {
	jf.setVisible(true);
    }
    
    /** displayInstructions() displays the Instructions on how to play */
    public String displayInstructions()
    {
	return ("<html><p><br>Difficulty:<br>The Screen size increases with the difficulty that is chosen.<br><br>How To Play:<br>Player 1 uses W to move the paddle up and S to move their paddle down.<br>Player 2 uses the Up and Down arrows to move their paddle up and down<br><br>Hit the space bar to move the ball initially.<br>Press P to pause the game.<br>Press M to return to the Main Menu.<br>The ball will increase in speed every 5 times it hits a paddle.<br>You lose a life if you miss the ball.<br>When you lose a life, the total hits will be added to your opponents score.<br>The winner is the player with remaining lives.</p></html>");
    }

    /** The action when the button "Back To Main Menu" is pressed. It just makes the frame not visible, so it appears to be closed and does not need to create a new instance of Instructions for every time the user clicks how to play */
    class BackToMainListener implements ActionListener{
	public void actionPerformed(ActionEvent e){
	    jf.setVisible(false);
	}
    }


}
