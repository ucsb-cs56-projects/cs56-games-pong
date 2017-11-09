package edu.ucsb.cs56.projects.games.pong.menu;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * @author  angel on 2/20/16.
 * @author Victoria Sneddon, Andrew Polk
 * @version Fall 2017
 */

//TODO: Change MainMenuUI to MainMenu, they are the same thing

/**
 * sets width and height and creates a new Array List of MenuTextComponents called menuItems
 */
public class MainMenuUI extends JPanel {
    protected static final int WIDTH = 640;
    protected static final int HEIGHT = 480;
    private ArrayList<MenuTextComponent> menuItems = new ArrayList<MenuTextComponent>();

//    private HighScoreComponent highScoreComponent;
//    private PlayComponent playComponent;

    public MainMenuUI() {

        /* REQUIRED DIMENSIONAL SETUP, makes a handler and sets colors and layout*/
        MainMenuComponent.setDimension(new Dimension(WIDTH, HEIGHT));

	/*creates new MenuTextComponent called Instructions in black*/
        MenuTextComponent menuTextComponent1 = new InstructionsTextComponent("Instructions", Color.BLACK);

	/*creates new MenuTextComponent that outputs Play in black*/
        MenuTextComponent menuTextComponent2 = new PlayTextComponent("Play", Color.BLACK);

	/*creates new MenuTextComponent that outputs High Scores in black*/
        MenuTextComponent menuTextComponent3 = new HighScoreTextComponent("High Scores", Color.BLACK);
	
	/*makes a handler from menuTextComponent1*/
        menuTextComponent1.addMouseListener(menuTextComponent1); // make a handler
        
	/*makes a handler from menuTextComponent2*/
	menuTextComponent2.addMouseListener(menuTextComponent2);
       
	/*makes a handler from menuTextComponent3*/
	menuTextComponent3.addMouseListener(menuTextComponent3);

	/*adds menuTextComponent1 to menuItems*/
	menuItems.add(menuTextComponent1);

	/*adds menuTextComponent2 to menuItems*/
        menuItems.add(menuTextComponent2);
  
	/*adds menuTextComponent3 to menuItems*/
	menuItems.add(menuTextComponent3);

	/*sets size to given Width and Height*/
        this.setSize(WIDTH, HEIGHT);
//        panel.setBackground(Color.BLACK);
//        panel.setOpaque(true);

	/*sets Layout to boxlayout*/
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

	/*creates variable menuList with MenuPaddingComponent set to black with height and half of width*/
        MenuPaddingComponent menuList = new MenuPaddingComponent(Color.BLACK, HEIGHT, WIDTH / 2);

	/*adds MenuPaddingComponent that is black, has height, and a fourth of the width with the x_axis box layout*/
        this.add(new MenuPaddingComponent(Color.BLACK, HEIGHT, WIDTH / 4), BoxLayout.X_AXIS);

	/*adds menuList and BoxLayout.X_AXIS*/
        this.add(menuList, BoxLayout.X_AXIS);

	/* adds another MenuPaddingComponent that is black, height, and a fourth of the width w/ BoxLayout.X_Axis*/
        this.add(new MenuPaddingComponent(Color.BLACK, HEIGHT, WIDTH / 4), BoxLayout.X_AXIS);

	/*sets a GridLayout to 5, 1*/
        menuList.setLayout(new GridLayout(5,1));

	/*adds MenuPaddingComponent that is black, with height and width*/
        menuList.add(new MenuPaddingComponent(Color.BLACK, HEIGHT, WIDTH));
	
	/*for each component in menuItems, add the title of the component and the component*/
        for (MenuTextComponent component : menuItems) {
            menuList.add(component.getTitle(), component);

        }

	/*add MenuPaddingComponent that is black with height and width*/
        menuList.add(new MenuPaddingComponent(Color.BLACK, HEIGHT, WIDTH));
    }
}
