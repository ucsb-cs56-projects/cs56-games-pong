package edu.ucsb.cs56.projects.games.pong.gameplay;

import edu.ucsb.cs56.projects.games.pong.menu.MainMenuUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by angel on 2/21/16.
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
