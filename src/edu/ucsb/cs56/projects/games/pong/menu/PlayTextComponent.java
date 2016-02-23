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
        if(textColor.equals(Color.BLUE)) {
            DifficultyLevelPrompt prompt = new DifficultyLevelPrompt();
            if(prompt.isSelected())
                screen = new Screen(8*prompt.getDifficulty(), 6*prompt.getDifficulty());
        }
//        else if(textColor.equals(Color.BLUE) && screen != null) {
//            DifficultyLevelPrompt prompt = new DifficultyLevelPrompt();
//            if(prompt.isSelected()) {
//                screen.jf.setSize(8*prompt.getDifficulty(), 6*prompt.getDifficulty());
//                screen.jf.setVisible(true);
//            }
//        }
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }
}
