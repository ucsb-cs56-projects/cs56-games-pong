package edu.ucsb.cs56.projects.games.pong;

import java.awt.*;

/** edu.ucsb.cs56.projects.games.pong.HighScore is the class that turns the winner's name and score into a string
 @author Vincent Gandolfo, Krishna Lingampalli
 @version CS56, Winter 2015, UCSB
*/

public class HighScore{
    
    private final String playerName;
    private final int playerScore;

    /** Constructor that sets the instance variables playerName and playerScore      *  to the arguments name and score 
     * @param score the score of the player won just won
     * @param name the name of the player who just won
     */   
HighScore( int score, String name )
	{
	    playerScore = score;
	    playerName = name;
	}
    /** getPlayerScore() returns the score of the player who won */
    
    public int getPlayerScore()   { return playerScore; }
    /** getPlayerName() returns the name of the player who just won */
    public String getPlayerName() { return playerName; }
    /** toString() returns a combination of the player's score and name in a single string */
    public String toString( String first, String last )
    {
	return ( getPlayerScore() + first +  getPlayerName() + last );
    }
    
}
