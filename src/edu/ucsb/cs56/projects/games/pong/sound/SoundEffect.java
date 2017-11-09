package edu.ucsb.cs56.projects.games.pong.sound;


import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.*;
import java.net.MalformedURLException;

/**edu.ucsb.cs56.projects.games.pong.sound.SoundEffect is a class that opens and plays audio clips
 * 
 * @author Alexander Ngo and Millan Batra
 * @author Andrew Polk and Victoria Sneddon
 * @version cs56 Fall 2016
 */

public class SoundEffect 
{
    /**The url of the sound clip that is going to be saved*/
    URL url;
    /**The sound clip that is saved in the object*/
    Clip clip;

    /**Creates a url to the sound file and opens the sound file
     * @param sound takes in a string for the sound file
     */
    //Constructor
    //Creates and saves a sound effect
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

    /**Plays the audio clip stored and restarts the clip if it is playing*/
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
