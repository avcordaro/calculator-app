package unit;

import static org.junit.Assert.assertEquals;

import calc.model.visitor.Times;

import org.junit.Test;

/**
 * Dave's JUnit testing for the Times class.
 * @author Dave Cohen
 */
public class TimesTest {
  
  @Test
  public void test() {
    Times times = Times.getInstance();
    assertEquals(times.eval(3, 4), 12, 0.001);
  }
}
