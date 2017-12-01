package edu.ucsb.cs56.projects.games.pong.menu.instructions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/** edu.ucsb.cs56.projects.games.pong.menu.instructions.Instructions is the classs that displays the instructions to the game when the user presses the instructions button
 @author Vincent Gandolfo, Krishna Lingampalli
 @version CS56, Winter 2015, UCSB
 @author Victoria Sneddon, Andrew Polk
 @version CS56, Fall 2017, UCSB
*/

public class Instructions{
    JFrame jf;

    /** Constructor that sets up the JFrame and Components that allow the instructions to be displayed */
    public Instructions()
    {
	setUpFrame();
	setUpFrameComponents();
    }

    /** setUpFrame() creates the Frame, names it, and sets the size of the frame */
    public void setUpFrame()
    {
	jf = new JFrame( "Instructions" );
	jf.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	jf.setSize( 640, 640 );

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

    /** displayInstructions() displays the Instructions on how to play
     * @return String returns instructions
     */
    public String displayInstructions()
    {
	return ("<html><p><br>Difficulty:<br>The Screen size increases with the difficulty that is chosen.<br><br>How To Play:<br><br>Player 1 uses W to move the paddle up,<br> S to move their paddle down, and A to grab the ball.<br>Player 2 uses the Up and Down arrows to move their paddle up and<br> down and the left arrow to grab the ball.<br><br>When ball is being held and the player releases it while moving their paddle up or down,<br>ball will be released with the same speed that the paddle is moving<br><br>Hit the space bar to move the ball initially.<br><br>Press P to pause the game.<br>Press M to return to the Main Menu.<br>You lose a life if you miss the ball.<br>When you lose a life, the total hits will be added to your opponents score.<br>The winner is the player with remaining lives.<br><br>Chaos Mode:<br> very small ball on large screen moving at faster than normal speed<br><br>Custom Mode:<br>Allows players to select both level and how many balls they would like<br>to be in play at one time at the level selected.<br><br>Information on Ball to Paddle Speed:<br>When ball is released, it has the same y-velocity as your paddle.<br>The ball increases in speed after each hit of paddle.</p></html>");
    }

    /** The action when the button "Back To Main Menu" is pressed. It just makes the frame not visible, so it appears to be closed and does not need to create a new instance of Instructions for every time the user clicks how to play */
    class BackToMainListener implements ActionListener{
	public void actionPerformed(ActionEvent e){
	    jf.setVisible(false);
	}
    }


}
