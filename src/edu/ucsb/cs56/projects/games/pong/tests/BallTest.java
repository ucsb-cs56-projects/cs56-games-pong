package edu.ucsb.cs56.projects.games.pong.tests;

import edu.ucsb.cs56.projects.games.pong.gameplay.Ball;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * The test class BallTest to test the class Ball
 *
 * @author Timothy Fok
 * @version CS56, Spring 2012, cp1 05.18.12
 * @author Samuel Fu, Xingxing Geng
 * @version CS56, Winter 2018
 * @see Ball
 */

public class BallTest 
{
    /**Default BallTest constructor*/
    public BallTest(){}
    
    @Test public void testConstructor_1()
    {
        Ball ball = new Ball(20,20,20,20,false);
        assertEquals(20,ball.getWidth());
        assertEquals(20,ball.getHeight());
  }
    
    @Test public void testConstructor_2()
    {
        Ball ball = new Ball(0,0,30,30,true);
        assertEquals(0,ball.getXCoordinate());
        assertEquals(0,ball.getYCoordinate());
    }

    @Test public void testConstructor_4()
    {
        Ball ball = new Ball(0,0,30,30,true);
        assertEquals(-1,ball.getSpeed());
    }
    
    @Test public void testConstructor_3()
    {
        Ball ball = new Ball(0,0,30,30,true);
        assertEquals(-1,ball.getSpeed());
    }
    
    private Ball b1 =  new Ball(0,0,30,30,false);
    private Ball b2 =  new Ball(200,200,30,30,false);
    private Ball b3 =  new Ball(100,50,20,20,true);
    private Ball b4 =  new Ball(50,100,20,30,true);
    
    @Test public void testgetYVelocity()
    {
        b1.setYVelocity(5);
        b2.setYVelocity(10);
        assertEquals(5,b1.getYVelocity());
        assertEquals(10,b2.getYVelocity());
    }
    
    @Test public void testisAttached()
    {
        b1.setAttached(false);
        b2.setAttached(true);
        assertEquals(false,b1.isAttached());
        assertEquals(true,b2.isAttached());
    }
    
    @Test public void testgetSpeed()
    {
        b1.setSpeed(5);
        b2.setSpeed(10);
        assertEquals(5,b1.getSpeed());
        assertEquals(10,b2.getSpeed());
    }
    
    @Test public void testgetBallLost()
    {
        b1.setBallsLost(2);
        b2.setBallsLost(1);
        assertEquals(2,b1.getBallsLost());
        assertEquals(1,b2.getBallsLost());
    }
    
    @Test public void testBallAttachUpdate()
    {
        b1.setAttached(true);
        b2.setAttached(true);
        b1.ballAttachUpdate();
        b2.ballAttachUpdate();
        assertEquals(0,b1.getYVelocity());
        assertEquals(0,b2.getYVelocity());
    }


}
