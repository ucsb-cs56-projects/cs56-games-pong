package edu.ucsb.cs56.projects.games.pong;

import javax.swing.*;
import java.awt.*;

/**
 * Created by angel on 2/20/16.
 */
public abstract class MainMenuComponent extends JComponent implements UserRetrievable {

    private static Dimension dimension;

    public static void setDimension(Dimension dmtion) {
        dimension  = dmtion;
    }

    public static Dimension getDimension() {
        return dimension;
    }
}
