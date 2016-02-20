package edu.ucsb.cs56.projects.games.pong;

import javax.swing.*;

/**
 * Created by angel on 2/20/16.
 */
public abstract class MainMenuUIItem extends JComponent {
    private final String title;

    public MainMenuUIItem(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
}
