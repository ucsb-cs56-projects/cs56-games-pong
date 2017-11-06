package edu.ucsb.cs56.projects.games.pong.menu;

import javax.swing.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.awt.Color;

/** created by Andrew Polk and Victoria Sneddon **/

public class ColorPrompt extends JPanel {

		private boolean selected;
		private boolean selected2;
		private static final String[] Color_Choices = new String[]
			{"White", "Pink", "Blue", "Green", "Orange", "Yellow", "Red", "Purple"};
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

		private static Color colorA = COLORS.get("White");
		private static Color colorB = COLORS.get("White");
		
		public Map<String, Color> getHashmap(){
		return COLORS;}
		public ColorPrompt(){
			
			JComboBox selections = new JComboBox(COLORS.keySet().toArray());
			this.add(selections);
			JComboBox selections2 = new JComboBox(COLORS.keySet().toArray());
			this.add(selections2);
			int responseFromUser = JOptionPane.showConfirmDialog(null,this,
			"Select your colors:" ,JOptionPane.OK_CANCEL_OPTION, JOptionPane.OK_OPTION);
			Object itemChosen = selections.getSelectedItem();
			if(responseFromUser == JOptionPane.OK_OPTION && itemChosen != null){
				colorA = COLORS.get(itemChosen.toString());
				this.selected = true;
			}else{
				this.remove(this);
			}
			Object itemChosen2 = selections2.getSelectedItem();
			if(responseFromUser == JOptionPane.OK_OPTION && itemChosen2 != null){
				colorB = COLORS.get(itemChosen2.toString());
				this.selected2 = true;
			}else{
				this.remove(this);
			}
			
			/*int responseFromUser2 = JOptionPane.showConfirmDialog(null, this, 
			"Select your color:" , JOptionPane.OK_CANCEL_OPTION, JOptionPane.OK_OPTION);*/
			
		}
		public boolean isSelected(){
			return selected;
		}
		
		public static Color getColorA(){
			return colorA;
		}
		public static Color getColorB(){
			return colorB;
		}
}