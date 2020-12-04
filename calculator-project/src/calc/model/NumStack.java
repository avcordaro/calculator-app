package calc.model;

/**
 * The NumStack class defines the stack of numeric values, read from a reverse polish expression.
 * @author Alex Cordaro ZDAC051
 * @version 1.0
 */
public class NumStack {
  
  private Stack numStack;
  
  /**
   * Constructs a NumStack object, initialising a new empty Stack object.
   */
  public NumStack() {
    numStack = new Stack();
  }
  
  /**
   * Indicates whether there are zero entries in the stack, by calling the size() method 
   * of the Stack object.
   * @return true if the stack size is 0, otherwise false
   */
  public boolean isEmpty() {
    return numStack.size() == 0;
  }
  
  /**
   * Pushes a new numeric entry onto the top of the stack, by calling the push() method 
   * of the Stack object.
   * @param i the numeric value to be pushed onto the stack
   */
  public void push(float i) {
    Entry num = new Entry(i);
    numStack.push(num);
  }
  
  /**
   * Pops the top entry from the stack, by calling the pop() method of the Stack object, 
   * then returning it's numeric value.
   * @return numeric value of the top entry
   * @throws BadTypeException when the top entry is not of numeric type
   * @throws EmptyStackException when the stack is empty, thus no entry can be popped
   */
  public float pop() throws BadTypeException, EmptyStackException {
    return numStack.pop().getValue();
  }
}
