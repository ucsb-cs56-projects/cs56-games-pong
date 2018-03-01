package edu.ucsb.cs56.projects.games.pong;

import edu.ucsb.cs56.projects.games.pong.menu.MainMenuUI;

import javax.swing.*;
import java.awt.*;

/** edu.ucsb.cs56.projects.games.pong.Game
 * Game contains the launcher(main).
 * It provides the frame/window details for the Game.
 * 
 * @author Angel Ortega
 * @author Victoria Sneddon, Andrew Polk
 * @version CS56, Fall 2017, UCSB
 */
public class Game extends JFrame {

    /** sets dimension */
    private static final Dimension DIMENSION = new Dimension(640,480);

    /** Holds the main game JFrame */
    private static Game window;
    
    /** constructor for Game; takes in a title and dimension 
     * @param title The title for the JFrame
     * @param dimension Dimensions for the window
     */
    public Game(String title, Dimension dimension) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(dimension);
        this.setLocationRelativeTo( null );
        this.setBackground(Color.BLACK);
    }
    
    /** main, entry point for game 
     * @param args not used
     */
    public static void main(String[] args) {
        Game windowNew = new Game("Main Menu",getDIMENSION());
        setWindow(windowNew);
        MainMenuUI game = new MainMenuUI();
        window.add(game);
	//Opens the window with a static function that can be called from anywhere
	setWindowVisibility(true);
    }

    public static void setWindowVisibility(boolean visibility){
	window.setVisible(visibility);
    }
    
    /** setters and getters
     */
    public static Dimension getDIMENSION() {
        return DIMENSION;
    }

    public static Game getWindow() {
        return window;
    }

    public static void setWindow(Game window) {
        Game.window = window;
    }
}
