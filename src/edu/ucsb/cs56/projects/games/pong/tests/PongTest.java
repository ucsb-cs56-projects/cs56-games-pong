package edu.ucsb.cs56.projects.games.pong.tests;

import edu.ucsb.cs56.projects.games.pong.gameplay.Pong;
import edu.ucsb.cs56.projects.games.pong.gameplay.Ball;
import edu.ucsb.cs56.projects.games.pong.gameplay.Paddle;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * The test class PongTest to test the class Pong
 *
 * @author Jake Dumont, Heneli Kailahi
 * @version CS56, Spring 2013, CS56-Games-Pong
 * @author Samuel Fu, Xingxing Geng
 * @version CS56, Winter 2018
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
    private Paddle p1 = new Paddle(30,30,50,2);
    private Paddle p2 = new Paddle(15,15,30,3);
    private Paddle p3 = new Paddle(40,40,90,4);
    private Paddle p4 = new Paddle(25,25,50,5);
    private Paddle p5 = new Paddle(30,30,100,0,false);
    
    private Ball b1 =  new Ball(0,0,30,30,false);
    private Ball b2 =  new Ball(200,200,30,30,false);
    private Ball b3 =  new Ball(100,50,20,20,true);
    private Ball b4 =  new Ball(50,100,20,30,true);
    
  @Test
    public void testConstructor()
    {
      Pong game = new Pong();
      Paddle pp = new Paddle(30,30,50,2);
      Ball bb = new Ball(0,0,30,30,false);
      
      assertEquals(pp.getXCoordinate(),30);
      assertEquals(pp.getYCoordinate(),30);
    }

    @Test
    public void testgetHits()
    {
        Pong game = new Pong();
        game.hitsReset();
        assertEquals(0,game.getHits());
    }
    
    @Test
    public void testhitReset()
    {
        Pong game = new Pong();
        game.hitsReset();
        
        assertEquals(0,game.getHits());
    }
    
    @Test
    public void testincrementHits()
    {
        Pong game = new Pong();
        game.hitsReset();
        game.incrementHits();
        assertEquals(1,game.getHits());
    }
    
    @Test
    public void testsetwinner()
    {
        Pong game = new Pong();
        game.setWinner(p1);
        assertEquals(p1,game.getWinner());
    }
    
    @Test
    public void testgetPlayer1()
    {
        Pong game = new Pong();
        assertEquals(p1,game.getPlayer1());
    }
    
    @Test
    public void testgetPlayer2()
    {
        Pong game = new Pong();
        assertEquals(p2,game.getPlayer2());
    }
    
}
