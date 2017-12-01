package edu.ucsb.cs56.projects.games.pong.menu;

import javax.swing.*;
import java.util.LinkedHashMap;
import java.util.Map;

/** edu.ucsb.cs56.projects.game.pong.menu allows user to select difficulty level*/
/**
 *  @author angelortega on 2/22/16.
 * @author Victoria Sneddon, Andrew Polk 
 * @version CS56, Fall 2017, UCSB
*/ 

public class DifficultyLevelPrompt extends JPanel {

    /** holds vaule associated with certain difficulty level */
    private int difficulty;

    /** boolean value called selected noting if difficulty level is chosen */
    private boolean selected;

    /**LinkedHashMap of  dificulty levels */
    private static final Map<String,Integer> DIFFICULTIES =  new LinkedHashMap<String,Integer>(){{
	    put("Super-Easy",80);
	    put("Easy",100);
	    put("Medium",120);
	    put("Hard",130);
	    put("Extreme",140);
	    put("Chaos",170);
	    put("Custom Mode",90); 
	}};
    
    /**Map that returns difficulties 
     * @return Map
     */
    public Map<String, Integer> getHashmap(){
	return DIFFICULTIES;}
    
    /**prompt user sees to select difficulty  */
    public DifficultyLevelPrompt() {
	/*ComboBox for selections */
        JComboBox selections = new JComboBox(DIFFICULTIES.keySet().toArray());
        this.add(selections);

	/*Show OptionPane and save response to int */
        int responseFromUser = JOptionPane.showConfirmDialog(null,this,
							     "Select your difficulty:",
							     JOptionPane.OK_CANCEL_OPTION,
							     JOptionPane.OK_OPTION);

	/*Save chosen items to objects */
	Object itemChosen = selections.getSelectedItem();
	
	if (responseFromUser == JOptionPane.OK_OPTION && itemChosen != null) {
            difficulty = DIFFICULTIES.get(itemChosen.toString()).intValue();
            this.selected = true;
        } else {
            this.remove(this);
        }
    }

    /**isSelected() returns if items have been selected
     * @return boolean isSelected
     */
    public boolean isSelected() {
        return selected;
    }

    /**getDifficulty() returns difficulty
     * @return int getDifficulty
     */
    public int getDifficulty() {
        return difficulty;
    }
}
