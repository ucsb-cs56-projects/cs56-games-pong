package edu.ucsb.cs56.projects.games.pong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

/**
 * Created by angel on 2/20/16.
 */
//TODO: Change MainMenuUI to MainMenu, they are the same thing
public class MainMenuUI {
    protected JFrame frame;
    protected JPanel panel;
    protected final int WIDTH = 640;
    protected final int HEIGHT = 480;

    private GridLayout gridLayout = new GridLayout(5,1);
    private MenuTextComponent menuTextComponent;
//    private HighScoreComponent highScoreComponent;
//    private PlayComponent playComponent;

    public MainMenuUI() {
        frame = new JFrame( "Main Menu" );
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        frame.setSize( WIDTH, HEIGHT );
        frame.setLocationRelativeTo( null );
//        frame.add(panel);
        ArrayList<MenuTextComponent> menuItems = new ArrayList<MenuTextComponent>();
        MenuTextComponent menuTextComponent1 = new MenuTextComponent("Instructions",Color.BLACK);
        MenuTextComponent menuTextComponent2 = new MenuTextComponent("Play",Color.BLACK);
        MenuTextComponent menuTextComponent3 = new MenuTextComponent("High Scores",Color.BLACK);
        menuTextComponent1.addMouseListener(menuTextComponent1); // make a handler
        menuTextComponent2.addMouseListener(menuTextComponent2);
        menuTextComponent3.addMouseListener(menuTextComponent3);

        menuItems.add(menuTextComponent1);
        menuItems.add(menuTextComponent2);
        menuItems.add(menuTextComponent3);

        panel.setSize(WIDTH, HEIGHT);
        panel.setBackground(Color.BLACK);
        panel.setOpaque(true);

        panel.setVisible(true);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        MenuPaddingComponent menuList = new MenuPaddingComponent(Color.BLACK,HEIGHT,WIDTH/2);
        panel.add(new MenuPaddingComponent(Color.BLACK,HEIGHT,WIDTH/4),BoxLayout.X_AXIS);
        panel.add(menuList,BoxLayout.X_AXIS);
//        panel.add(new MenuPaddingComponent(Color.BLUE,HEIGHT,WIDTH/2),BoxLayout.X_AXIS);
//        panel.add(gridLayout,HEIGHT,WIDTH/2);

        panel.add(new MenuPaddingComponent(Color.BLACK,HEIGHT,WIDTH/4),BoxLayout.X_AXIS);
        menuList.setLayout(gridLayout);

        menuList.add(new MenuPaddingComponent(Color.BLACK,HEIGHT,WIDTH));
        for(MenuTextComponent component: menuItems) {
            menuList.add(component.getTitle(), component);

        }
        menuList.add(new MenuPaddingComponent(Color.BLACK,HEIGHT,WIDTH));
//        panel.setLayout(gridLayout);
//        panel.add(menuTextComponent);
        frame.add(panel);
//        frame.setLayout(gridLayout);
//        frame.repaint();
        frame.setVisible(true);



    }

    public static void main(String[] args){
        MainMenuUI menu = new MainMenuUI();
    }

}
