package calc.model;

/**
 * This interface is implemented by RevPolishCalc and StandardCalc, instructing them to 
 * implement an evaluate method.
 * @author Alex Cordaro ZDAC051
 * @version 1.0
 */
public interface CalcInterface {
  
  public float evaluate(String expression) throws InvalidExpressionException, 
      BadTypeException, EmptyStackException;

}
