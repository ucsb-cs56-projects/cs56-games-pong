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
        Game window = new Game("Main Menu",DIMENSION);
        MainMenuUI game = new MainMenuUI();
        window.add(game);
        window.setVisible(true);
    }
}
