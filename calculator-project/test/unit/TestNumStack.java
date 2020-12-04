package unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import calc.model.BadTypeException;
import calc.model.EmptyStackException;
import calc.model.NumStack;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Contains all JUnit 4 tests for testing the NumStack class. 
 * @author Alex Cordaro ZDAC051    
 */
public class TestNumStack {
  
  private NumStack numStackTest;
  
  /**
   * An object of the NumStack class is created, for use in testing the class methods.
   */
  @Before //Object created of the NumStack class
  public void setUp() {
    numStackTest = new NumStack();
  }
  
  /**
   * The isEmpty() method should return true, as a newly created object of NumStack should have 
   * zero entries in it's stack.
   */
  @Test /*Test 18 - implemented isEmpty() method to NumStack class. Refactored isEmpty() to now 
  call the size() method of the Stack object in NumStack to determine if it is empty, rather than 
  always returning true.*/
  public void testIsEmpty() {
    assertTrue("NumStack object should be empty after creation", numStackTest.isEmpty());
  }
  
  /**
   * The push() method simply calls the Stack object's push() method to add a numeric entry onto
   * the stack.
   */
  @Test /*Test 19 - implemented push() method to NumStack class.*/
  public void testPush() {
    numStackTest.push(5);
    assertFalse("NumStack object shouldn't be empty after pushing first entry onto it", 
        numStackTest.isEmpty());
    numStackTest.push(10);
    assertFalse("NumStack object shouldn't be empty after pushing second entry onto it", 
        numStackTest.isEmpty());
    numStackTest.push(15);
    assertFalse("NumStack object shouldn't be empty after pushing third entry onto it", 
        numStackTest.isEmpty());
  }
  
  /**
   * The pop() method calls the Stack object's pop() method to remove the top 
   * entry from the stack, and return it's numeric value.
   * @throws Exception when the stack is empty
   */
  @Test /*Test 20 - implemented pop() method to NumStack class. Refactored this method to a singe 
  line return statement.*/
  public void testPop() throws Exception {
    numStackTest.push(5);
    assertEquals("The pop() method should return 5", numStackTest.pop(), 5, 0.001);
    assertTrue("The stack should be empty after popping the only entry", numStackTest.isEmpty());
  }
  
  @Rule //Used for exception testing
  public ExpectedException exception = ExpectedException.none();
  
  /**
   * EmptyStackException should be thrown when the pop() method in the NumStack class is 
   * called, and the stack is currently empty.
   * @throws BadTypeException when the top entry is not of numeric type
   * @throws EmptyStackException when the stack is empty, thus no element can be popped
   */
  @Test /*Test 21 - the pop() method now throws the EmptyStackException if it is called when 
  the stack size is currently 0.*/
  public void testPopEmptyStackException() throws EmptyStackException, BadTypeException {
    exception.expect(EmptyStackException.class);
    exception.expectMessage("The stack is empty. No element can be removed.");
    numStackTest.pop();
  }
}
