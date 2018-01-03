package calc.model;

/**
 * The OpStack class defines the stack of operator symbols, read from an infix expression.
 * @author Alex Cordaro ZDAC051
 * @version 1.0
 */
public class OpStack {
  
  private Stack opStack;
  
  /**
   * Constructs a OpStack object, initialising a new empty Stack object.
   */
  public OpStack() {
    opStack = new Stack();
  }
  
  /**
   * Indicates whether there are zero entries in the stack, by calling the size() method 
   * of the Stack object.
   * @return true if the stack size is 0, otherwise false
   */
  public boolean isEmpty() {
    return opStack.size() == 0;
  }
  
  /**
   * Pushes a new symbol entry onto the top of the stack, by calling the push() method 
   * of the Stack object.
   * @param o the symbol value to be pushed onto the stack
   */
  public void push(Symbol o) {
    Entry symbol = new Entry(o);
    opStack.push(symbol);
  }
  
  /**
   * Pops the top entry from the stack, by calling the pop() method of the Stack object, 
   * then returning it's symbol value.
   * @return symbol value of the top entry
   * @throws BadTypeException when the top entry is not of symbol type
   * @throws EmptyStackException when the stack is empty, thus no entry can be popped
   */
  public Symbol pop() throws BadTypeException, EmptyStackException {
    return opStack.pop().getSymbol();
  }
  
  /**
   * Returns the newest symbol to the stack, without removing it.
   * @return top element of the stack
   * @throws BadTypeException when the top entry is not of symbol type
   * @throws EmptyStackException when the stack is empty, thus no symbol can be popped
   */
  public Symbol top() throws BadTypeException, EmptyStackException {
    return opStack.top().getSymbol();
  }
}
