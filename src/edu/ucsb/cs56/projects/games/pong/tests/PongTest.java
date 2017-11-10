package edu.ucsb.cs56.projects.games.pong.tests;

import edu.ucsb.cs56.projects.games.pong.gameplay.Pong;

import static org.junit.Assert.assertEquals;

/**
 * The test class PongTest to test the class Pong
 *
 * @author Jake Dumont, Heneli Kailahi
 * @version CS56, Spring 2013, CS56-Games-Pong
 * @see Pong
 */
public class PongTest 
{
    /**Basic constructor for PongTest*/
    public PongTest() {}
    
    /**
     * test constructor from Pong
     * @see Pong
     */
  /*@Test 
    public void testConstructor()
    {
      Pong game = new Pong();
      Paddle pp = new Paddle(8, 160);
      Ball bb = new Ball(300, 300, 20, 20);
      
      assertEquals(pp.getXpos(),game.p1.getXpos());
      assertEquals(pp.getYpos(),game.p1.getYpos());
      
      assertEquals(bb.getXpos(), game.b.getXpos());
      assertEquals(bb.getYpos(), game.b.getYpos());
    }*/

    
    //////////////////////////////////////////////
    // tests the incrementor
    // for loop
    ////////////////////////////////   
    /**
     * test getPoints
     * @see Pong#getPoints
     */
    /*
      @Test public void testgetHits()
      {
      Pong game = new Pong();
      game.setPoints(5);
      assertEquals(5,game.getPoints());
      }
    */
}
