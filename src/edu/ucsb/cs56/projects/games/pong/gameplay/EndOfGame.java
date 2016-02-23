package edu.ucsb.cs56.projects.games.pong.gameplay;

import edu.ucsb.cs56.projects.games.pong.highscore.HighScore;

import java.util.ArrayList;
import java.io.*;

/** edu.ucsb.cs56.projects.games.pong.gameplay.EndOfGame is the class that provides instructions for how to end the game and display high scores
 @author Vincent Gandolfo, Krishna Lingampalli
 @version CS56, Winter 2015, UCSB
*/

public class EndOfGame {
    //Create ArrayList to store high scores and names
    public ArrayList<HighScore> hList = new ArrayList<HighScore>();

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
    /** readTheFile() reads the High Scores file */
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
	    reader.close();
	}catch( IOException ioe ){
	    ioe.printStackTrace();
	}
    }
    /** checkArrayList() checks ArrayList to see if winner will be placed in top five */
    public void checkArrayList()
    {
	for( int i = 0; i < 5; i++ )
	    {
		if( isGreaterThan( i ) )
		    {
			hList.add( i, winner );
			hList.remove( 5 );
			return;
		    }
	    }
    }
    /** isGreaterThan() checks if winner score is higher than current ArrayList index */
    public boolean isGreaterThan( int i )
    {
	if( winner.getPlayerScore() > hList.get( i ).getPlayerScore() )
	    return true;
	return false;
    }
    /** putInArrayList() adds winner to ArrayList */
    public void putInArrayList( String[] parsedList )
    {
	HighScore hs;
	for( int i = 0; i < parsedList.length; i++ )
	    {
		hs = new HighScore( Integer.parseInt( parsedList[i ] ),
				    parsedList[ i] );
		hList.add( hs );
	    }
    }
    /** saveToFile() saves new file */
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


		writer.flush();
	    writer.close();
	}catch( IOException ioe ){
	    ioe.printStackTrace();
	}
    }

}
