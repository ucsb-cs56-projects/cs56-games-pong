package edu.ucsb.cs56.projects.games.pong.menu;

import edu.ucsb.cs56.projects.games.pong.menu.instructions.Instructions;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * @author angelortega on 2/22/16.
 * @author Victoria Sneddon, Andrew Polk
 * @version Fall 2017
 */
public class InstructionsTextComponent extends MenuTextComponent {
    
    /**Instructions type instructions*/
    private Instructions instructions;
    
    /**
     * creates a Text Component to the MenuTextComponent
     * @param title of type String
     * @param backgroundColor paramater for InstructionsTextComponent
     */
    public InstructionsTextComponent(String title, Color backgroundColor) {
        super(title, backgroundColor);
    }

    /**plays audio, creates new instructions and makes visible
     * @param mouseEvent checks if mouse is clicked
     */
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if(textColor.equals(Color.BLUE)) {
            playGameStartAudio();
            if( instructions == null )
                instructions = new Instructions();
            else
                instructions.setToVisible();
        }
    }

    /**Overriden mousePressed no body
     * @param mouseEvent checks if mousePressed
     */
    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    /**
     * Overridden mouseReleased has no body code
     * @param mouseEvent checks if mouseReleased
     */
    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }


    /**
     *Overridden mouseExited changes selection color
     *@param mouseEvent checks if mouseExited
     */
    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        super.mouseExited(mouseEvent); // change selection color

    }
}
