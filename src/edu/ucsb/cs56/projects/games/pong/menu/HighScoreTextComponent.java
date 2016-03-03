package edu.ucsb.cs56.projects.games.pong.menu;

import edu.ucsb.cs56.projects.games.pong.highscore.DisplayHighScores;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by angelortega on 2/22/16.
 */
public class HighScoreTextComponent extends MenuTextComponent {

    public HighScoreTextComponent(String title, Color backgroundColor) {
        super(title, backgroundColor);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        playGameStartAudio();
        if(textColor.equals(Color.BLUE)) {
            DisplayHighScores displayhs = new DisplayHighScores("", 0);
        }
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }
}
