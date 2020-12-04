package calc.model;

/**
 * Evaluates expressions passed by the controller, so the controller 
 * can pass the answer back to the view.
 * @author Alex Cordaro ZDAC051
 * @version 1.0
 */
public class CalcModel {
  
  public CalcInterface stdCalc;
  public CalcInterface rvpCalc;
  public CalcInterface current;
  
  /**
   * Constructs an object of CalcModel, initialising the the calculator object.
   */
  public CalcModel() {
    stdCalc = new StandardCalc();
  }
  
  /**
   * Evaluates the infix string expression passed by controller.
   * @param expression the expression to evaluate
   * @return answer to the evaluated expression
   * @throws EmptyStackException the StrStack or OpStack objects are empty
   * @throws BadTypeException an incorrect getter is called for an entry type
   * @throws InvalidExpressionException the given expression is invalid
   */
  public float evaluate(String expression) throws InvalidExpressionException, 
      BadTypeException, EmptyStackException {
    return stdCalc.evaluate(expression);
  }
}
