package calc.model;

/**
 * The StrStack class defines the stack of strings, read from an infix expression.
 * @author Alex Cordaro ZDAC051
 * @version 1.0
 */
public class StrStack {
  
  private Stack strStack;
  
  /**
   * Constructs a StrStack object, initialising a new empty Stack object.
   */
  public StrStack() {
    strStack = new Stack();
  }
  
  /**
   * Indicates whether there are zero entries in the stack, by calling the size() method 
   * of the Stack object.
   * @return true if the stack size is 0, otherwise false
   */
  public boolean isEmpty() {
    return strStack.size() == 0;
  }
  
  /**
   * Pushes a new symbol entry onto the top of the stack, by calling the push() method 
   * of the Stack object.
   * @param str the string to be pushed onto the stack
   */
  public void push(String str) {
    Entry string = new Entry(str);
    strStack.push(string);
  }
  
  /**
   * Pops the top entry from the stack, by calling the pop() method of the Stack object, 
   * then returning it's string value.
   * @return string value of the top entry
   * @throws BadTypeException when the top entry is not of string type
   * @throws EmptyStackException when the stack is empty, thus no entry can be popped
   */
  public String pop() throws BadTypeException, EmptyStackException {
    return strStack.pop().getString();
  }
}
