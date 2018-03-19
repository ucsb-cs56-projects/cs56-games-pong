package edu.ucsb.cs56.projects.games.pong.tests;

import edu.ucsb.cs56.projects.games.pong.gameplay.Paddle;
import edu.ucsb.cs56.projects.games.pong.gameplay.Ball;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * The test class PaddleTest to test the class Paddle
 *
 * @author Timothy Fok
 * @version CS56, Spring 2012, cp1 05.18.12
 * @author Samuel Fu, Xingxing Geng
 * @version CS56, Winter 2018
 * @see Paddle
 */

public class PaddleTest 
{
    /**Basic constructor for PaddleTest*/
    public PaddleTest() {}
    
    /**
     * test constructor from PaddleTest
     * @see Paddle
     */ 
    @Test
    public void testConstructor_1(){
        Paddle paddle = new Paddle(20,20, 90, 1);
        assertEquals(20,paddle.getXCoordinate());
	assertEquals(20,paddle.getYCoordinate()); 
    }
    
    @Test
    public void testConstructor_2(){
        Paddle paddle = new Paddle(50,50, 90, 1,false);
        assertEquals(50,paddle.getXCoordinate());
        assertEquals(50,paddle.getYCoordinate());
    }
    
    private Paddle p1 = new Paddle(30,30,50,2);
    private Paddle p2 = new Paddle(15,15,30,3);
    private Paddle p3 = new Paddle(40,40,90,4);
    private Paddle p4 = new Paddle(25,25,50,5,true);
    private Paddle p5 = new Paddle(30,30,100,0,false);

/*    @Test
    public void decrementBall(){
        p1.decrementBalls();
        assertEquals(1,p1.ballCount);
    }*/
    
    @Test
    public void testIncrementPoint(){
        p1.incrementPoints(5);
        assertEquals(5,p1.getPoints());
    }
    
    @Test
    public void testIncrementPoint_2(){
        p2.incrementPoints(0);
        assertEquals(0,p2.getPoints());
    }
    
    @Test
    public void testIncrementPoint_onRight(){
        p5.incrementPoints(10);
        assertEquals(10,p5.getPoints());
    }
    
    @Test
    public void testIncrementPoint_onRight_2(){
        p4.incrementPoints(20);
        assertEquals(20,p4.getPoints());
    }
    
    @Test
    public void testPlayerMissing(){
        Ball b = new Ball(10,10,20,20,true);
        p1.playerMissed(b,10,p5);
        assertEquals(10,p5.getPoints());
    }
    
    @Test
    public void testPlayerMissing_2(){
        Ball b = new Ball(20,20,40,40,false);
        p2.playerMissed(b,10,p4);
        assertEquals(10,p4.getPoints());
    }
    

}
