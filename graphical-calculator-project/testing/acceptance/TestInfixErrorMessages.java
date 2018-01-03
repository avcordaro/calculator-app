package acceptance;

import calc.model.BadTypeException;
import calc.model.EmptyStackException;
import calc.model.InvalidExpressionException;
import calc.model.StandardCalc;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Acceptance test for release_v1.1_infix_calculator, to satisfy the following quote from 
 * requirements: "If the input does not make sense then we expect a good message to help 
 * the user". This test will prove that invalid infix expressions display helpful error messages. 
 * @author Alex Cordaro ZDAC051
 */
public class TestInfixErrorMessages {

  private StandardCalc stdCalc;
  
  @Rule
  public ExpectedException exception = ExpectedException.none();
  
  @Before
  public void setUp() throws Exception {
    stdCalc = new StandardCalc();
  }

  @Test
  public void testAlphabetInput() throws InvalidExpressionException, 
      BadTypeException, EmptyStackException {
    exception.expect(InvalidExpressionException.class);
    exception.expectMessage("Invalid expression.");
    stdCalc.evaluate("3 + a");
  }
  
  @Test
  public void testPunctuationInput() throws InvalidExpressionException, 
      BadTypeException, EmptyStackException {
    exception.expect(InvalidExpressionException.class);
    exception.expectMessage("Invalid expression.");
    stdCalc.evaluate("3 ! 3");
  }
  
  @Test
  public void testUnbalancedInputs() throws InvalidExpressionException, 
      BadTypeException, EmptyStackException {
    exception.expect(InvalidExpressionException.class);
    exception.expectMessage("Unbalanced expression.");
    stdCalc.evaluate("3 + 5 -");
  }
  
  @Test
  public void testDivisionByZero() throws InvalidExpressionException, 
      BadTypeException, EmptyStackException {
    exception.expect(InvalidExpressionException.class);
    exception.expectMessage("Invalid division by zero.");
    stdCalc.evaluate("1 / 0");
  }
  
  @Test
  public void testAnswerOverflow() throws InvalidExpressionException, 
      BadTypeException, EmptyStackException {
    exception.expect(InvalidExpressionException.class);
    exception.expectMessage("Answer is too large.");
    stdCalc.evaluate("999999999 * 999999999 * 999999999 * 999999999 * 999999999");
  }
  
  @Test
  public void testInputOverflow() throws InvalidExpressionException, 
      BadTypeException, EmptyStackException {
    exception.expect(InvalidExpressionException.class);
    exception.expectMessage("Input value(s) are too large.");
    stdCalc.evaluate("999999999999 + 1");
  }
}