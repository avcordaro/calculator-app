package unit;

import static org.junit.Assert.assertEquals;

import calc.model.visitor.Plus;

import org.junit.Test;

/**
 * Dave's JUnit testing for the Plus class.
 * @author Dave Cohen
 */
public class PlusTest {
  
  @Test
  public void test() {
    Plus plus = Plus.getInstance();
    assertEquals(plus.eval(3, 4), 7, 0.001);
  }
}
