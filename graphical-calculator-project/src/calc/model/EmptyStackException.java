package calc.model;

/**
 * This class defines the custom exception EmptyStackException, which is thrown 
 * when the entries list of a Stack object is empty and either the top() 
 * or pop() method has been called.
 * @author Alex Cordaro ZDAC051
 * @version 1.0
 */
public class EmptyStackException extends Exception {

  private static final long serialVersionUID = 1L;

  /**
   * Constructs an EmptyStackException with a given exception message to be displayed.
   * @param message the exception message to be displayed
   */
  public EmptyStackException(String message) {
    super(message);
  }

}