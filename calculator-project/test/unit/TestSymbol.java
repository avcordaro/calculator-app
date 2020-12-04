package unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import calc.model.Symbol;

import org.junit.Test;

/**
 * Contains all JUnit 4 tests for testing Enum Symbol. 
 * @author Alex Cordaro ZDAC051    
 */
public class TestSymbol {
  
  /**
   * Enum Symbol should contain the following list of constants:
   * Left bracket, right bracket, times, divide, plus, minus and invalid.
   */
  @Test //Test 3 - declared the set of constants for enum Symbol
  public void testConstantsDeclared() {
    assertNotNull("Check LEFT_BRACKET is declared", Symbol.valueOf("LEFT_BRACKET"));
    assertNotNull("Check RIGHT_BRACKET is declared", Symbol.valueOf("RIGHT_BRACKET"));
    assertNotNull("Check TIMES is declared", Symbol.valueOf("TIMES"));
    assertNotNull("Check DIVIDE is declared", Symbol.valueOf("DIVIDE"));
    assertNotNull("Check PLUS is declared", Symbol.valueOf("PLUS"));
    assertNotNull("Check MINUS is declared", Symbol.valueOf("MINUS"));
    assertNotNull("Check INVALID is declared", Symbol.valueOf("INVALID"));
  }
  
  /**
   * The toString() method in Enum Symbol should be overriden with a new method 
   * that returns the symbol character, represented by the constant.
   */
  @Test //Test 4 - overridden toString() method for enum Symbol
  public void testToStringOverridden() {
    assertEquals("Calling toString() for LEFT_BRACKET", "(", 
        Symbol.LEFT_BRACKET.toString());
    assertEquals("Calling toString() for RIGHT_BRACKET", ")", 
        Symbol.RIGHT_BRACKET.toString());
    assertEquals("Calling toString() for TIMES", "*", Symbol.TIMES.toString());
    assertEquals("Calling toString() for DIVIDE", "/", Symbol.DIVIDE.toString());
    assertEquals("Calling toString() for PLUS", "+", Symbol.PLUS.toString());
    assertEquals("Calling toString() for MINUS", "-", Symbol.MINUS.toString());
    assertEquals("Calling toString() for INVALID", " ", Symbol.INVALID.toString());
  }
  
  /**
   * The StandardCalc class uses the shunting algorithm to convert an infix string to postfix. 
   * This algorithm requires knowing the precedence level of a maths operator, i.e. the 
   * correct order to perform operations with respect to BODMAS. The getPrecedence() method 
   * in Symbol returns an int value indicating the precedence level (higher is greater).
   */
  @Test /*Test 35 - the shunting algorithm used by StandardCalc needs to know the precedence
  level of operator symbols. Implemented a new int field called precedence, with a getter.*/
  public void testGetPrecedence() {
    assertEquals("Calling getPrecedence() for LEFT_BRACKET", 0, 
        Symbol.LEFT_BRACKET.getPrecedence());
    assertEquals("Calling getPrecedence() for RIGHT_BRACKET", 0, 
        Symbol.RIGHT_BRACKET.getPrecedence());
    assertEquals("Calling getPrecedence() for TIMES", 3, Symbol.TIMES.getPrecedence());
    assertEquals("Calling getPrecedence() for DIVIDE", 4, Symbol.DIVIDE.getPrecedence());
    assertEquals("Calling getPrecedence() for PLUS", 2, Symbol.PLUS.getPrecedence());
    assertEquals("Calling getPrecedence() for MINUS", 1, Symbol.MINUS.getPrecedence());
    assertEquals("Calling getPrecedence() for INVALID", 0, Symbol.INVALID.getPrecedence());
    
  }
  
}