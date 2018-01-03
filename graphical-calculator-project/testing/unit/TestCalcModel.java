package unit;

import static org.junit.Assert.assertEquals;

import calc.model.BadTypeException;
import calc.model.CalcModel;
import calc.model.EmptyStackException;
import calc.model.InvalidExpressionException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Contains all JUnit 4 tests for testing the CalcModel class.
 * @author Alex Cordaro ZDAC051
 */
public class TestCalcModel {
  
  private CalcModel cm;
  
  @Rule //used for exception testing
  public ExpectedException exception = ExpectedException.none();
  
  /**
   * An object of the CalcModel class is created, for use in testing the evaluate method.
   */
  @Before
  public void setUp() throws Exception {
    cm = new CalcModel();
  }
  
  /**
   * An infix expression should return a correct answer when the calculator type is set 
   * to infix, and return an error message when the type is set to prefix.
   * @throws InvalidExpressionException an invald character is found in the expression
   * @throws EmptyStackException either strStack or opStack are already empty
   * @throws BadTypeException the wrong getter for an Entry type is called
   */
  @Test /*Test 47 - implemented three field variables to the CalcModel class, where the field 
  current is set to the current type of calculator being used*/
  public void testSwitchInfixToPrefix() throws InvalidExpressionException, 
      BadTypeException, EmptyStackException {
    cm.current = cm.stdCalc;
    assertEquals("Evaluating infix string on infix calculator", cm.evaluate("1 + 1"), 2, 0.001);
    cm.current = cm.rvpCalc;
    exception.expect(InvalidExpressionException.class);
    exception.expectMessage("Unbalanced expression.");
    assertEquals("Evaluating infix string on prefix calculator", cm.evaluate("1 + 1"), 2, 0.001);
  }
  
  /**
   * A prefix expresison should return a correct answer when the calculator type is set
   * to prefix, and return an error message when the type is set to infix.
   * @throws InvalidExpressionException an invald character is found in the expression
   * @throws EmptyStackException either strStack or opStack are already empty
   * @throws BadTypeException the wrong getter for an Entry type is called
   */
  @Test /*Test 48 - discovered that 1 1 + is incorrectly evaluated to 2 when using infix 
  calculator. Implemented new exception throw when an infix expression has two consecutive 
  digits parsed, indicating that it is unbalanced.*/
  public void testSwitchPrefixToInfix() throws InvalidExpressionException, 
      BadTypeException, EmptyStackException {
    cm.current = cm.rvpCalc;
    assertEquals("Evaluating prefix string on prefix calculator", cm.evaluate("1 1 +"), 2, 0.001);
    cm.current = cm.stdCalc;
    exception.expect(InvalidExpressionException.class);
    exception.expectMessage("Unbalanced expression.");
    assertEquals("Evaluating infix string on prefix calculator", cm.evaluate("1 1 +"), 2, 0.001);
  }

}
