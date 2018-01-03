package calc.model.visitor;

import calc.model.InvalidExpressionException;

/**
 * This is the visitor pattern for visiting an expression tree.
 * Every type of TreeNode must have a visit() method in any implementation.
 * @author Dave Cohen
 */
public interface Visitor {
  public void visit(OperatorNode node) throws InvalidExpressionException;
  
  public void visit(LeafNode node);
}
