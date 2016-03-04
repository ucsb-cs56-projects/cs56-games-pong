package edu.ucsb.cs56.projects.games.pong.menu;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by angel on 2/20/16.
 */
public abstract class MenuTextComponent extends MainMenuComponent implements MouseListener {

    private final int fontHeight;
    private final String title;
    protected Color textColor = Color.WHITE;
    private Color backgroundColor;
    protected boolean screenCalled;
    protected AudioStream audio;

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

    protected void playGameStartAudio() {
        try {
            // Audio credit goes to Cabeeno Rossley via: https://www.freesound.org/people/Cabeeno%20Rossley/sounds/126418/
            InputStream ioR = new FileInputStream("src/edu/ucsb/cs56/projects/games/pong/menu/126418__cabeeno-rossley__button-select.wav");
            AudioStream audio = new AudioStream(ioR);
            this.setAudio(audio);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        AudioPlayer.player.start(audio);
    }


    public void setAudio(AudioStream audio) {
        this.audio = audio;
    }
}
