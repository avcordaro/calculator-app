package calc.model.visitor;

/**
 * A singleton pattern since it contains no data.
 * @author Dave Cohen
 */
public class Minus implements Operator {
  private static Minus instance = new Minus();
  
  private Minus() {
  }
  
  public static Minus getInstance() {
    return instance;
  }
  
  /**
   * This method simply calculates the difference of its arguments.
   * @param starting the starting value
   * @param subtracted the value to subtract
   * @return the starting value minus the value to subtract
   */
  public float eval(float starting, float subtracted) {
    return starting - subtracted;
  }
}
