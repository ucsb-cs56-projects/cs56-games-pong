package edu.ucsb.cs56.projects.games.pong;

import java.awt.*;

/**
 * Created by angel on 2/20/16.
 */
public class MenuPaddingComponent extends MainMenuComponent {
    private final String title;
    private int height;
    private int width;
    private Color backgroundColor;
    public MenuPaddingComponent(Color backgroundColor,int height, int width) {
        super();
        this.title = "MenuPadding";
        this.height = height;
        this.width = width;
        this.backgroundColor = backgroundColor;
        this.setPreferredSize(new Dimension(height,width));
    }

    public String getTitle() {
        return title;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(backgroundColor);
        g.fillRect(0,0,width,height);
    }

}
