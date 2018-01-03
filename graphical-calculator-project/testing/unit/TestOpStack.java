package unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import calc.model.BadTypeException;
import calc.model.EmptyStackException;
import calc.model.OpStack;
import calc.model.Symbol;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Contains all JUnit 4 tests for testing the OpStack class. 
 * @author Alex Cordaro ZDAC051    
 */
public class TestOpStack {
  
  private OpStack opStackTest;
  
  /**
   * An object of the OpStack class is created, for use in testing the class methods.
   */
  @Before //Object created of the OpStack class
  public void setUp() {
    opStackTest = new OpStack();
  }
  
  /**
   * The isEmpty() method should return true, as a newly created object of OpStack should have 
   * zero entries in it's stack.
   */
  @Test /*Test 22 - implemented isEmpty() method to OpStack class. Refactored isEmpty() to now 
  call the size() method of the Stack object in OpStack to determine if it is empty, rather than 
  always returning true.*/
  public void testIsEmpty() {
    assertTrue("OpStack object should be empty after creation", opStackTest.isEmpty());
  }
  
  /**
   * The push() method simply calls the Stack object's push() method to add a symbol entry onto
   * the stack.
   */
  @Test /*Test 23 - implemented push() method to OpStack class.*/
  public void testPush() {
    opStackTest.push(Symbol.PLUS);
    assertFalse("OpStack object shouldn't be empty after pushing first entry onto it", 
        opStackTest.isEmpty());
    opStackTest.push(Symbol.DIVIDE);
    assertFalse("OpStack object shouldn't be empty after pushing second entry onto it", 
        opStackTest.isEmpty());
    opStackTest.push(Symbol.MINUS);
    assertFalse("OpStack object shouldn't be empty after pushing third entry onto it", 
        opStackTest.isEmpty());
  }
  
  /**
   * The pop() method calls the Stack object's pop() method to remove the top 
   * entry from the stack, and return it's symbol value.
   * @throws Exception when the stack is empty
   */
  @Test /*Test 24 - implemented pop() method to OpStack class. Refactored this method to a singe 
  line return statement.*/
  public void testPop() throws Exception {
    opStackTest.push(Symbol.PLUS);
    assertEquals("The pop() method should return Symbol.PLUS", opStackTest.pop(), Symbol.PLUS);
    assertTrue("The stack should be empty after popping the only entry", opStackTest.isEmpty());
  }
  
  @Rule //Used for exception testing
  public ExpectedException exception = ExpectedException.none();
  
  /**
   * EmptyStackException should be thrown when the pop() method in the OpStack class is 
   * called, and the stack is currently empty.
   * @throws BadTypeException when the top entry is not of symbol type
   * @throws EmptyStackException when the stack is empty, thus no element can be popped
   */
  @Test /*Test 25 - the pop() method now throws the EmptyStackException if it is called when 
  the stack size is currently 0.*/
  public void testPopEmptyStackException() throws EmptyStackException, BadTypeException {
    exception.expect(EmptyStackException.class);
    exception.expectMessage("The stack is empty. No element can be removed.");
    opStackTest.pop();
  }
  
  /**
   * The Shunting Algorithm used in StandardCalc requires a top() method to be implemented to 
   * OpStack, so that precedence levels of operators on the stack can be compared with a new 
   * addition.
   * @throws BadTypeException when the top entry is not of symbol type
   * @throws EmptyStackException when the stack is empty
   */
  @Test /*Test 36 - implemented top() method to OpStack class. Required for the Shunting 
  Algorithm used in StandardCalc*/
  public void testTop() throws EmptyStackException, BadTypeException {
    opStackTest.push(Symbol.PLUS);
    assertEquals("The top() method should return Symbol.PLUS", opStackTest.top(), Symbol.PLUS);
  }
}
