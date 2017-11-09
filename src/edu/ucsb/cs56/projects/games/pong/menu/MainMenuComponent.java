package edu.ucsb.cs56.projects.games.pong.menu;

import javax.swing.*;
import java.awt.*;

/**
 * @author angel on 2/20/16.
 * @author Victoria Sneddon, Andrew Polk
 * @version Fall 2017
 */
public abstract class MainMenuComponent extends JComponent {

    /**
     *Dimension type
     * @param dimension static Dimension
     */
    private static Dimension dimension;
    
    /**
     *set dimention equal to dmtion
     * @param dmtion sets Dimension
     */
    public static void setDimension(Dimension dmtion) {
        dimension  = dmtion;
    }
    
    /**
     * returns dimension
     * @return Dimension getDimension
     */
    public static Dimension getDimension() {
        return dimension;
    }
}
