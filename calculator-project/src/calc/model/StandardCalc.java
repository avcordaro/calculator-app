package calc.model;

/**
 * The StandardCalc class is used to evaluate infix expression strings, 
 * by implementing the Shunting Algorithm. This converts an infix 
 * expression to postfix, then the postfix string is passed to a 
 * RevPolishCalc object which evaluates the answer for this class.
 * @author Alex Cordaro ZDAC051
 * @version 1.0
 */
public class StandardCalc implements CalcInterface {
  
  private RevPolishCalc rvpCalc;
  private OpStack opStack;
  private StrStack strStack;
  
  /**
   * Constructs a StandardCalc object, initialising objects of 
   * RevPolishCalc, OpStack and StrStack.
   */
  public StandardCalc() {
    rvpCalc = new RevPolishCalc();
    opStack = new OpStack();
    strStack = new StrStack();
  }

  /**
   * This method uses Dijkstra's Shunting Algorithm to convert 
   * an infix expression to a post expression.
   * @param infixTokens a StrStack object containing the infix expression tokens
   * @return an equivalent postfix string
   * @throws BadTypeException the wrong getter for an Entry type is called
   * @throws EmptyStackException either strStack or opStack are already empty
   * @throws InvalidExpressionException the infix string is not a valid mathematical 
   expression
   */
  public String convertToPostfix(StrStack infixTokens) throws 
      BadTypeException, EmptyStackException, InvalidExpressionException {
    
    StringBuilder strBuilder = new StringBuilder();
    String token;
    Symbol operator;
    boolean previousTokenWasDigit = false;
    
    while (!strStack.isEmpty()) {
      token = strStack.pop();
      
      if (token.matches("[*\\+\\-\\/]")) {
        switch (token) {
          case "+": 
            operator = Symbol.PLUS;
            break;
          case "-": 
            operator = Symbol.MINUS;
            break;
          case "*": 
            operator = Symbol.TIMES;
            break;
          case "/": 
            operator = Symbol.DIVIDE;
            break;
          default: 
            continue;
        }
        
        while (!opStack.isEmpty()) {
          if (operator.getPrecedence() <= opStack.top().getPrecedence()) {
            strBuilder.append(opStack.pop().toString() + " ");
          } else {
            break;
          }
        }
        opStack.push(operator);
        previousTokenWasDigit = false;
        
      } else if (token.equals("(")) {
        opStack.push(Symbol.LEFT_BRACKET);
        previousTokenWasDigit = false;
        
      } else if (token.equals(")")) {
        while (!opStack.isEmpty() && opStack.top() != Symbol.LEFT_BRACKET) {
          operator = opStack.pop();
          strBuilder.append(operator.toString() + " ");
          previousTokenWasDigit = false;
        }
        opStack.pop();
        
      } else {
        if (token.matches("^[0-9]+$|^[0-9]+.[0-9]+$")) {
          if (previousTokenWasDigit) {
            throw new InvalidExpressionException("Unbalanced expression.");
          }
          strBuilder.append(token + " ");
          previousTokenWasDigit = true;
        } else {
          throw new InvalidExpressionException("Invalid expression.");
        }
      }
    }
    
    while (!opStack.isEmpty()) {
      operator = opStack.pop();
      strBuilder.append(operator.toString() + " ");
    }
    return strBuilder.toString();
  }
  
  /**
   * The evaluate method breaks an infix string down into tokens, on a StrStack 
   * object, before passing it to the convertToPostfix() method. The returned 
   * string is then evaluated by the RevPolishCalc object, in order for this 
   * method to return the answer.
   * @param expression an infix expression string
   * @return the answer to the expression
   * @throws BadTypeException the wrong getter for an Entry type is called
   * @throws EmptyStackException either strStack or opStack are already empty
   * @throws InvalidExpressionException the infix or postfix string is not a valid 
   mathematical expression
   */
  public float evaluate(String expression) throws InvalidExpressionException, 
      BadTypeException, EmptyStackException {
    
    String[] expTokens = expression.split("\\s+");
    for (int i = expTokens.length - 1; i >= 0; i--) {
      strStack.push(expTokens[i]);
    }
    
    String postfixExpression = convertToPostfix(strStack);
    return rvpCalc.evaluate(postfixExpression);
  }
}
