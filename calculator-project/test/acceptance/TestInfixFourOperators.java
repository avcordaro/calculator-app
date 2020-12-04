package acceptance;

import static org.junit.Assert.assertEquals;

import calc.model.BadTypeException;
import calc.model.EmptyStackException;
import calc.model.InvalidExpressionException;
import calc.model.StandardCalc;

import org.junit.Before;
import org.junit.Test;

/**
 * Acceptance test for release_v1.1_infix_calculator, to satisfy the following quote from 
 * requirements: "Initially at least you will only have to deal with whole numbers and 
 * +,*,- and /. The answers should be as accurate as you can get them". This test will 
 * prove that infix expressions including all four operators and whole numbers can be 
 * correctly evaluated.
 * @author Alex Cordaro ZDAC051
 */
public class TestInfixFourOperators {
  
  private StandardCalc stdCalc;

  @Before
  public void setUp() throws Exception {
    stdCalc = new StandardCalc();
  }

  @Test
  public void testPlusExpressions() throws InvalidExpressionException, 
      BadTypeException, EmptyStackException {
    assertEquals("evaluating 1 + 1", stdCalc.evaluate("1 + 1"), 2, 0.001);
    assertEquals("evaluating 11 + 36", stdCalc.evaluate("11 + 36"), 47, 0.001);
    assertEquals("evaluating 5678 + 6768", stdCalc.evaluate("5678 + 6768"), 12446, 0.001);
  }
  
  @Test
  public void testMinusExpressions() throws InvalidExpressionException, 
      BadTypeException, EmptyStackException {
    assertEquals("evaluating 2 - 1", stdCalc.evaluate("2 - 1"), 1, 0.001);
    assertEquals("evaluating 54 - 39", stdCalc.evaluate("54 - 39"), 15, 0.001);
    assertEquals("evaluating 9760 - 7211", stdCalc.evaluate("9760 - 7211"), 2549, 0.001);
  }
  
  @Test
  public void testTimesExpressions() throws InvalidExpressionException, 
      BadTypeException, EmptyStackException {
    assertEquals("evaluating 2 * 2", stdCalc.evaluate("2 * 2"), 4, 0.001);
    assertEquals("evaluating 9 * 32", stdCalc.evaluate("9 * 32"), 288, 0.001);
    assertEquals("evaluating 3124 * 765", stdCalc.evaluate("3124 * 756"), 2361744, 0.001);
  }
  
  @Test
  public void testDivideExpressions() throws InvalidExpressionException, 
      BadTypeException, EmptyStackException {
    assertEquals("evaluating 3 / 3", stdCalc.evaluate("3 / 3"), 1, 0.0000001);
    assertEquals("evaluating 60 / 42", stdCalc.evaluate("60 / 42"), 1.42857143, 0.0000001);
    assertEquals("evaluating 2963 / 943", stdCalc.evaluate("2963 / 943"), 3.14209968, 0.000001);
  }
  
  @Test
  public void testBracketedExpressions() throws InvalidExpressionException, 
      BadTypeException, EmptyStackException {
    assertEquals("evaluating ( 8 + 4 ) - 6", stdCalc.evaluate("( 8 + 4 ) - 6"), 6, 0.001);
    assertEquals("evaluating ( 5 * ( 6 + 7 ) ) - 2", 
        stdCalc.evaluate("( 5 * ( 6 + 7 ) ) - 2"), 63, 0.001);
    assertEquals("evaluating ( 6 + 7 ) - ( 30 - 25 ) - ( 2 * 2 )", 
        stdCalc.evaluate("( 6 + 7 ) - ( 30 - 25 ) - ( 2 * 2 )"), 4, 0.001);
  }
  
  @Test 
  public void testCorrectPrecedence() throws InvalidExpressionException, 
      BadTypeException, EmptyStackException {
    assertEquals("evaluating 30 - 6 + 7 * 12 / 6", 
        stdCalc.evaluate("30 - 6 + 7 * 12 / 6"), 10, 0.001);
    assertEquals("evaluating ( 30 - 6 + 7 ) * ( 7 + 8 - 2 ) + ( 6 / 2 )", 
        stdCalc.evaluate("( 30 - 6 + 7 ) * ( 7 + 8 - 2 ) + ( 6 / 2 )"), 224, 0.001);
  }
}