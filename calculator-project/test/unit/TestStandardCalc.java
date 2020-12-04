package unit;

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
 * Contains all JUnit 4 tests for testing the StandardCalc class.
 * @author Alex Cordaro ZDAC051
 */
public class TestStandardCalc {
  
  private StandardCalc stdCalc;
  
  /**
   * An object of the StandardCalc class is created, for use in testing the evaluate method.
   */
  @Before
  public void setUp() throws Exception {
    stdCalc = new StandardCalc();
  }
  
  /**
   * The evaluate method should be able to calculate the answer to infix expressions of any 
   * complexity, in this case basic.
   * @throws Exception when either the StrStack or OpStack objects are empty
   */
  @Test /*Test 37 - implemented the convertToPrefix() method which accepts a StrStack object 
  of infix expression tokens and turns them into a prefix string. Also implemented the evaluate 
  method to take an infix string, convert it to prefix, then used a RevPolishCalc object to 
  evaluate the answer.*/
  public void testEvaluateBasic() throws Exception {
    assertEquals(stdCalc.evaluate("3 + 5"), 8, 0.001);
  }
  
  /**
   * The evaluate method should be able to calculate the answer to infix expressions of any 
   * complexity, in this case intermediate.
   * @throws Exception when either the StrStack or OpStack objects are empty
   */
  @Test /*Test 38 - the evaluate method should be able to evaluate the infix expression example 
  found in the requirements document.*/
  public void testEvaluateIntermediate() throws Exception {
    assertEquals(stdCalc.evaluate("( 5 * ( 6 + 7 ) ) - 2"), 63, 0.001);
  }
  
  /**
   * The evaluate method should be able to calculate the answer to infix expressions of any 
   * complexity, in this case hard.
   * @throws Exception when either the StrStack or OpStack objects are empty
   */
  @Test /*Test 39 - the evaluate method should be able to handle a more complex expression 
  involving all four operations.*/
  public void testEvaluateHard() throws Exception {
    assertEquals(stdCalc.evaluate("( 2 + ( 3 + 5 ) * ( 4 + 8 ) / 2 ) / 20"), 2.5, 0.001);
  }
  
  @Rule //Used for exception testing
  public ExpectedException exception = ExpectedException.none();
  
  /**
   * The evaluate method should throw the exception InvalidExpressionException if invalid 
   * characters are present in the expression string, such as letters.
   * @throws InvalidExpressionException an invald character is found in the expression
   * @throws EmptyStackException either strStack or opStack are already empty
   * @throws BadTypeException the wrong getter for an Entry type is called
   */
  @Test /*Test 40 - implemented the InvalidExpressionException class into the evaluate() method, 
  so it is thrown when the given expression contains invalid characters, such as letters.*/
  public void testInvalidExpressionExceptionLetters() throws InvalidExpressionException, 
      BadTypeException, EmptyStackException {
    exception.expect(InvalidExpressionException.class);
    exception.expectMessage("Invalid expression.");
    stdCalc.evaluate("3 + a - 5");
  }
  
  /**
   * The evaluate method should throw the exception InvalidExpressionException if invalid 
   * characters are present in the expression string, such as punctuation.
   * @throws InvalidExpressionException an invald character is found in the expression
   * @throws EmptyStackException either strStack or opStack are already empty
   * @throws BadTypeException the wrong getter for an Entry type is called
   */
  @Test /*Test 41 - check that the InvalidExpressionException is also thrown for other incorrect
  characters such as punctuation.*/
  public void testInvalidExpressionExceptionPunctuation() throws InvalidExpressionException, 
      BadTypeException, EmptyStackException {
    exception.expect(InvalidExpressionException.class);
    exception.expectMessage("Invalid expression.");
    stdCalc.evaluate("3 ! 4 - 5");
  }
  
  /**
   * The evaluate method should throw the exception InvalidExpressionException if the postfix 
   * expression created from the infix expression is unbalanced, i.e. there are more operators 
   * than there should be.
   * @throws InvalidExpressionException the expression is unbalanced
   * @throws EmptyStackException either strStack or opStack are already empty
   * @throws BadTypeException the wrong getter for an Entry type is called
   */
  @Test /*Test 43 - ensuring that unbalanced expressions returned by convertToPostfix will throw 
  an InvalidExpressionException when passed to the RevPolishCalc object*/
  public void testInvalidExpressionExceptionUnbalanced() throws InvalidExpressionException, 
      BadTypeException, EmptyStackException {
    exception.expect(InvalidExpressionException.class);
    exception.expectMessage("Unbalanced expression.");
    stdCalc.evaluate("( 5 + 3 ) + 2 -");
  }
  
  /**
   * The evaluate method throw an InvalidExpressionException if a division by zero occurs 
   * in the expression, indivicated by the final answer being infinity.
   * @throws InvalidExpressionException division by zero occured
   * @throws BadTypeException the wrong getter for an Entry type is called
   * @throws EmptyStackException either strStack or opStack are already empty
   */
  @Test /*Test 44 - implemented another exception throw when a divsion by zero is discovered 
  in the expression.*/
  public void testDivisionByZero() throws InvalidExpressionException, 
      BadTypeException, EmptyStackException { 
    exception.expect(InvalidExpressionException.class);
    exception.expectMessage("Invalid division by zero.");
    stdCalc.evaluate("1 / 0");
  }
  
  /**
   * The evaluate method throws an InvalidExpressionException if the answer to the expression
   * ends up being too large to be represented by a float.
   * @throws InvalidExpressionException the answer is too large for a float
   * @throws BadTypeException the wrong getter for an Entry type is called
   * @throws EmptyStackException either strStack or opStack are already empty
   */
  @Test /*Test 45 - implemented another exception throw when the final is too large to be 
  represented by a float.*/
  public void testAnswerArithmeticOverflow() throws InvalidExpressionException, 
      BadTypeException, EmptyStackException { 
    exception.expect(InvalidExpressionException.class);
    exception.expectMessage("Answer is too large.");
    stdCalc.evaluate("999999999 * 999999999 * 999999999 * 999999999 * 999999999");
  }
  
  /**
   * The evaluate method throws an InvalidExpressionException if the user enters a value 
   * that is too large to be parsed into an integer.
   * @throws InvalidExpressionException user input value(s) are too big for an int
   * @throws BadTypeException the wrong getter for an Entry type is called
   * @throws EmptyStackException either strStack or opStack are already empty
   */
  @Test /*Test 46 - implemented another exception throw when the user inputs a number too 
  large to be parsed into an int.*/
  public void testInputArithmeticOverflow() throws InvalidExpressionException, 
      BadTypeException, EmptyStackException { 
    exception.expect(InvalidExpressionException.class);
    exception.expectMessage("Input value(s) are too large.");
    stdCalc.evaluate("999999999999 + 1");
  }
}
