package edu.ucsb.cs56.projects.games.pong.sound;


import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.*;
import java.net.MalformedURLException;
/**
 * 
 * @author Alexander Ngo and Millan Batra
 * @version cs56 Fall2016
 */

public class SoundEffect 
{
    URL url;
    Clip clip;

    /** @param takes in a string for the sound files name
	Creates a url to the sound file and opens the sound file
    */
    public SoundEffect(String sound)
    {   

	
		URL url = this.getClass().getResource(sound);
	

        try{
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            clip = AudioSystem.getClip();
            clip.open(audioIn);
        }
	catch(MalformedURLException e){
	    e.printStackTrace();
	}
	catch (IOException e) {
            e.printStackTrace();
        }
	catch(UnsupportedAudioFileException e){
	    e.printStackTrace();
	}
	catch(LineUnavailableException e){
	    e.printStackTrace();
	}
    }

    public void playClip()
    {
        if( clip.isRunning() )
        {
            clip.stop();
        }
        clip.setFramePosition( 0 );
        clip.start();
    }
}
