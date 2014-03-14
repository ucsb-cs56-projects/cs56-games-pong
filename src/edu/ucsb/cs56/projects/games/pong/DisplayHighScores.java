package edu.ucsb.cs56.projects.games.pong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//Class to display High Scores
public class DisplayHighScores{

    JFrame jf;
    JPanel jp;
    EndOfGame eog;
    DisplayHighScores( String name, int score )
    {
	eog = new EndOfGame( score, name ); //Call EndOfGame()
	setUpFrame();
	setUpFrameComponents();
	showScores();
    }
    //Set up frame structure for High Score Window
    public void setUpFrame()
    {
	jf = new JFrame( "High Scores" );
	jp = new JPanel();
	jf.add( jp );
	jp.setLayout( new BoxLayout( jp, BoxLayout.Y_AXIS ) );
        jf.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        jf.setSize( 640, 480 );
	jf.setLocationRelativeTo( null );
	jf.setVisible( true );
	jf.setResizable( false );

    }

    public void setUpFrameComponents()
    {
	JButton backToMain = new JButton( "Back To Main Menu" );
	backToMain.addActionListener( new BackToMainListener() );
	jf.add( backToMain, BorderLayout.SOUTH );

	JPanel jp = new JPanel();
	jf.add( jp );
    }

    //Print scores on labels
    public void showScores()
    {
	for( int i = 0; i < 5; i++ )
	    {
		jp.add( new JLabel( eog.hList.get( i ).toString( ": ", "" ), JLabel.CENTER ) );
	    }
    }

    class BackToMainListener implements ActionListener{
	public void actionPerformed(ActionEvent e){
	    jf.setVisible(false);
	}
    }

}
