package edu.ucsb.cs56.projects.games.pong;

import javax.swing.JComponent;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by angel on 2/20/16.
 */
public class InstructionsComponent extends MainMenuComponent implements MouseListener {

    private boolean mouseEntered;
    private boolean mouseClicked;
    private boolean mousePrssed;
    private boolean mouseExited;
    private final int fontHeight;
    private final String title;

    public InstructionsComponent() {
        super();
        this.setPreferredSize(new Dimension(200,200));
        title = "Instructions";
        fontHeight = 28;

    }

    public String getTitle() {
        return title;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.YELLOW);
        g.fillRect(0,0,600,480);
        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, fontHeight));
        g.drawString(title,0,fontHeight);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        mouseEntered = true;
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
