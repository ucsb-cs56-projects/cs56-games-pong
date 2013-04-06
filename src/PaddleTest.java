import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * The test class PaddleTest to test the class Paddle
 *
 * @author Timothy Fok
 * @version CS56, Spring 2012, cp1 05.18.12
 * @see Paddle
 */

public class PaddleTest 
{
    /**
       test constructor from PaddleTest
       @see Paddle

     */ 
   @Test public void testConstructor(){
        Paddle paddle = new Paddle(20,20);
        assertEquals(20,paddle.getXpos());
	assertEquals(20,paddle.getYpos()); 
    }

    /**
       test constructor from PaddleTest
       @see Paddle

     */
   @Test public void testConstructor2(){
       Paddle paddle = new Paddle(30,100);
        assertEquals(30,paddle.getXpos());
	assertEquals(100,paddle.getYpos()); 
    }
 
  

    /**
       test getdy
       @see Paddle#getdy
     */
  @Test public void testgetdy(){
        Paddle paddle = new Paddle(30,100);
	paddle.setdy(7);
        assertEquals(7,paddle.getdy());
    }


}

