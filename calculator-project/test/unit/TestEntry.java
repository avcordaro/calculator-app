package unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import calc.model.BadTypeException;
import calc.model.Entry;
import calc.model.Symbol;
import calc.model.Type;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Contains all JUnit 4 tests for testing the Entry class. 
 * @author Alex Cordaro ZDAC051    
 */
public class TestEntry {
  
  private Entry entryNumber;
  private Entry entrySymbol;
  private Entry entryString;
  
  /**
   * Objects are created from the different consturctor methods in the Entry class, to be used 
   * for testing class methods.
   */
  @Before //Object creations from the Entry class for use in later tests
  public void setUp() {
    entryNumber = new Entry(15);
    entrySymbol = new Entry(Symbol.PLUS);
    entryString = new Entry("3 * 5");
  }
  
  /**
   * Using entryNumber created in setUp(), calling the getValue() method should return 
   * the correct value of 15.
   * @throws Exception when an Entry calls the wrong getter method for it's type.
   */
  @Test //Test 5 - implemented constructor and getter method for numeric Entry objects
  public void testGetValue() throws Exception {
    assertEquals("Calling getValue() for numeric Entry 15", 15, entryNumber.getValue(), 0.001);
  }  
  
  /**
   * Using entrySymbol created in setUp(), calling the getSymbol() method should return 
   * the correct symbol PLUS.
   * @throws Exception when an Entry calls the wrong getter method for it's type.
   */
  @Test //Test 6 - implemented constructor and getter method for symbol Entry objects
  public void testGetSymbol() throws Exception {
    assertEquals("Calling getSymbol() for symbol Entry PLUS", Symbol.PLUS, entrySymbol.getSymbol());
  }  
  
  /**
   * Using entryString created in setUp(), calling the getString() method should return 
   * the correct string "3 * 5".
   * @throws Exception when an Entry calls the wrong getter method for it's type.
   */
  @Test //Test 7 - implemented constructor and getter method for string Entry objects
  public void testGetString() throws Exception {
    assertEquals("Calling getString() for string Entry 3 * 5", "3 * 5", entryString.getString());
  }  
  
  /**
   * Using the Entry objects created in setUp(), calling getType() should return the correct type
   * for the value they hold.
   */
  @Test //Test 8 - implemented type assignment in constructors and getType() method
  public void testGetType() {
    assertEquals("Calling getType() for numeric Entry 15", Type.NUMBER, entryNumber.getType());
    assertEquals("Calling getType() for symbol Entry PLUS", Type.SYMBOL, entrySymbol.getType());
    assertEquals("Calling getType() for string Entry 3 * 5", Type.STRING, entryString.getType());
  }
  
  /**
   * Declares an ExpectedException variable, to be used for testing expected exception throws.
   */
  @Rule //Used for exception testing
  public ExpectedException exception = ExpectedException.none();
  
  /**
   * BadTypeException should be thrown when an Entry calls a getter method that does not 
   * match its type. For example, when an Entry of type symbol calls getString(). 
   * This test will pass if the exception is correctly thrown.
   * @throws BadTypeException when an incorrect getter method is called
   */
  @Test /*Test 9 - created BadTypeException class. Getter methods now throw this exception 
  when called by an incorrect Entry type*/
  public void testValueGettersBadTypeException() throws BadTypeException {
    //calling getValue() from an entry object that is not of type number
    exception.expect(BadTypeException.class);
    exception.expectMessage("This entry type is not numeric.");
    entryString.getValue();
  }
  
  /**
   * Two Entry objects should be considered equal is they have the same type, and their 
   * type values are equal. Their hashCode() method should also return the same value.
   */
  @Test /*Test 16 - overidden equals() and hashCode() method for Entry class. Refactored a 
  series of multiple if statements into one switch statement.*/
  public void testEquals() {
    //Testing string entries
    Entry string1 = new Entry("abc");
    Entry string2 = new Entry("abc");
    assertTrue("Comparing two Entry objects with same string value", string1.equals(string2));
    assertTrue("Comparing two Entry object hashcodes with same string value", 
        string1.hashCode() == string2.hashCode());
    
    //Testing number entries
    Entry number1 = new Entry(123);
    Entry number2 = new Entry(123);
    assertTrue("Comparing two Entry objects with same numeric value", number1.equals(number2));
    assertTrue("Comparing two Entry object hashcodes with same numeric value", 
        number1.hashCode() == number2.hashCode());
    
    //Testing symbol entries
    Entry symbol1 = new Entry(Symbol.PLUS);
    Entry symbol2 = new Entry(Symbol.PLUS);
    assertTrue("Comparing two Entry objects with same symbol", symbol1.equals(symbol2));
    assertTrue("Comparing hashcode of two Entry object with same symbol", 
        symbol1.hashCode() == symbol2.hashCode());
  }
  
  /**
   * Further to testEquals(), an Entry object should be equal to itself. 
   * The equals() method should immediately return false if the object 
   * argument given is not an Entry object, or is null.
   */
  @Test //Test 17 - implemented additional logic statements to the beginning of the equals() method
  @SuppressWarnings("unlikely-arg-type")
  public void testEqualsAdditionalConditions() {
    Entry entry = new Entry("foo");
    Entry entryNull = null;
    
    //Comparing an entry to itself
    assertTrue("Comparing Entry object to itself", entry.equals(entry));
    assertTrue("Comparing Entry object hashcode to itself", entry.hashCode() == entry.hashCode());
    
    //Comparing to a null object
    assertFalse("Comparing Entry object to a null argument", entry.equals(entryNull));
    
    String string = "abc";
    
    //Comparing to a non-entry object
    assertFalse("Comparing Entry object to a String object", entry.equals(string));
    assertFalse("Comparing hashcodes of an Entry object and a String object", 
        entry.hashCode() == string.hashCode());
  }
  
}