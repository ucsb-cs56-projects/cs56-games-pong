package edu.ucsb.cs56.projects.games.pong.menu;

import edu.ucsb.cs56.projects.games.pong.sound.SoundEffect;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author angel on 2/20/16.
 * @author Victoria Sneddon, Andrew Polk
 * @version Fall 2017
*/

public abstract class MenuTextComponent extends MainMenuComponent implements MouseListener {
    
    /**int variable to store font height*/
    private final int fontHeight;
    
    /**String variable to store title*/
    private final String title;

    /**sets color of text to white*/
    protected Color textColor = Color.WHITE;

    /**Color variable for backgroundColor*/
    private Color backgroundColor;

    /**boolean varable to see if screen is called*/
    protected boolean screenCalled;

    /**sets audio to sound effect*/
    protected SoundEffect audio = new SoundEffect("126418__cabeeno-rossley__button-select.wav");

    /**
     * MenuTextComponent constructor to initialize values
     * @param title holds String of title
     * @param backgroundColor for background color
     */
    public MenuTextComponent(String title, Color backgroundColor) {

        super();
        fontHeight = 28;
        this.title = title;
        this.screenCalled = false;
        this.setPreferredSize(new Dimension(super.getWidth(),super.getHeight()));
        this.backgroundColor = backgroundColor;

    }

    /**getter for title
     * @return String title getter for title
     */
    public String getTitle() {
        return title;
    }

    /**
     *paintComponent that creates graphic and initialzes values
     * @param g for Graphics
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(textColor);
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, fontHeight));
        g.drawString(title,0,fontHeight);
    }

    /** Default MouseEvents for our MouseListener
     * @param mouseEvent MouseEvent for Listener
     */
    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        textColor = Color.BLUE;
        repaint();
    }

    /**
     * @param mouseEvent MouseEvent
     * if mouse clicks exit, text color goes to white and screen is repainted
     */
    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        textColor = Color.WHITE;
        repaint();
    }

    /**plays audio clip*/
    protected void playGameStartAudio() {
            // Audio credit goes to Cabeeno Rossley via: https://www.freesound.org/people/Cabeeno%20Rossley/sounds/126418/
	audio.playClip();
    }

}
