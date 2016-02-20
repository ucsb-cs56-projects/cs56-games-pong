package edu.ucsb.cs56.projects.games.pong;

import sun.awt.VerticalBagLayout;

import javax.swing.*;
import java.awt.*;
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

    private GridLayout gridLayout = new GridLayout(3,1);
    private InstructionsComponent instructionsComponent;
//    private HighScoreComponent highScoreComponent;
//    private PlayComponent playComponent;

    public MainMenuUI() {
        frame = new JFrame( "Main Menu" );
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        frame.setSize( WIDTH, HEIGHT );
        frame.setLocationRelativeTo( null );
//        frame.add(panel);
        ArrayList<MainMenuComponent> menuItems = new ArrayList<MainMenuComponent>();
        InstructionsComponent instructionsComponent1 = new InstructionsComponent(Color.darkGray);
        InstructionsComponent instructionsComponent2 = new InstructionsComponent(Color.PINK);
        InstructionsComponent instructionsComponent3 = new InstructionsComponent(Color.MAGENTA);

        menuItems.add(instructionsComponent1);
        menuItems.add(instructionsComponent2);
        menuItems.add(instructionsComponent3);

        panel.setSize(WIDTH, HEIGHT);
        panel.setBackground(Color.BLACK);
        panel.setOpaque(true);

        panel.setVisible(true);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        MenuPaddingComponent menuList = new MenuPaddingComponent(Color.BLUE,HEIGHT,WIDTH/2);
        panel.add(new MenuPaddingComponent(Color.GREEN,HEIGHT,WIDTH/4),BoxLayout.X_AXIS);
        panel.add(menuList,BoxLayout.X_AXIS);
//        panel.add(new MenuPaddingComponent(Color.BLUE,HEIGHT,WIDTH/2),BoxLayout.X_AXIS);
//        panel.add(gridLayout,HEIGHT,WIDTH/2);

        panel.add(new MenuPaddingComponent(Color.RED,HEIGHT,WIDTH/4),BoxLayout.X_AXIS);

        for(MainMenuComponent component: menuItems) {
            menuList.add(component.getTitle(),component);
        }

        menuList.setLayout(gridLayout);
//        panel.setLayout(gridLayout);
//        panel.add(instructionsComponent);
        frame.add(panel);
//        frame.setLayout(gridLayout);
//        frame.repaint();
        frame.setVisible(true);


    }

    public static void main(String[] args){
        MainMenuUI menu = new MainMenuUI();
    }

}
