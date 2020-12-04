package calc.model;

import java.util.ArrayList;

/**
 * The Stack class defines the list of entry values read from an expression.
 * @author Alex Cordaro ZDAC051
 * @version 1.0
 */
public class Stack {
  
  private int size;
  private ArrayList<Entry> entries;
  
  /**
   * Constructs a Stack object with an empty entries list.
   */
  public Stack() {
    entries = new ArrayList<Entry>();
  }
  
  /**
   * Returns the value of the class field size, indicating the current number
   * of elements in the entries list.
   * @return number of elements in the entries list
   */
  public int size() {
    return size;
  }
  
  /**
   * Pushes a new entry onto the top of the stack.
   * @param i the new Entry object to be added to the stack
   */
  public void push(Entry i) {
    /*new elements are added to the front of the ArrayList, pushing all 
    elements currently in the stack to the right (index increased by 1)*/
    entries.add(0, i);
    size++;
  }
  
  /**
   * Returns the newest entry to the stack, without removing it.
   * @return top element of the stack
   * @throws EmptyStackException when the stack size is 0
   */
  public Entry top() throws EmptyStackException {
    if (size > 0) {
      //The newest element was added to the front of the ArrayList, hence it is at index 0
      return entries.get(0);
    }
    throw new EmptyStackException("The stack is empty. There is no top element.");
  }
  
  /**
   * Returns the newest entry to the stack before removing it.
   * @return top element of the stack
   * @throws EmptyStackException when the stack size is 0
   */
  public Entry pop() throws EmptyStackException {
    if (size > 0) {
      /*Removes the newest element at index 0, after creating a new reference to the object 
       so it can be returned. All elements in the ArrayList shift one index position to 
       the left (decreased by 1) after removal*/
      Entry top = top();
      entries.remove(0);
      size--;
      return top;
    }
    throw new EmptyStackException("The stack is empty. No element can be removed.");
  }
  
}

