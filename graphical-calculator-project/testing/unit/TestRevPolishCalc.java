package unit;

import static org.junit.Assert.assertEquals;

import calc.model.InvalidExpressionException;
import calc.model.RevPolishCalc;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Contains all JUnit 4 tests for testing the RevPolishCalc class.
 * @author Alex Cordaro ZDAC051
 */
public class TestRevPolishCalc {
  
  private RevPolishCalc rvpCalc;
  
  /**
   * An object of the RevPolishCalc class is created, for use in testing the evaluate method.
   */
  @Before
  public void setUp() throws Exception {
    rvpCalc = new RevPolishCalc();
  }
  
  /**
   * The evaluate method should be able to calculate the answer to prefix expressions of any 
   * complexity, in this case basic.
   * @throws Exception when the TreeNode stack used is empty
   */
  @Test /*Test 30 - created method buildTree() which takes an array of prefix expression tokens 
  and turns it into a binary tree, returning the root TreeNode. Also implemented the evaluate() 
  method to split the expression string into tokens, calling buildTree() then passing the root 
  TreeNode to a SumVisitor to get and return the answer.*/
  public void testEvaluateBasic() throws Exception {
    assertEquals("Evaluating 3 5 +", 8, rvpCalc.evaluate("3 5 +"), 0.001);
  }

  /**
   * The evaluate method should be able to calculate the answer to prefix expressions of any 
   * complexity, in this case intermediate.
   * @throws Exception  when the TreeNode stack used is empty
   */
  @Test /*Test 31 - the evaluate method should be able to evaluate the postfix expression example 
  found in the requirements document.*/
  public void testEvaluateIntermediate() throws Exception {
    assertEquals("Evaluating 5 6 7 + * 2 -", 63, rvpCalc.evaluate("5 6 7 + * 2 -"), 0.001);
  }
  
  /**
   * The evaluate method should be able to calculate the answer to prefix expressions of any 
   * complexity, in this case hard.
   * @throws Exception when the TreeNode stack used is empty
   */
  @Test /*Test 32 - the evaluate method should be able to handle a more complex expression 
  involving all four operations. Refactored the buildTree() to use a for each loop when iterating 
  through the expression tokens.*/
  public void testEvaluateHard() throws Exception {
    assertEquals("Evaluating 8000 60 7 8 * - 4 + 1000 * /", 1, 
        rvpCalc.evaluate("8000 60 7 8 * - 4 + 1000 * /"), 0.001);
  }
  
  @Rule //Used for exception testing
  public ExpectedException exception = ExpectedException.none();
  
  /**
   * The evaluate method should throw the exception InvalidExpressionException if invalid 
   * characters are present in the expression string, such as letters.
   * @throws InvalidExpressionException an invald character is found in the expression
   */
  @Test /*Test 33 - implemented the InvalidExpressionException class into the evaluate() method, 
  so it is thrown when the given expression contains invalid characters, such as letters.*/
  public void testInvalidExpressionExceptionLetters() throws InvalidExpressionException {
    exception.expect(InvalidExpressionException.class);
    exception.expectMessage("Invalid expression.");
    rvpCalc.evaluate("3 5 abc +");
  }
  
  /**
   * The evaluate method should throw the exception InvalidExpressionException if invalid 
   * characters are present in the expression string, such as punctuation.
   * @throws InvalidExpressionException an invald character is found in the expression
   */
  @Test /*Test 34 - check that the InvalidExpressionException is also thrown for other incorrect
  characters such as punctuation.*/
  public void testInvalidExpressionExceptionPunctuation() throws InvalidExpressionException {
    exception.expect(InvalidExpressionException.class);
    exception.expectMessage("Invalid expression.");
    rvpCalc.evaluate("3 5 ! +");
  }
  
  /**
   * The evaluate method should throw the exception InvalidExpressionException if a postfix 
   * expression is unbalanced, i.e. there are more operators than there should be.
   * @throws InvalidExpressionException the expression is unbalanced
   */
  @Test /*Test 42 - implemented another InvalidExpressionException throw when a postfix 
  expression is unbalanced*/
  public void testInvalidExpressionExceptionUnbalanced() throws InvalidExpressionException {
    exception.expect(InvalidExpressionException.class);
    exception.expectMessage("Unbalanced expression.");
    rvpCalc.evaluate("4 5 6 + + -");
  }
}
