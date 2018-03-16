package edu.ucsb.cs56.projects.games.pong.menu.instructions;

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/** edu.ucsb.cs56.projects.games.pong.menu.instructions.Instructions is the classs that displays the instructions to the game when the user presses the instructions button
 @author Vincent Gandolfo, Krishna Lingampalli
 @version CS56, Winter 2015, UCSB
 @author Victoria Sneddon, Andrew Polk
 @version CS56, Fall 2017, UCSB
*/

public class Instructions{
    JFrame jf;

    /** Constructor that sets up the JFrame and Components that allow the instructions to be displayed */
    public Instructions()
    {
	setUpFrame();
	setUpFrameComponents();
    }

    /** setUpFrame() creates the Frame, names it, and sets the size of the frame */
    public void setUpFrame()
    {
	jf = new JFrame( "Instructions" );
	jf.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	jf.setSize( 640, 640 );

	jf.setLocationRelativeTo( null );
	jf.setResizable( false );
	setToVisible();

    }

    /** setUpFrameComponents()  sets up the layout on the frame and puts on the Instructions and the "Back To Main Menu" button */
    public void setUpFrameComponents()
    {
	JButton backToMain = new JButton( "Back To Main Menu" );
	backToMain.addActionListener( new BackToMainListener() );
	jf.add( backToMain, BorderLayout.SOUTH );

	JPanel jp = new JPanel();
	jf.add( jp );

	JLabel l = new JLabel( displayInstructions(), SwingConstants.CENTER );
 	jp.add( l );
    }

    /** setToVisible()  Sets the frame to visible */
    public void setToVisible()
    {
	jf.setVisible(true);
    }

    /** displayInstructions() displays the Instructions on how to play
     * @return String returns instructions
     */
    public String displayInstructions()
    {
	    String fileName = "instructions.txt";

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            line = bufferedReader.readLine();

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
		return line;
	    
    }

    /** The action when the button "Back To Main Menu" is pressed. It just makes the frame not visible, so it appears to be closed and does not need to create a new instance of Instructions for every time the user clicks how to play */
    class BackToMainListener implements ActionListener{
	public void actionPerformed(ActionEvent e){
	    jf.setVisible(false);
	}
    }


}
