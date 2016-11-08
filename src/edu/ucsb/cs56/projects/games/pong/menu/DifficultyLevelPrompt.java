package edu.ucsb.cs56.projects.games.pong.menu;

import javax.swing.*;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by angelortega on 2/22/16.
 */
public class DifficultyLevelPrompt extends JPanel {

    private int difficulty;
    private boolean selected;
    private static final String[] DIFFICULTY_LEVELS = new String[]
            { "Super-Easy", "Easy", "Medium","Hard","Extreme", "Chaos"};
    private static final Map<String,Integer> DIFFICULTIES =  new LinkedHashMap<String,Integer>(){{
        put("Super-Easy",80);
        put("Easy",100);
        put("Medium",120);
        put("Hard",130);
        put("Extreme",140);
        put("Chaos",170);

    }};
    public Map<String, Integer> getHashmap(){
	return DIFFICULTIES;}
    public DifficultyLevelPrompt() {
	
        JComboBox selections = new JComboBox(DIFFICULTIES.keySet().toArray());
        this.add(selections);
        int responseFromUser = JOptionPane.showConfirmDialog(null,this,
                "Select your difficulty:",JOptionPane.OK_CANCEL_OPTION,JOptionPane.OK_OPTION);
        Object itemChosen = selections.getSelectedItem();
        if (responseFromUser == JOptionPane.OK_OPTION && itemChosen != null) {
            difficulty = DIFFICULTIES.get(itemChosen.toString()).intValue();
            this.selected = true;
        } else {
            this.remove(this);
        }
    }
    public boolean isSelected() {
        return selected;
    }

    public int getDifficulty() {
        return difficulty;
    }
}
