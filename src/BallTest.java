//package edu.ucsb.cs56.projects.S13.cs56_games_pong;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * The test class BallTest to test the class Ball
 *
 * @author Timothy Fok
 * @author Bhanu Khanijau
 * @author Sanchit Gupta
 * @version CS56, Spring 2013, cp1 05.15.13
 * @see Ball
 */

public class BallTest {
    
/**
	test constructor from BallTest
	@see Ball
*/
	@Test public void testConstructor(){
		Ball ball = new Ball(20,20,20,20);
		assertEquals(20,ball.getXpos());
		assertEquals(20,ball.getYpos()); 
	}

/**
	test constructor again from BallTest
	@see Ball
*/
	@Test public void testConstructor2(){
		Ball ball = new Ball(30,100,20,20);
		assertEquals(30,ball.getXpos());
		assertEquals(100,ball.getYpos()); 
	}

/**
	test getdx
	@see Ball#getdx
*/
	@Test public void testgetdx(){
		Ball ball = new Ball(30,100,20,20);
		ball.setdx(5);
		assertEquals(5,ball.getdx());
	}
  
/**
	test getdy
	@see Ball#getdy
*/  
	@Test public void testgetdy(){
		Ball ball = new Ball(30,100,20,20);
		ball.setdy(7);
		assertEquals(7,ball.getdy());
	}


}

