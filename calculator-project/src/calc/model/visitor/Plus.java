package calc.model.visitor;

/**
 * A singleton pattern since it contains no data.
 * @author Dave Cohen
 */
public class Plus implements Operator {
  private static Plus instance = new Plus();
  
  private Plus() {
  }
  
  public static Plus getInstance() {
    return instance;
  }
  
  /**
   * This method simply adds together its arguments.
   * @param first the first argument to sum
   * @param second the second argument to sum
   * @return the sum of the two arguments
   */
  public float eval(float first, float second) {
    return first + second;
  }
}
