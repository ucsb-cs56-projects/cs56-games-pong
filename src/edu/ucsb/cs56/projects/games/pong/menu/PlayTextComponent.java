package edu.ucsb.cs56.projects.games.pong.menu;

import edu.ucsb.cs56.projects.games.pong.gameplay.DifficultyLevel;
import edu.ucsb.cs56.projects.games.pong.gameplay.Screen;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

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
    public static int newwidth;//
    public static int newheight;//
    public static int screenfactor;
    public static int difficulty;
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
		newwidth=d.getNewWidth();
		//System.out.println("newwidth in play text is " + newwidth);
		newheight=d.getNewHeight();
		//System.out.println("newheight in play text is " + newheight);
		screenfactor=d.getScreenFactor();
		//System.out.println("newheight in play text is " + screenfactor);
		difficulty=d.getDifficulty();
		//System.out.println("difficulty in play text is " + screenfactor);
                screen = new Screen(8* prompt.getDifficulty(), 6 * prompt.getDifficulty());
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
        try {
            // Audio credit goes to Runner Pack via: http://freesound.org/people/RunnerPack/sounds/87035/
            InputStream ioR = new FileInputStream("src/edu/ucsb/cs56/projects/games/pong/menu/87035__runnerpack__menusel.wav");
            AudioStream audio = new AudioStream(ioR);
            this.setAudio(audio);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        AudioPlayer.player.start(audio);
    }

}
