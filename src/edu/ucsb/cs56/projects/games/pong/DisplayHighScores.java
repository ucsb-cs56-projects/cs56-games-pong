package edu.ucsb.cs56.projects.games.pong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/** edu.ucsb.cs56.projects.games.pong.DisplayHighScores is the class that shows the high scorecs of previous players 
 @author Vincent Gandolfo, Krishna Lingampalli
 @version CS56, Winter 2015, UCSB
*/
public class DisplayHighScores{

    JFrame jf;
    JPanel jp;
    EndOfGame eog;
    
    /** Contructor that calls for the end of the game, then displays high scores
     * @param name name of the player who just won
     * @param score score of the player who just won
     */
    DisplayHighScores( String name, int score )
    {
	eog = new EndOfGame( score, name ); //Call EndOfGame()
	setUpFrame();
	setUpFrameComponents();
	showScores();
    }
    /**setUpFrame() sets up the frame structure for High Score Window */
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
    /**setUpFrameComponents() sets up the components for the JPanel */
    public void setUpFrameComponents()
    {
	JButton backToMain = new JButton( "Back To Main Menu" );
	backToMain.addActionListener( new BackToMainListener() );
	jf.add( backToMain, BorderLayout.SOUTH );

	JPanel jp = new JPanel();
	jf.add( jp );
    }

    /** showScores() prints scores on labels */
    public void showScores()
    {
	for( int i = 0; i < 5; i++ )
	    {
		jp.add( new JLabel( eog.hList.get( i ).toString( ": ", "" ), JLabel.CENTER ) );
	    }
    }
    /** BackToMainListener provides a way to get back to the main menu */
    class BackToMainListener implements ActionListener{
	public void actionPerformed(ActionEvent e){
	    jf.setVisible(false);
	}
    }

}
