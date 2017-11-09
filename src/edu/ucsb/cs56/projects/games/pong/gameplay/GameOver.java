package edu.ucsb.cs56.projects.games.pong.gameplay;

import edu.ucsb.cs56.projects.games.pong.highscore.DisplayHighScores;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/** edu.ucsb.cs56.projects.games.pong.gameplay.GameOver is the class that gives instructions on what to do when the game ends
 * @author Vincent Gandolfo, Krishna Lingampalli
 * @version CS56, Winter 2015, UCSB
 */

public class GameOver{
    /**Holds the JFrame object*/ 
    JFrame jf;

    /**Hold JPanel for the JFrame*/
    JPanel jp;

    /** Holds the name of the high score player*/
    String name;

    /**Holds the score for the previous game*/
    int score;

    /**Holds the textField object*/
    JTextField text;

    /** Constructor that initializes the winner's name and the number of points the winner got and sends it to the high score list. It also sets up a frame with labels.
     * @param winner the name of the winner of the game
     * @param points the number of points the winner scored
     */ 
    public GameOver( String winner, int points )
    {
	name = winner;
	score = points;
	setUpFrame();
	addLabels();
	jf.setVisible( true );
    }
    
    /** setUpFrame() sets up a frame structure for Game Over Screen*/
    public void setUpFrame()
    {
	jf = new JFrame( "Game Over" );

        jf.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        jf.setSize( Screen.w, Screen.h );
	jf.setLocationRelativeTo( null );
	jf.setResizable( false );
    }

    /** addLabels() adds labels for entering winner name*/
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
    
    /** Button Listener for "Enter" that will trigger  Display High Scores */
    class ButtonListener implements ActionListener{
	/**Action Performed Method for ButtonListener
	 * @param ae Action Event from button
	 */
	public void actionPerformed( ActionEvent ae )
	{
	    DisplayHighScores dhs = new DisplayHighScores( text.getText(), score );
	    jf.dispose();
	}
    }
    
}

