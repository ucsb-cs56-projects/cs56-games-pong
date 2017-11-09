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
     * @param title of type String
     * @param backgroundColor takes in set backgroundColor
    */
    public HighScoreTextComponent(String title, Color backgroundColor) {
        super(title, backgroundColor);
    }

    /**
     * plays audio, if text color is blue, creates new DisplayHighScores called displayhs
     * @param mouseEvent insert object of type MouseEvent into mouseClicked
     */
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        playGameStartAudio();
        if(textColor.equals(Color.BLUE)) {
            DisplayHighScores displayhs = new DisplayHighScores("", 0);
        }
    }


    /**Overriden mousePressed has no body code
     * @param mouseEvent parameter to mousePressed*/
    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }
    
    /**
     * Overriden mouseReleased has no body code
     * @param mouseEvent parameter for mouseReleased
     */
    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }
}
