package calc.model;

/**
 * The enum Symbol defines the list of non-number tokens possible in an expression to be calculated.
 * @author Alex Cordaro ZDAC051
 * @version 1.0
 */
public enum Symbol {
  LEFT_BRACKET("(", 0), RIGHT_BRACKET(")", 0), TIMES("*", 3), DIVIDE("/", 4), PLUS("+", 2), 
  MINUS("-", 1), INVALID(" ", 0);
  
  private final String symbol;
  private final int precedence;
  
  Symbol(String sym, int prec) {
    symbol = sym;
    precedence = prec;
  }
  
  /**
   * Overrides the default toString() method to return the symbol character represented by a
   * Symbol constant.
   * @return the constant's symbol character
   */
  @Override 
  public String toString() {
    return symbol;
  }
  
  /**
   * The precedence level refers to the order of performing mathematical operations (BODMAS), 
   * where a higher precedence level is represented by a higher number.
   * @return precedence level of a constant
   */
  public int getPrecedence() {
    return precedence;
  }
}
