package edu.ucsb.cs56.projects.games.pong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MainMenu {
    private int levelDifficulty;
    private int newWindowWidth;
    private int newWindowHeight;

    public JRadioButton easy;
    public JRadioButton medium;
    public JRadioButton hard;

    Instructions i;

    public MainMenu() {
	
       	JFrame frame = new JFrame( "Main Menu" );
	JPanel panel = new JPanel();
	JButton instructions = new JButton( "Instructions" );
	JButton play = new JButton( "Play" );

	frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	frame.add( panel );
	
	panel.setLayout( new BoxLayout( panel, BoxLayout.Y_AXIS ) );

	instructions.setAlignmentX(JFrame.CENTER_ALIGNMENT );
	
	play.setAlignmentX(JFrame.CENTER_ALIGNMENT );
	
	panel.add( instructions );
  
	JPanel ButtonPanel = new JPanel();

	ButtonGroup difficulty = new ButtonGroup();
	easy = new JRadioButton( "Easy" );
	medium = new JRadioButton( "Medium" );
	hard = new JRadioButton( "Hard" );

	
	difficulty.add(easy);
	difficulty.add(medium);
	difficulty.add(hard);

	ButtonPanel.add(easy);
	ButtonPanel.add(medium);
	ButtonPanel.add(hard);

	panel.add(ButtonPanel);
	panel.add( play );
	frame.setSize( 640, 480 );
	frame.setLocationRelativeTo( null );
	frame.setVisible( true );

	play.addActionListener( new PlayListener());
	instructions.addActionListener( new InstructionsListener());

    }
    public int getLevelDifficulty()
    {
	if( easy.isSelected() )
	    levelDifficulty = 80;
	
	if( medium.isSelected() )
	    levelDifficulty = 100;
	
	if( hard.isSelected() )
	    levelDifficulty = 120;

	return levelDifficulty;
    }

    class PlayListener implements ActionListener
    {
	public void actionPerformed(ActionEvent e)
	{
	levelDifficulty = getLevelDifficulty();
	newWindowWidth = 8 * levelDifficulty;
	newWindowHeight = 6 * levelDifficulty;
	//Screen s = new Screen();
	
	System.out.println( newWindowWidth + ", " + newWindowHeight );
	}
    }
    
    class InstructionsListener implements ActionListener
    {
	public void actionPerformed(ActionEvent e){
	    if( i == null )
		i = new Instructions();
	    else
		i.setToVisible();
	}

    }

    public static void main (String[] args) {

	MainMenu m = new MainMenu();
    }

}
