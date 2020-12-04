package system;

import static org.junit.Assert.assertEquals;

import calc.model.BadTypeException;
import calc.model.EmptyStackException;
import calc.model.InvalidExpressionException;
import calc.model.RevPolishCalc;

import org.junit.Before;
import org.junit.Test;

/**
 * System test for release_v1.2_prefix_calculator, to show that the calculator can evaluate 
 * prefix expressions of varying complexity.
 * @author Alex Cordaro ZDAC051
 */
public class TestPrefixEvaluations {
  
  private RevPolishCalc rvpCalc;

  @Before
  public void setUp() throws Exception {
    rvpCalc = new RevPolishCalc();
  }

  @Test
  public void testPlusExpressions() throws InvalidExpressionException, 
      BadTypeException, EmptyStackException {
    assertEquals("evaluating 1 1 +", rvpCalc.evaluate("1 1 +"), 2, 0.001);
    assertEquals("evaluating 11 36 +", rvpCalc.evaluate("11 36 +"), 47, 0.001);
    assertEquals("evaluating 5678 6768 +", rvpCalc.evaluate("5678 6768 +"), 12446, 0.001);
  }
  
  @Test
  public void testMinusExpressions() throws InvalidExpressionException, 
      BadTypeException, EmptyStackException {
    assertEquals("evaluating 2 1 -", rvpCalc.evaluate("2 1 -"), 1, 0.001);
    assertEquals("evaluating 54 39 -", rvpCalc.evaluate("54 39 -"), 15, 0.001);
    assertEquals("evaluating 9760 7211 -", rvpCalc.evaluate("9760 7211 -"), 2549, 0.001);
  }
  
  @Test
  public void testTimesExpressions() throws InvalidExpressionException, 
      BadTypeException, EmptyStackException {
    assertEquals("evaluating 2 2 *", rvpCalc.evaluate("2 2 *"), 4, 0.001);
    assertEquals("evaluating 9 32 *", rvpCalc.evaluate("9 32 *"), 288, 0.001);
    assertEquals("evaluating 3124 765 *", rvpCalc.evaluate("3124 756 *"), 2361744, 0.001);
  }
  
  @Test
  public void testDivideExpressions() throws InvalidExpressionException, 
      BadTypeException, EmptyStackException {
    assertEquals("evaluating 3 3 /", rvpCalc.evaluate("3 3 /"), 1, 0.0000001);
    assertEquals("evaluating 60 42 /", rvpCalc.evaluate("60 42 /"), 1.42857143, 0.0000001);
    assertEquals("evaluating 2963 943 /", rvpCalc.evaluate("2963 943 /"), 3.14209968, 0.000001);
  }
  
  @Test
  public void testBracketedExpressions() throws InvalidExpressionException, 
      BadTypeException, EmptyStackException {
    assertEquals("evaluating 8 4 + 6 -", rvpCalc.evaluate("8 4 + 6 -"), 6, 0.001);
    assertEquals("evaluating 6 7 + 5 * 2 -", 
        rvpCalc.evaluate("6 7 + 5 * 2 -"), 63, 0.001);
    assertEquals("evaluating 6 7 + 30 25 - - 2 2 * -",
        rvpCalc.evaluate("6 7 + 30 25 - - 2 2 * -"), 4, 0.001);
  }
}