package calc.model.visitor;

/**
 * A singleton pattern since it contains no data.
 * @author Dave Cohen
 */

public class Times implements Operator {
  private static Times instance = new Times();
  
  private Times() {
  }
  
  public static Times getInstance() {
    return instance;
  }
  
  /**
   * This method simply multiplies together its arguments.
   * @param first the first argument to multiply
   * @param second the second argument to multiply
   * @return the product of the two arguments
   */

  public float eval(float first, float second) {
    return first * second;
  }
}
