package edu.ucsb.cs56.projects.games.pong;

import javax.swing.JComponent;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by angel on 2/20/16.
 */
public class InstructionsComponent extends JComponent implements MouseListener {

    private boolean mouseEntered;
    private boolean mouseClicked;
    private boolean mousePrssed;
    private boolean mouseExited;
    private static final int FONT_HEIGHT = 28;
    public InstructionsComponent() {
        super();
        this.setPreferredSize(new Dimension(200,200));

//        this.repaint();
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.YELLOW);
        g.fillRect(0,0,600,480);
        g.setColor(Color.BLACK);
        g.setFont(new Font("sansserif", Font.BOLD, FONT_HEIGHT));
        g.drawString(this.getX()+" "+ this.getHeight()+ " " +this.getY() + "Instructions",0,FONT_HEIGHT);
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
