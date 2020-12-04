package unit;

import static org.junit.Assert.assertEquals;

import calc.model.InvalidExpressionException;
import calc.model.visitor.Divide;

import org.junit.Test;

/**
 * JUnit testing for the Minus class.
 * @author Alex Cordaro ZDAC051
 */
public class DivideTest {
  
  @Test
  public void test() throws InvalidExpressionException {
    Divide divide = Divide.getInstance();
    assertEquals(divide.eval(3, 4), 0.75, 0.001);
  }
}
