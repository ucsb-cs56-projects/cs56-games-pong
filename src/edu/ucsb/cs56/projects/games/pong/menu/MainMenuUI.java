package edu.ucsb.cs56.projects.games.pong.menu;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by angel on 2/20/16.
 */
//TODO: Change MainMenuUI to MainMenu, they are the same thing
public class MainMenuUI extends JPanel {
    protected static final int WIDTH = 640;
    protected static final int HEIGHT = 480;
    private ArrayList<MenuTextComponent> menuItems = new ArrayList<MenuTextComponent>();

//    private HighScoreComponent highScoreComponent;
//    private PlayComponent playComponent;

    public MainMenuUI() {

        // REQUIRED DIMENSIONAL SETUP
        MainMenuComponent.setDimension(new Dimension(WIDTH, HEIGHT));
        MenuTextComponent menuTextComponent1 = new InstructionsTextComponent("Instructions", Color.BLACK);
        MenuTextComponent menuTextComponent2 = new PlayTextComponent("Play", Color.BLACK);
        MenuTextComponent menuTextComponent3 = new HighScoreTextComponent("High Scores", Color.BLACK);
        menuTextComponent1.addMouseListener(menuTextComponent1); // make a handler
        menuTextComponent2.addMouseListener(menuTextComponent2);
        menuTextComponent3.addMouseListener(menuTextComponent3);

        menuItems.add(menuTextComponent1);
        menuItems.add(menuTextComponent2);
        menuItems.add(menuTextComponent3);
        this.setSize(WIDTH, HEIGHT);
//        panel.setBackground(Color.BLACK);
//        panel.setOpaque(true);
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        MenuPaddingComponent menuList = new MenuPaddingComponent(Color.BLACK, HEIGHT, WIDTH / 2);
        this.add(new MenuPaddingComponent(Color.BLACK, HEIGHT, WIDTH / 4), BoxLayout.X_AXIS);
        this.add(menuList, BoxLayout.X_AXIS);

        this.add(new MenuPaddingComponent(Color.BLACK, HEIGHT, WIDTH / 4), BoxLayout.X_AXIS);
        menuList.setLayout(new GridLayout(5,1));

        menuList.add(new MenuPaddingComponent(Color.BLACK, HEIGHT, WIDTH));
        for (MenuTextComponent component : menuItems) {
            menuList.add(component.getTitle(), component);

        }
        menuList.add(new MenuPaddingComponent(Color.BLACK, HEIGHT, WIDTH));
    }
}
