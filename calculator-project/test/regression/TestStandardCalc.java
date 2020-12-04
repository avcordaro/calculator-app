package regression;

import static org.junit.Assert.assertEquals;

import calc.model.BadTypeException;
import calc.model.EmptyStackException;
import calc.model.InvalidExpressionException;
import calc.model.StandardCalc;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Regression test to ensure StandardCalc functions correctly after system modifications.
 * @author Alex Cordaro ZDAC051
 */
public class TestStandardCalc {
  
  private StandardCalc stdCalc;

  @Before
  public void setUp() throws Exception {
    stdCalc = new StandardCalc();
  }
  
  @Test
  public void testEvaluateBasic() throws Exception {
    assertEquals(stdCalc.evaluate("3 + 5"), 8, 0.001);
  }
  
  @Test
  public void testEvaluateIntermediate() throws Exception {
    assertEquals(stdCalc.evaluate("( 5 * ( 6 + 7 ) ) - 2"), 63, 0.001);
  }

  @Test
  public void testEvaluateHard() throws Exception {
    assertEquals(stdCalc.evaluate("( 2 + ( 3 + 5 ) * ( 4 + 8 ) / 2 ) / 20"), 2.5, 0.001);
  }
  
  @Rule
  public ExpectedException exception = ExpectedException.none();

  @Test
  public void testInvalidExpressionExceptionLetters() throws InvalidExpressionException, 
      BadTypeException, EmptyStackException {
    exception.expect(InvalidExpressionException.class);
    exception.expectMessage("Invalid expression.");
    stdCalc.evaluate("3 + a - 5");
  }
  
  @Test
  public void testInvalidExpressionExceptionPunctuation() throws InvalidExpressionException, 
      BadTypeException, EmptyStackException {
    exception.expect(InvalidExpressionException.class);
    exception.expectMessage("Invalid expression.");
    stdCalc.evaluate("3 ! 4 - 5");
  }

  @Test
  public void testInvalidExpressionExceptionUnbalanced() throws InvalidExpressionException, 
      BadTypeException, EmptyStackException {
    exception.expect(InvalidExpressionException.class);
    exception.expectMessage("Unbalanced expression.");
    stdCalc.evaluate("( 5 + 3 ) + 2 -");
  }

  @Test
  public void testDivisionByZero() throws InvalidExpressionException, 
      BadTypeException, EmptyStackException { 
    exception.expect(InvalidExpressionException.class);
    exception.expectMessage("Invalid division by zero.");
    stdCalc.evaluate("1 / 0");
  }
  
  @Test
  public void testAnswerArithmeticOverflow() throws InvalidExpressionException, 
      BadTypeException, EmptyStackException { 
    exception.expect(InvalidExpressionException.class);
    exception.expectMessage("Answer is too large.");
    stdCalc.evaluate("999999999 * 999999999 * 999999999 * 999999999 * 999999999");
  }
  
  @Test
  public void testInputArithmeticOverflow() throws InvalidExpressionException, 
      BadTypeException, EmptyStackException { 
    exception.expect(InvalidExpressionException.class);
    exception.expectMessage("Input value(s) are too large.");
    stdCalc.evaluate("999999999999 + 1");
  }
}
