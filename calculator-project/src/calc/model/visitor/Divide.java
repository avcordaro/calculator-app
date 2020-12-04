package calc.model.visitor;

import calc.model.InvalidExpressionException;

/**
 * A singleton pattern since it contains no data.
 * @author Alex Cordaro ZDAC051
 */
public class Divide implements Operator {
  private static Divide instance = new Divide();
  
  private Divide() {
  }
  
  public static Divide getInstance() {
    return instance;
  }
  
  /**
   * This method simply calculates the difference of its arguments.
   * @param starting the starting value
   * @param divisor the value to divide by
   * @return the starting value divided by the divisor value
   * @throws InvalidExpressionException for division by zero
   */
  public float eval(float starting, float divisor) throws InvalidExpressionException {
    if (divisor == 0) {
      throw new InvalidExpressionException("Invalid division by zero.");
    }
    return starting / divisor;
  }
}
