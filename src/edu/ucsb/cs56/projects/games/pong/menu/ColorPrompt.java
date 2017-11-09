package edu.ucsb.cs56.projects.games.pong.menu;

import javax.swing.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.awt.Color;

/** edu.ucsb.cs56.projects.games.pong.menu.ColorPrompt is the class that will allow players to select paddle colors 
 * @author Andrew Polk, Victoria Sneddon
 * @version CS56, Fall 2017, UCSB
 */
public class ColorPrompt extends JPanel {
		
    /**Holds if color for player1 has been selected*/
    private boolean selected;

    /**A list of strings of the availible colors */
    private static final String[] Color_Choices = new String[]
	{"White", "Pink", "Blue", "Green", "Orange", "Yellow", "Red", "Purple"};

    /**A map with keys (String) and values (Color) filled with colors */
    private static final Map<String, Color> COLORS = new LinkedHashMap<String, Color>(){{
	    put("White", new Color(255,255,255));
	    put("Pink", new Color(253,153,204));
	    put("Blue", new Color(153,204,255));
	    put("Green", new Color(153,255,153));
	    put("Orange", new Color(255,204,153));
	    put("Yellow", new Color(255,255,153));
	    put("Red", new Color(255,102,102));
	    put("Purple", new Color(204,153,255));
	}};

    /**Color for player 1 or left side */
    private static Color colorA = COLORS.get("White");

    /**Color for player 2 or right side*/
    private static Color colorB = COLORS.get("White");
		
    /**getHashmap() returns a map of preset colors
     * @return Map map of colors
     */
    public Map<String, Color> getHashmap(){
	return COLORS;}

    /**Constructor for the ColorPrompt class that takes no parameters*/
    public ColorPrompt(){
			
	//ComboBox for Player1 color picker
	JComboBox selections = new JComboBox(COLORS.keySet().toArray());
	this.add(selections);
	//ComboBox for Player2 color picker
	JComboBox selections2 = new JComboBox(COLORS.keySet().toArray());
	this.add(selections2);
	//Show option pane and save response to int
	int responseFromUser = JOptionPane.showConfirmDialog(null,this,
							     "Select your colors:",
							     JOptionPane.OK_CANCEL_OPTION,
							     JOptionPane.OK_OPTION);
	//Save chosen items to objects
	Object itemChosen = selections.getSelectedItem();
	//Save chosen items to objects
	Object itemChosen2 = selections2.getSelectedItem();
	//Check response from user and for selected items	
	if(responseFromUser == JOptionPane.OK_OPTION && itemChosen != null && itemChosen2 != null){
	    colorA = COLORS.get(itemChosen.toString());
	    colorB = COLORS.get(itemChosen2.toString());
	    this.selected = true;
	}else{
	    this.remove(this);
	}
    }

    /**isSelected() returns if items have been selected
     * @return boolean if selected
     */
    public boolean isSelected(){
	return selected;
    }
	
    /**getColorA() returns the color for player 1 or the left paddle
     * @return Color color for A
     */
    public static Color getColorA(){
	return colorA;
    }
    
    /**getColorB() return the color for player 2 or the right paddle
     * @return Color color for B
     */
    public static Color getColorB(){
	return colorB;
    }
}
