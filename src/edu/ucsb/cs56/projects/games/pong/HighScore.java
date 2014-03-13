package edu.ucsb.cs56.projects.games.pong;

import java.awt.*;

public class HighScore{
    
    private final String playerName;
    private final int playerScore;

    HighScore( int score, String name )
	{
	    playerScore = score;
	    playerName = name;
	}

    public int getPlayerScore() { return playerScore; }

    public String getPlayerName() { return playerName; }
    
    public String toString( String first, String last )
    {
	return ( getPlayerScore() + first +  getPlayerName() + last );
    }
    
}
