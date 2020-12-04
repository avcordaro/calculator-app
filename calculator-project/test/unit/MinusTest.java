package unit;

import static org.junit.Assert.assertEquals;

import calc.model.visitor.Minus;

import org.junit.Test;

/**
 * Dave's JUnit testing for the Minus class.
 * @author Dave Cohen
 */
public class MinusTest {
  
  @Test
  public void test() {
    Minus minus = Minus.getInstance();
    assertEquals(minus.eval(3, 4), -1, 0.001);
  }
}
