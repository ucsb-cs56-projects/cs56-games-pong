package edu.ucsb.cs56.projects.games.pong.gameplay;

import edu.ucsb.cs56.projects.games.pong.highscore.HighScore;

import java.util.ArrayList;
import java.io.*;
import java.util.Collections;

/** edu.ucsb.cs56.projects.games.pong.gameplay.EndOfGame
 *
 * EndOfGame provides details for reading and writing the current list of PlayerScores
 * If a new Highscore is encountered, it will write this to the CSV file of highscores.
 *
 * @author Vincent Gandolfo, Krishna Lingampalli
 * @author Angel Ortega
 * @author Victoria Sneddon, Andrew Polk
 * @version CS56, Fall 2017, UCSB
*/

public class EndOfGame {
    /**Create ArrayList to store high scores and names */
    public ArrayList<HighScore> hList = new ArrayList<HighScore>();
    
    /** winner holds Highscore object */
    public HighScore winner;

    /** Constructor that identifies the winner, and writes and saves their name      *  and score to a file
     *  @param score score of the player who just won
     *  @param name name of the player who just won
     */  
    public EndOfGame( int score, String name )
    {
	winner = new HighScore( score, name );
	readTheFile();
	saveToFile();
    }

    /** readTheFile() reads the High Scores file*/
    public void readTheFile()
    {
	try{
	    File scoresFile = new File( "src/edu/ucsb/cs56/projects/games/pong/highscore/scores.csv" );
	    FileReader fileReader = new FileReader( scoresFile );
	    BufferedReader reader = new BufferedReader( fileReader );
	    String line;
	    while((line = reader.readLine()) != null) { //reads the file
		String[] users = line.split(",");
		if(users.length == 2)
		    hList.add(new HighScore(Integer.parseInt(users[0]),users[1]));
	    }
	    Collections.sort(hList);
	    
	    reader.close();
	}catch( IOException ioe ){
	    ioe.printStackTrace();
	}
    }

    /** saveToFile() saves new file*/
    public void saveToFile( )
    {
	try{
	    BufferedWriter writer = new BufferedWriter(new FileWriter( "src/edu/ucsb/cs56/projects/games/pong/highscore/scores.csv" ));
	    String playerScore = "";
	    String winnerScore = "";
	    for(HighScore highscore : hList )
		{
		    playerScore = highscore.getPlayerScore()+"," +highscore.getPlayerName();
		    writer.write(playerScore);
		    writer.newLine();
		}
	    if(winner != null) {
		winnerScore = winner.getPlayerScore()+"," +winner.getPlayerName();
		writer.write(winnerScore);
		writer.newLine();
		hList.add(winner);
	    }
	    
	    Collections.sort(hList);

	    writer.flush();
	    writer.close();
	}catch( IOException ioe ){
	    ioe.printStackTrace();
	}
    }
}
