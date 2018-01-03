package unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import calc.model.EmptyStackException;
import calc.model.Entry;
import calc.model.Stack;
import calc.model.Symbol;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Contains all JUnit 4 tests for testing the Stack class. 
 * @author Alex Cordaro ZDAC051    
 */
public class TestStack {
  
  private Stack stack;
  private Entry entryNumber;
  private Entry entrySymbol;
  private Entry entryString;
  
  /**
   * Objects are created from the different consturctor methods in the Entry and Stack class, 
   * to be used for testing class methods.
   */
  @Before //Object creations from the Entry and Stack class for use in later tests
  public void setUp() {
    entryNumber = new Entry(15);
    entrySymbol = new Entry(Symbol.PLUS);
    entryString = new Entry("3 * 5");
    stack = new Stack();
  }
  
  /**
   * The size() method in the Stack class should return the value of the class field size. 
   * When a new Stack object is created, this value should be 0.
   */
  @Test /*Test 10 - implemented size() method to Stack class.*/
  public void testSize() {
    assertEquals("Size of an empty stack", 0, stack.size());
  }
  
  /**
   * The push() method in the Stack class should push the new Entry object to top of the 
   * stack. The value of the class field size should also increase by 1.
   */
  @Test /*Test 11 - implemented push() method to Stack class. Refactored entries from array 
  to ArrayList, with it's add() method to push Entry objects onto the stack.*/
  public void testPush() {
    stack.push(entryNumber);
    assertEquals("Size of stack after first addition", 1, stack.size());
    stack.push(entrySymbol);
    assertEquals("Size of stack after second addition", 2, stack.size());
    stack.push(entryString);
    assertEquals("Size of stack after third addition", 3, stack.size());
  }
  
  /**
   * The top() method in the Stack class should return the newest Entry element added to 
   * the stack.
   * @throws Exception when the stack size is 0
   */
  @Test /*Test 12 - implemented top() method to Stack class. Refactored push() method to push 
  new elements to the front of ArrayList (index 0), so that top() method only has to call 
  entries.get(0), rather than entries.get(size() - 1).*/ 
  public void testTop() throws Exception {
    stack.push(entryNumber);
    assertSame("Returning the last entry added to stack", entryNumber, stack.top());
  }
  
  /**
   * The pop() method in the Stack class should return the newest Entry element added to 
   * the stack, before removing it.
   * @throws Exception when the stack size is 0
   */
  @Test /*Test 13 - implemented pop() method to Stack class. Refactored code to call top() 
  method for returning top element, rather than repeating the same code statements.*/
  public void testPop() throws Exception {
    stack.push(entryNumber);
    stack.push(entrySymbol);
    stack.push(entryString);
    assertSame("Returning third entry added to stack", entryString, stack.pop());
    assertEquals("Stack size after first pop", 2, stack.size());
    assertSame("Returning second entry added to stack", entrySymbol, stack.pop());
    assertEquals("Stack size after second pop", 1, stack.size());
    assertSame("Returning first entry added to stack", entryNumber, stack.pop());
    assertEquals("Stack size after third pop", 0, stack.size());
  }
  
  /**
   * Declares an ExpectedException variable, to be used for testing expected exception throws.
   */
  @Rule //Used for exception testing
  public ExpectedException exception = ExpectedException.none();
  
  /**
   * EmptyStackException should be thrown when the top() method in the Stack class is 
   * called, and the stack size is currently 0.
   * @throws EmptyStackException when the stack size is 0, thus no top element can be returned
   */
  @Test /*Test 14 - created EmptyStackException class. The top() method now throws this 
  exception if it is called when the stack size is currenlty 0.*/
  public void testTopEmptyStackException() throws EmptyStackException {
    exception.expect(EmptyStackException.class);
    exception.expectMessage("The stack is empty. There is no top element.");
    stack.top();
  }
  
  /**
   * EmptyStackException should be thrown when the pop() method in the Stack class is 
   * called, and the stack size is currently 0.
   * @throws EmptyStackException when the stack size is 0, thus no element can be popped
   */
  @Test /*Test 15 - the pop() method now throws the EmptyStackException if it is called when 
  the stack size is currently 0.*/
  public void testPopEmptyStackException() throws EmptyStackException {
    exception.expect(EmptyStackException.class);
    exception.expectMessage("The stack is empty. No element can be removed.");
    stack.pop();
  }

}