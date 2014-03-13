package edu.ucsb.cs56.projects.games.pong;

import java.util.ArrayList;
import java.io.*;
import java.awt.*;

class EndOfGame {

    public ArrayList<HighScore> hList = new ArrayList<HighScore>();

    public HighScore winner;
    
    public EndOfGame( int score, String name )
    {
	winner = new HighScore( score, name ); 
	readTheFile();
	saveToFile();
    }

    public void readTheFile()
    {
	System.out.println( "readTheFile()" );
	try{
	    File scoresFile = new File( "scores.txt" );
	    FileReader fileReader = new FileReader( scoresFile );
	    BufferedReader reader = new BufferedReader( fileReader );

	    String line = reader.readLine();
	    System.out.println( "scores.txt = " + line );

	    String[] parsedList = line.split( "/" );
	    putInArrayList( parsedList );
	    checkArrayList();
	    reader.close();
	}catch( IOException ioe ){
	    ioe.printStackTrace();
	}
    }

    public void checkArrayList()
    {
	for( int i = 0; i < 5; i++ )
	    {
		if( isGreaterThan( i ) )
		    {
			hList.add( i, winner );
			hList.remove( 5 );
			return;
		    }
	    }
    }

    public boolean isGreaterThan( int i )
    {
	if( winner.getPlayerScore() > hList.get( i ).getPlayerScore() )
	    return true;
	return false;
    }

    public void putInArrayList( String[] parsedList )
    {
	HighScore hs;
	for( int i = 0; i < 5; i++ )
	    {
		hs = new HighScore( Integer.parseInt( parsedList[ 2*i ] ),
				    parsedList[ 2*i + 1 ] );
		hList.add( hs );
	    }
    }

    public void saveToFile( )
    {
	System.out.println( "saveToFile()" );
	try{
	    FileWriter writer = new FileWriter( "scores.txt" );
	    String finalOutput = "";
	    for( int i = 0; i < 5; i++ )
		{
		    finalOutput = finalOutput + hList.get( i ).toString( "/", "/" );
		}
	    
	    writer.write( finalOutput );
	    writer.flush();
	    System.out.println( "scores.txt = " + finalOutput );
	    writer.close();
	}catch( IOException ioe ){
	    ioe.printStackTrace();
	}
    }
    
}
