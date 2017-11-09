package edu.ucsb.cs56.projects.games.pong.menu;

import edu.ucsb.cs56.projects.games.pong.highscore.DisplayHighScores;

import java.awt.*;
import java.awt.event.MouseEvent;

/** edu.ucsb.cs56.projects.games.pong.menu.HighSchoreTextComponent is the class that will show the high scores won on pong 
 * @author angelortega on 2/22/16.
 * @author Victoria Sneddon, Andrew Polk
 * @version CS56, Fall 2017, UCSB
 */
public class HighScoreTextComponent extends MenuTextComponent {

    /**
       calls constructor of superclass MenuTextComponent
     * @param String title
     * @param Color backgroundColor
    */
    public HighScoreTextComponent(String title, Color backgroundColor) {
        super(title, backgroundColor);
    }

    @Override
    /**
     * plays audio, if text color is blue, creates new DisplayHighScores called displayhs
     * @param MouseEvent mouseEvent
     */
    public void mouseClicked(MouseEvent mouseEvent) {
        playGameStartAudio();
        if(textColor.equals(Color.BLUE)) {
            DisplayHighScores displayhs = new DisplayHighScores("", 0);
        }
    }


    /**Overriden mousePressed has no body code
     * @param MouseEvent mouseEvent*/
    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }
    
    /**
     * Overriden mouseReleased has no body code
     * @param MouseEvent mouseEvent
     */
    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }
}
