package edu.ucsb.cs56.projects.games.pong;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by angelortega on 2/22/16.
 */
public class PlayTextComponent extends MenuTextComponent  {
    private Screen screen;
    public PlayTextComponent(String title, Color backgroundColor) {
        super(title, backgroundColor);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if(textColor.equals(Color.BLUE) && screen == null) {
            screen = new Screen(MainMenuComponent.getDimension().width,MainMenuComponent.getDimension().height);
        }
        else if(textColor.equals(Color.BLUE) && screen != null) {
            screen.jf.setSize(MainMenuComponent.getDimension().width,MainMenuComponent.getDimension().height);
            screen.jf.setVisible(true);
        }
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }
}
