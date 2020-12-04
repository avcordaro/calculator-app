package calc.model;

/**
 * This class defines the custom exception BadTypeException, which is thrown 
 * when an incorrect getter type is called from the Entry class.
 * @author Alex Cordaro ZDAC051
 * @version 1.0
 */
public class BadTypeException extends Exception {

  private static final long serialVersionUID = 1L;

  /**
   * Constructs a BadTypeException with a given exception message to be displayed.
   * @param message the exception message to be displayed
   */
  public BadTypeException(String message) {
    super(message);
  }
  
}
