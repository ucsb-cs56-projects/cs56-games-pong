package edu.ucsb.cs56.projects.games.pong.menu;

import edu.ucsb.cs56.projects.games.pong.gameplay.Screen;

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
            screen = new Screen(getDimension().width, getDimension().height);
        }
        else if(textColor.equals(Color.BLUE) && screen != null) {
            screen.jf.setSize(getDimension().width, getDimension().height);
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
