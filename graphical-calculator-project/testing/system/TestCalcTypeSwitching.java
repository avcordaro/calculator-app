package system;

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
 * System test for release_v1.2_prefix_calculator, to show that the calculator can switch types 
 * between infix and prefix when evaluating expressions. Expressions of the opposite type to 
 * the current calculator will be detected and throw error messages.
 * @author Alex Cordaro ZDAC051
 */
public class TestCalcTypeSwitching {
  
  private CalcModel cm;
  
  @Rule
  public ExpectedException exception = ExpectedException.none();

  @Before
  public void setUp() throws Exception {
    cm = new CalcModel();
  }

  @Test
  public void testSwitchInfixToPrefix() throws InvalidExpressionException, 
      BadTypeException, EmptyStackException {
    cm.current = cm.stdCalc;
    assertEquals("Evaluating infix string on infix calculator", cm.evaluate("1 + 1"), 2, 0.001);
    cm.current = cm.rvpCalc;
    exception.expect(InvalidExpressionException.class);
    exception.expectMessage("Unbalanced expression.");
    assertEquals("Evaluating infix string on prefix calculator", cm.evaluate("1 + 1"), 2, 0.001);
  }
  
  @Test
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
