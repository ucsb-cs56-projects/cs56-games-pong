package edu.ucsb.cs56.projects.games.pong;

import edu.ucsb.cs56.projects.games.pong.menu.MainMenuUI;

import javax.swing.*;
import java.awt.*;

/** edu.ucsb.cs56.projects.games.pong.Game
 * Game contains the launcher(main).
 * It provides the frame/window details for the Game.
 * 
 * @author Angel Ortega
 * @version CS56, Winter 2016, UCSB
 */
public class Game extends JFrame {
    private static final Dimension DIMENSION = new Dimension(640,480);


    public Game(String title, Dimension dimension) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(dimension);
        this.setLocationRelativeTo( null );
        this.setBackground(Color.BLACK);
    }

    public static void main(String[] args) {
        Game window = new Game("Main Menu",DIMENSION);
        MainMenuUI game = new MainMenuUI();
        window.add(game);
        window.setVisible(true);
    }
}
