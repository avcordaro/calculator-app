package regression;

import static org.junit.Assert.assertEquals;

import calc.model.InvalidExpressionException;
import calc.model.RevPolishCalc;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Regression test to ensure RevPolishCalc functions correctly after system modifications.
 * @author Alex Cordaro ZDAC051
 */
public class TestRevPolishCalc {
  
  private RevPolishCalc rvpCalc;

  @Before
  public void setUp() throws Exception {
    rvpCalc = new RevPolishCalc();
  }
  
  @Test
  public void testEvaluateBasic() throws Exception {
    assertEquals("Evaluating 3 5 +", 8, rvpCalc.evaluate("3 5 +"), 0.001);
  }

  @Test
  public void testEvaluateIntermediate() throws Exception {
    assertEquals("Evaluating 5 6 7 + * 2 -", 63, rvpCalc.evaluate("5 6 7 + * 2 -"), 0.001);
  }
  
  @Test
  public void testEvaluateHard() throws Exception {
    assertEquals("Evaluating 8000 60 7 8 * - 4 + 1000 * /", 1, 
        rvpCalc.evaluate("8000 60 7 8 * - 4 + 1000 * /"), 0.001);
  }
  
  @Rule
  public ExpectedException exception = ExpectedException.none();
  
  @Test
  public void testInvalidExpressionExceptionLetters() throws InvalidExpressionException {
    exception.expect(InvalidExpressionException.class);
    exception.expectMessage("Invalid expression.");
    rvpCalc.evaluate("3 5 abc +");
  }

  @Test
  public void testInvalidExpressionExceptionPunctuation() throws InvalidExpressionException {
    exception.expect(InvalidExpressionException.class);
    exception.expectMessage("Invalid expression.");
    rvpCalc.evaluate("3 5 ! +");
  }
  
  @Test
  public void testInvalidExpressionExceptionUnbalanced() throws InvalidExpressionException {
    exception.expect(InvalidExpressionException.class);
    exception.expectMessage("Unbalanced expression.");
    rvpCalc.evaluate("4 5 6 + + -");
  }
}
