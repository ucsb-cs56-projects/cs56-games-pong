package edu.ucsb.cs56.projects.games.pong;

import javax.swing.*;
import java.awt.*;

/**
 * Created by angel on 2/21/16.
 */
public class GameWindow extends JFrame {
    private static final Dimension DIMENSION = new Dimension(640,480);


    public GameWindow(String title, Dimension dimension) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(dimension);
        this.setLocationRelativeTo( null );
        this.setBackground(Color.BLACK);
    }

    public static void main(String[] args) {
        GameWindow window = new GameWindow("Main Menu",DIMENSION);
        MainMenuUI gameMenu = new MainMenuUI();
        window.add(gameMenu);
        window.setVisible(true);
    }
}
