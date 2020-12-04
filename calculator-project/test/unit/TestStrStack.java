package unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import calc.model.BadTypeException;
import calc.model.EmptyStackException;
import calc.model.StrStack;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Contains all JUnit 4 tests for testing the StrStack class. 
 * @author Alex Cordaro ZDAC051    
 */
public class TestStrStack {
  
  private StrStack strStackTest;
  
  /**
   * An object of the StrStack class is created, for use in testing the class methods.
   */
  @Before //Object created of the StrStack class
  public void setUp() {
    strStackTest = new StrStack();
  }
  
  /**
   * The isEmpty() method should return true, as a newly created object of StrStack should have 
   * zero entries in it's stack.
   */
  @Test /*Test 26 - implemented isEmpty() method to StrStack class. Refactored isEmpty() to now 
  call the size() method of the Stack object in StrStack to determine if it is empty, rather than 
  always returning true.*/
  public void testIsEmpty() {
    assertTrue("StrStack object should be empty after creation", strStackTest.isEmpty());
  }
  
  /**
   * The push() method simply calls the Stack object's push() method to add a string entry onto
   * the stack.
   */
  @Test /*Test 27 - implemented push() method to OpStack class.*/
  public void testPush() {
    strStackTest.push("3 * 5");
    assertFalse("StrStack object shouldn't be empty after pushing first entry onto it", 
        strStackTest.isEmpty());
    strStackTest.push("5 - 3");
    assertFalse("StrStack object shouldn't be empty after pushing second entry onto it", 
        strStackTest.isEmpty());
    strStackTest.push("6 / 2");
    assertFalse("StrStack object shouldn't be empty after pushing third entry onto it", 
        strStackTest.isEmpty());
  }
  
  /**
   * The pop() method calls the Stack object's pop() method to remove the top 
   * entry from the stack, and return it's string value.
   * @throws Exception when the stack is empty
   */
  @Test /*Test 28 - implemented pop() method to StrStack class. Refactored this method to a singe 
  line return statement.*/
  public void testPop() throws Exception {
    strStackTest.push("3 * 5");
    assertEquals("The pop() method should return \"3 * 5\"", strStackTest.pop(), "3 * 5");
    assertTrue("The stack should be empty after popping the only entry", strStackTest.isEmpty());
  }
  
  @Rule //Used for exception testing
  public ExpectedException exception = ExpectedException.none();
  
  /**
   * EmptyStackException should be thrown when the pop() method in the StrStack class is 
   * called, and the stack is currently empty.
   * @throws BadTypeException when the top entry is not of string type
   * @throws EmptyStackException when the stack is empty, thus no element can be popped
   */
  @Test /*Test 29 - the pop() method now throws the EmptyStackException if it is called when 
  the stack size is currently 0.*/
  public void testPopEmptyStackException() throws EmptyStackException, BadTypeException {
    exception.expect(EmptyStackException.class);
    exception.expectMessage("The stack is empty. No element can be removed.");
    strStackTest.pop();
  }
}
