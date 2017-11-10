package edu.ucsb.cs56.projects.games.pong.highscore;

/** edu.ucsb.cs56.projects.games.pong.HighScore is the class that turns the winner's name and score into a string
 @author Vincent Gandolfo, Krishna Lingampalli
 @version CS56, Winter 2015, UCSB
*/
public class HighScore implements Comparable {

    /**Name of player*/
    private final String playerName;

    /**Score of player*/
    private final int playerScore;

    /** Constructor that sets the instance variables playerName and playerScore      *  to the arguments name and score 
     * @param score the score of the player won just won
     * @param name the name of the player who just won
     */
    public HighScore(int score, String name)
	{
	    playerScore = score;
	    playerName = name;
	}
    /** getPlayerScore() returns the score of the player who won 
     * @return int player score
     */    
    public int getPlayerScore()   { return playerScore; }

    /** getPlayerName() returns the name of the player who just won 
     * @return String player name
     */
    public String getPlayerName() { return playerName; }

    /** toString() returns a combination of the player's score and name in a single string 
     * @param first first
     * @param last last
     * @return String toString method
     */
    public String toString( String first, String last ) {
	return ( getPlayerScore() + first +  getPlayerName() + last );
    }

    /***
     * Highest playerScore is given priority.
     * @param o object
     * @return int compared
     */
    @Override
    public int compareTo(Object o) {
        HighScore otherScore = (HighScore) o;
        if(this.playerScore < otherScore.playerScore)
            return 1;
        else if(this.playerScore == otherScore.playerScore)
            return 0;
        else
            return -1;
    }
}
