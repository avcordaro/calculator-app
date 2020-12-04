package acceptance;

import static org.junit.Assert.assertEquals;

import calc.model.BadTypeException;
import calc.model.CalcModel;
import calc.model.EmptyStackException;
import calc.model.InvalidExpressionException;

import org.junit.Before;
import org.junit.Test;

/**
 * Acceptance test updated for release_v1.1_infix_calculator, to satisfy the following quote from 
 * requirements: "People don’t want to press buttons on the new calculator - except to get 
 * the answer. They just want to type out an expression and see the answer". This test 
 * will prove that entering an input will return an answer with one call.
 * @author Alex Cordaro ZDAC051
 */
public class TestAnswerResponse {

  private CalcModel calcModel;
  
  @Before
  public void setUp() throws Exception {
    calcModel = new CalcModel();
  }

  @Test
  public void testResponse() throws InvalidExpressionException, 
        BadTypeException, EmptyStackException {
    assertEquals(calcModel.evaluate("5"), 5, 0.001);
  }
}
