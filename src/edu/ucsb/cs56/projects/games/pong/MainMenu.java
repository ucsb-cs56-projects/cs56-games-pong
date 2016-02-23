package edu.ucsb.cs56.projects.games.pong;

import edu.ucsb.cs56.projects.games.pong.gameplay.Screen;
import edu.ucsb.cs56.projects.games.pong.highscore.DisplayHighScores;
import edu.ucsb.cs56.projects.games.pong.menu.*;
import edu.ucsb.cs56.projects.games.pong.menu.instructions.Instructions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/** edu.ucsb.cs56.projects.games.pong.MainMenu is the class for Main Menu selection. It brings up the main menu and has buttons that allow the user to play the game, read the instructions, or view the high scores
 @author Vincent Gandolfo, Krishna Lingampalli
 @version CS56, Winter 2015, UCSB
*/ 
public class MainMenu {
    private int levelDifficulty;
    private int newWindowWidth;
    private int newWindowHeight;

    public JRadioButton easy;
    public JRadioButton medium;
    public JRadioButton hard;
    public JRadioButton ExtremeType1; 
    public JRadioButton supereasy;
    public static JRadioButton ExtremeType2;
    protected JFrame frame;
    protected JPanel panel;
    protected static final int WIDTH = 640;
    protected static final int HEIGHT = 480;
    static Screen screen;

    private GridLayout gridLayout = new GridLayout(5,1);

    Instructions i;
    Screen s;
    /** Constructor for MainMenu that creates the whole menu. A JFrame is created, and buttons are available for the options, which include view instructions, view high scores, and pick a difficulty
     */

    public MainMenu() {
        frame = new JFrame( "Main Menu" );
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        frame.setSize( WIDTH, HEIGHT );
        frame.setLocationRelativeTo( null );
        ArrayList<MenuTextComponent> menuItems = new ArrayList<MenuTextComponent>();
        MenuTextComponent menuTextComponent1 = new InstructionsTextComponent("Instructions",Color.BLACK);
        MenuTextComponent menuTextComponent2 = new PlayTextComponent("Play",Color.BLACK);
        MenuTextComponent menuTextComponent3 = new HighScoreTextComponent("High Scores",Color.BLACK);
        menuTextComponent1.addMouseListener(menuTextComponent1); // make a handler
        menuTextComponent2.addMouseListener(menuTextComponent2);
        menuTextComponent3.addMouseListener(menuTextComponent3);

        menuItems.add(menuTextComponent1);
        menuItems.add(menuTextComponent2);
        menuItems.add(menuTextComponent3);

        panel.setSize(WIDTH, HEIGHT);
//        panel.setBackground(Color.BLACK);
//        panel.setOpaque(true);
        frame.setBackground(Color.BLACK);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        MenuPaddingComponent menuList = new MenuPaddingComponent(Color.BLACK,HEIGHT,WIDTH/2);
        panel.add(new MenuPaddingComponent(Color.BLACK,HEIGHT,WIDTH/4),BoxLayout.X_AXIS);
        panel.add(menuList,BoxLayout.X_AXIS);

        panel.add(new MenuPaddingComponent(Color.BLACK,HEIGHT,WIDTH/4),BoxLayout.X_AXIS);
        menuList.setLayout(gridLayout);

        menuList.add(new MenuPaddingComponent(Color.BLACK,HEIGHT,WIDTH));
        for(MenuTextComponent component: menuItems) {
            menuList.add(component.getTitle(), component);

        }
        menuList.add(new MenuPaddingComponent(Color.BLACK,HEIGHT,WIDTH));
        frame.add(panel);
        frame.setVisible(true);



    }


//    public MainMenu() {
//
//		// Construct Window

//       	JFrame frame = new JFrame( "Main Menu" );
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		JPanel panel = new JPanel();
//        panel.setSize(640, 480);
//        panel.setBackground(Color.BLACK);
//        panel.setOpaque(true);
//        panel.setVisible(true);
//        MenuTextComponent component = new MenuTextComponent("Instructions",Color.BLACK);
//        panel.add(component);
//        frame.setSize( 640, 480 );
//        frame.setLocationRelativeTo( null );
//        frame.add(panel);
//
////        frame.setBackground(Color.BLACK);
//        frame.setVisible(true);

//		JButton instructions = new JButton( "Instructions" );
//		JButton play = new JButton( "Play" );
//		JButton highScores = new JButton( "High Scores" );
//
//		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
//		frame.add( panel );
//
//		panel.setLayout( new BoxLayout( panel, BoxLayout.Y_AXIS ) );
//
//		instructions.setAlignmentX( JFrame.CENTER_ALIGNMENT );
//		highScores.setAlignmentX( JFrame.CENTER_ALIGNMENT );
//		play.setAlignmentX( JFrame.CENTER_ALIGNMENT );
//
//		panel.add( instructions );
//		panel.add( highScores );
//
//		JPanel ButtonPanel = new JPanel();
//
//		ButtonGroup difficulty = new ButtonGroup();
//		supereasy = new JRadioButton( "SUPEREASY" );
//		easy = new JRadioButton( "Easy" );
//		medium = new JRadioButton( "Medium" );
//		hard = new JRadioButton( "Hard" );
//		ExtremeType1 = new JRadioButton( "ExtremeType1" );
//		ExtremeType2 = new JRadioButton( "ExtremeType2" );
//
//
//		difficulty.add(supereasy);
//		difficulty.add(easy);
//		difficulty.add(medium);
//		difficulty.add(hard);
//		difficulty.add(ExtremeType1);
//		difficulty.add(ExtremeType2);
//
//
//
//
//		easy.setSelected(true);
//		ButtonPanel.add(supereasy);
//		ButtonPanel.add(easy);
//		ButtonPanel.add(medium);
//		ButtonPanel.add(hard);
//		ButtonPanel.add(ExtremeType1);
//		ButtonPanel.add(ExtremeType2);
//
//
//
//
//		panel.add(ButtonPanel);
//		panel.add( play );
//		frame.setSize( 640, 480 );
//		frame.setLocationRelativeTo( null );
//		frame.setVisible( true );
//		frame.setResizable( false );
//
//		//Button Listener for Play Button
//		play.addActionListener( new PlayListener());
//		instructions.addActionListener( new InstructionsListener());
//		highScores.addActionListener( new HighScoresListener() );
//
//    }
    /** getLevelDifficulty() sets level difficulty based on user input */
    public int getLevelDifficulty()
    {
//	if( easy.isSelected() )
//	    levelDifficulty = 100;
//
//	if( medium.isSelected() )
//	    levelDifficulty = 120;
//
//	if( hard.isSelected() )
//	    levelDifficulty = 140;
//
//	if( ExtremeType1.isSelected() )
//            levelDifficulty = 170;
//
//	if( supereasy.isSelected() )
//            levelDifficulty = 80;
//  	if( ExtremeType2.isSelected() )
//            levelDifficulty = 120;

	return 120;
    }
  
    /** PlayListener sets new window parameters based on level difficulty */
    class PlayListener implements ActionListener
    {
	public void actionPerformed(ActionEvent e)
	{
	    levelDifficulty = getLevelDifficulty();
	    newWindowWidth = 8 * levelDifficulty;
	    newWindowHeight = 6 * levelDifficulty;
	    s = new Screen( newWindowWidth, newWindowHeight );
	}
    }
    /** InstructionsListener is a Button Listener for instructions button */
    class InstructionsListener implements ActionListener
    {
	public void actionPerformed(ActionEvent e){
	    if( i == null )
		i = new Instructions();
	    else
		i.setToVisible();
	}

    }
    
    /** HighScoresListener is a Button Listener for high scores button */
    class HighScoresListener implements ActionListener{
	public void actionPerformed(ActionEvent e){
	    DisplayHighScores displayhs = new DisplayHighScores( "", 0 );
	}
    }
    
    public static void main (String[] args) {

	MainMenu m = new MainMenu();
    }

}
