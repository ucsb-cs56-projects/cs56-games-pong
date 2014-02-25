package edu.ucsb.cs56.projects.games.pong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Instructions{
    JFrame jf;
    Instructions()
    {
	jf = new JFrame( "test" );
	jf.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	jf.setSize( 640, 480 );
	JButton backToMain = new JButton( "Back To Main Menu" );
	backToMain.addActionListener( new BackToMainListener());
	jf.add(backToMain, BorderLayout.SOUTH );
	jf.setLocationRelativeTo( null );
	setToVisible();
	JPanel jp = new JPanel();
	jf.add( jp );
	JLabel l = new JLabel("<html><p>Here<br>is the text that we want<br>and will see if it goes to the new<br>line. It works to have it in the center<br>but now it will create a new line</p></html>", SwingConstants.CENTER);

	///////////////  Set Instructions   ^^^^
	//////////////////////
 	jp.add( l );
    }
    
    public void setToVisible()
    {
	jf.setVisible(true);
	displayInstructions();
    }
    
    public void displayInstructions()
    {
	System.out.println("Stub,instructions go here");
    }

    class BackToMainListener implements ActionListener{
	public void actionPerformed(ActionEvent e){
	    jf.setVisible(false);
	}
    }


}
