package edu.ucsb.cs56.projects.games.pong.menu;

import edu.ucsb.cs56.projects.games.pong.gameplay.DifficultyLevel;
import edu.ucsb.cs56.projects.games.pong.gameplay.Screen;
import edu.ucsb.cs56.projects.games.pong.sound.SoundEffect;

import javax.sound.sampled.*; 
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by angelortega on 2/22/16.
 */
public class PlayTextComponent extends MenuTextComponent  {
    private Screen screen;
    public static int difficulty;
    protected SoundEffect audio = new SoundEffect("87035__runnerpack__menusel.wav");
    public PlayTextComponent(String title, Color backgroundColor) {
        super(title, backgroundColor);
    }
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if(textColor.equals(Color.BLUE)) {
            playGameStartAudio();
            DifficultyLevelPrompt prompt = new DifficultyLevelPrompt();
            if(prompt.isSelected()) {
                playGameStartAudio();
		DifficultyLevel d=new DifficultyLevel(prompt.getDifficulty());
		difficulty=d.getDifficulty();
                screen = new Screen(8 * prompt.getDifficulty(), 6 * prompt.getDifficulty());
	    }
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
    
    @Override
    protected void playGameStartAudio() {
    // Audio credit goes to Runner Pack via: http://freesound.org/people/RunnerPack/sounds/87035/
	audio.playClip();
    }
   public static int getDifficulty() 
   {
	return difficulty;
   }
}
