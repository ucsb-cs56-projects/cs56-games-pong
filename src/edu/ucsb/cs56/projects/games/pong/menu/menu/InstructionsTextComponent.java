package edu.ucsb.cs56.projects.games.pong.menu;

import edu.ucsb.cs56.projects.games.pong.menu.instructions.Instructions;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by angelortega on 2/22/16.
 */
public class InstructionsTextComponent extends MenuTextComponent {
    private Instructions instructions;
    public InstructionsTextComponent(String title, Color backgroundColor) {
        super(title, backgroundColor);
    }

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

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }



    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        super.mouseExited(mouseEvent); // change selection color

    }
}
