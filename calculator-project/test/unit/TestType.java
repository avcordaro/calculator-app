package unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import calc.model.Type;

import org.junit.Test;

/**
 * Contains all JUnit 4 tests for testing Enum Type. 
 * @author Alex Cordaro ZDAC051
 */
public class TestType {
  
  /**
   * Enum Type should contain the following list of constants: 
   * Number, Symbol, String and Invalid.
   */
  @Test //Test 1 - declared the set of constants for enum Type
  public void testConstantsDeclared() {
    assertNotNull("Check NUMBER is declared", Type.valueOf("NUMBER"));
    assertNotNull("Check SYMBOL is declared", Type.valueOf("SYMBOL"));
    assertNotNull("Check STRING is declared", Type.valueOf("STRING"));
    assertNotNull("Check INVALID is declared", Type.valueOf("INVALID"));
  }
  
  /**
   * The toString() method in Enum Type should be overriden with a new method 
   * that returns a more readable format of a constant's name.
   */
  @Test /*Test 2 - overridden toString() method for enum Type. Refactored to a single line return 
  statement when formatting name to lowercase letters*/
  public void testToStringOverridden() {
    assertEquals("Calling toString() for NUMBER", "Number", Type.NUMBER.toString());
    assertEquals("Calling toString() for SYMBOL", "Symbol", Type.SYMBOL.toString());
    assertEquals("Calling toString() for STRING", "String", Type.STRING.toString());
    assertEquals("Calling toString() for INVALID", "Invalid", Type.INVALID.toString());
  }
  
}