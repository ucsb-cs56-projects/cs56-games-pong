package edu.ucsb.cs56.projects.games.pong.menu;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by angel on 2/20/16.
 */
public abstract class MenuTextComponent extends MainMenuComponent implements MouseListener {

    private final int fontHeight;
    private final String title;
    protected Color textColor = Color.WHITE;
    private Color backgroundColor;
    protected boolean screenCalled;

    public MenuTextComponent(String title, Color backgroundColor) {
        super();
        fontHeight = 28;
        this.title = title;
        this.screenCalled = false;
        this.setPreferredSize(new Dimension(super.getWidth(),super.getHeight()));
        this.backgroundColor = backgroundColor;

    }

    public String getTitle() {
        return title;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(textColor);
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, fontHeight));
        g.drawString(title,0,fontHeight);
    }

    // Default MouseEvents for our MouseListener
    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        textColor = Color.BLUE;
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        textColor = Color.WHITE;
        repaint();
    }

}
