package edu.ucsb.cs56.projects.games.pong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameOver{
    
    JFrame jf;
    JPanel jp;
    String name;
    int score;
    JTextField text;

    GameOver( String winner, int points )
    {
	name = winner;
	score = points;
	setUpFrame();
	addLabels();
	jf.setVisible( true );

    }

    public void setUpFrame()
    {
	jf = new JFrame( "Game Over" );

        jf.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        jf.setSize( Screen.w, Screen.h );
    }

    public void addLabels()
    {
	jp = new JPanel();
	jp.setLayout( new GridLayout(5,3,0,10) );

	JLabel label = new JLabel( name + " wins!", JLabel.CENTER );
	JLabel label2 = new JLabel( "Enter your name!", JLabel.CENTER );
        text = new JTextField( "" );
        JButton button = new JButton( "Enter" );


	jp.add( new JLabel("") );
	jp.add( label );
	jp.add( new JLabel("") );	
	jp.add( new JLabel("") );
	
	jp.add( label2 );	
	jp.add( new JLabel("") ); // set empty labels to fill grid layout
	jp.add( new JLabel("") );
        
	jp.add( text );
	jp.add( new JLabel("") );
	jp.add( new JLabel("") );
        
	jp.add( button );
	button.addActionListener( new ButtonListener() );
	jp.add( new JLabel("") );	
	jp.add( new JLabel("") );	
	jp.add( new JLabel("") );	
	jp.add( new JLabel("") );       
	
	jf.add( jp );
    }

    class ButtonListener implements ActionListener{
	public void actionPerformed( ActionEvent ae )
	{
	    DisplayHighScores dhs = new DisplayHighScores( text.getText(), score );
	    jf.dispose();
	}
    }
    
}

