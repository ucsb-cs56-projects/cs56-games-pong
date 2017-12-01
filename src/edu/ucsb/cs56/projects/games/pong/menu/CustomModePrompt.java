package edu.ucsb.cs56.projects.games.pong.menu;

import javax.swing.*;
import java.util.LinkedHashMap;
import java.util.Map;

/** edu.ucsb.cs56.projects.game.pong.menu allows user to select custom game mode */
/**
 * @author Andrew Polk, Victoria Sneddon
 * @version CS56, Fall 2017, UCSB
 */
public class CustomModePrompt extends JPanel {

    /** holds value associated with certian difficulty level */
    private int difficulty;

    /** holds value associated with number of balls */
    private int ballNum;

    /** boolean value called selected noting if difficulty level is chosen */
    private boolean selected;

    /** LinkedHasMap of difficulty levels */
    private static final Map<String,Integer> DIFFICULTIES =  new LinkedHashMap<String,Integer>(){{
	    put("Super-Easy",80);
	    put("Easy",100);
	    put("Medium",120);
	    put("Hard",130);
	    put("Extreme",140);
	    put("Chaos",170); 
	}};

    /** array of availible ball numbers*/
    private static final String[] BALL_NUMBERS = new String[]
	{ "1", "2", "3", "4", "5"};

    /**Map that returns difficulties
     * @return Map
     */
    public Map<String, Integer> getHashmap(){
	return DIFFICULTIES;}

    /**prompt user sees to select custom mode */
    public CustomModePrompt() {
	/*ComboBox for selections */
	JComboBox diffSelections = new JComboBox(DIFFICULTIES.keySet().toArray());
	JComboBox ballSelections = new JComboBox(BALL_NUMBERS);
	this.add(diffSelections);
	this.add(ballSelections);

	/*Show OptionPane and save responses to ints*/
	int responseFromUser = JOptionPane.showConfirmDialog(null,this,
							     "Select you custom settings:",
							     JOptionPane.OK_CANCEL_OPTION,
							     JOptionPane.OK_OPTION);

	/*Save chosen items to objects */
	Object diffChosen = diffSelections.getSelectedItem();
	Object ballChosen = ballSelections.getSelectedItem();

	if(responseFromUser == JOptionPane.OK_OPTION && diffChosen != null && ballChosen != null){
	    difficulty = DIFFICULTIES.get(diffChosen.toString()).intValue();
	    ballNum = Integer.parseInt(ballChosen.toString());
	    this.selected = true;
	} else {
	    this.remove(this);
	}
    }

    /**isSelected() returns if items have been selected
     * @return boolean isSelected
     */
    public boolean isSelected() { return selected; }

    /**getDifficulty() returns difficulty
     * @return int getDifficulty
     */
    public int getDifficulty() {
	return difficulty;
    }

    /**getBallNum() returns ball number
     * @return int ball number
     */
    public int getBallNum() {
	return ballNum;
    }
}
