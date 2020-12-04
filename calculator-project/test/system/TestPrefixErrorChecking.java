package system;

import calc.model.BadTypeException;
import calc.model.EmptyStackException;
import calc.model.InvalidExpressionException;
import calc.model.RevPolishCalc;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * System test for release_v1.2_prefix_calculator, to show that upon the user entering 
 * an invalid prefix expression, an exception is thrown with the correct message.
 * @author Alex Cordaro ZDAC051
 */
public class TestPrefixErrorChecking {

  private RevPolishCalc rvpCalc;
  
  @Rule
  public ExpectedException exception = ExpectedException.none();
  
  @Before
  public void setUp() throws Exception {
    rvpCalc = new RevPolishCalc();
  }

  @Test
  public void testAlphabetInput() throws InvalidExpressionException, 
      BadTypeException, EmptyStackException {
    exception.expect(InvalidExpressionException.class);
    exception.expectMessage("Invalid expression.");
    rvpCalc.evaluate("3 a +");
  }
  
  @Test
  public void testPunctuationInput() throws InvalidExpressionException, 
      BadTypeException, EmptyStackException {
    exception.expect(InvalidExpressionException.class);
    exception.expectMessage("Invalid expression.");
    rvpCalc.evaluate("3 3 !");
  }
  
  @Test
  public void testUnbalancedInputs() throws InvalidExpressionException, 
      BadTypeException, EmptyStackException {
    exception.expect(InvalidExpressionException.class);
    exception.expectMessage("Unbalanced expression.");
    rvpCalc.evaluate("3 5 + -");
  }
  
  @Test
  public void testDivisionByZero() throws InvalidExpressionException, 
      BadTypeException, EmptyStackException {
    exception.expect(InvalidExpressionException.class);
    exception.expectMessage("Invalid division by zero.");
    rvpCalc.evaluate("1 0 /");
  }
  
  @Test
  public void testAnswerOverflow() throws InvalidExpressionException, 
      BadTypeException, EmptyStackException {
    exception.expect(InvalidExpressionException.class);
    exception.expectMessage("Answer is too large.");
    rvpCalc.evaluate("999999999 999999999 999999999 999999999 999999999 * * * *");
  }
  
  @Test
  public void testInputOverflow() throws InvalidExpressionException, 
      BadTypeException, EmptyStackException {
    exception.expect(InvalidExpressionException.class);
    exception.expectMessage("Input value(s) are too large.");
    rvpCalc.evaluate("999999999999 1 +");
  }
}