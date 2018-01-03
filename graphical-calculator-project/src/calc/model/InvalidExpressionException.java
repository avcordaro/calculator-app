package calc.model;

/**
 * This class defines the custom exception InvalidExpressionException, which is thrown 
 * when the user enters a string to be calculated, that contains invalid characters.
 * @author Alex Cordaro ZDAC051
 * @version 1.0
 */
public class InvalidExpressionException extends Exception {

  private static final long serialVersionUID = 1L;

  /**
   * Constructs an InvalidExpressionException with a given exception message to be displayed.
   * @param message the exception message to be displayed
   */
  public InvalidExpressionException(String message) {
    super(message);
  }

}