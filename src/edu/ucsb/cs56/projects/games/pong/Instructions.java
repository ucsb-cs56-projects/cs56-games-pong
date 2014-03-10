package edu.ucsb.cs56.projects.games.pong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Instructions{
    JFrame jf;
    Instructions()
    {
	jf = new JFrame( "Instructions" );
	jf.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	jf.setSize( 640, 480 );
	JButton backToMain = new JButton( "Back To Main Menu" );
	backToMain.addActionListener( new BackToMainListener());
	jf.add(backToMain, BorderLayout.SOUTH );
	jf.setLocationRelativeTo( null );
	setToVisible();
	JPanel jp = new JPanel();
	jf.add( jp );
	JLabel l = new JLabel(displayInstructions(), SwingConstants.CENTER);

	///////////////  Set Instructions   ^^^^
	//////////////////////
 	jp.add( l );
    }
    
    public void setToVisible()
    {
	jf.setVisible(true);
	displayInstructions();
    }
    
    public String displayInstructions()
    {
	return ("<html><p><br>Difficulty:<br>The Screen size increases with the difficulty that is chosen.<br><br>How To Play:<br>Player 1 uses W to move the paddle up and S to move their paddle down.<br>Player 2 uses the Up and Down arrows to move their paddle up and down<br><br>Hit the space bar to move the ball initially.<br>The ball will increase in speed every 5 times it hits a paddle.<br>You lose a life if you miss the ball.<br>When you lose a life, the total hits will be added to your opponents score.<br>The winner is the player with remaining lives.</p></html>");
    }

    class BackToMainListener implements ActionListener{
	public void actionPerformed(ActionEvent e){
	    jf.setVisible(false);
	}
    }


}
