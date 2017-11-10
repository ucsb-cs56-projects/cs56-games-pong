package edu.ucsb.cs56.projects.games.pong.menu;

import java.awt.*;

/**
 * @author angel on 2/20/16.
 * @author Victoria, Sneddon
 * @version Fall 2017
 */
public class MenuPaddingComponent extends MainMenuComponent {
    
    /**new int height*/
    private int height;
    
    /**new int width*/
    private int width;

    /**new Color for background*/
    private Color backgroundColor;

    /**
     * @param backgroundColor chosen background color 
     * @param height inputted height
     * @param width inputted width
     * sets the height and width and background color and saves the preferred size to be of Dimension width, height
     */
    public MenuPaddingComponent(Color backgroundColor,int height, int width) {

	/*superextends Main Menu Component*/
        super();

	/*sets height*/
        this.height = height;
	
	/*sets width*/
        this.width = width;

	/*sets background color*/
        this.backgroundColor = backgroundColor;

	/*sets preferred size to dimension of given width and height */
        this.setPreferredSize(new Dimension(width,height));
    }

    /**
     * creates actual image with Graphic g and sets color to backgroundColor and fills rectangle at location 0, 0 of given width and height
     * @param g for graphics
     */
    @Override
    public void paintComponent(Graphics g) {
        
	/*creates image*/
	super.paintComponent(g);
        
	/*sets color to backgroundColor*/
	g.setColor(backgroundColor);
	/*creates rectangle at x-coordinate 0 and y-coordiate 0 with the given width and height*/
        g.fillRect(0,0,width,height);
    }

}
