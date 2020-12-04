package calc.model.visitor;

import calc.model.InvalidExpressionException;

/**
 * A TreeNode in an expression tree.
 * Since it can be visited it must have an accept() method.
 * @author Dave Cohen
 */
public interface TreeNode {
  public void accept(Visitor visitor) throws InvalidExpressionException;
}
