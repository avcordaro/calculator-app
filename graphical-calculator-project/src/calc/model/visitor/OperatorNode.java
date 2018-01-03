package calc.model.visitor;

import calc.model.InvalidExpressionException;

/**
 * A TreeNode in an expression tree is either a leaf or an operator with two children: this is the 
 * operator. Its two mandatory children ensure that we can evaluate the operator.
 * Since it can be visited it must have an accept() method - which is of course trivial.
 * @author Dave Cohen
 */

public class OperatorNode implements TreeNode {
  private Operator op;
  private TreeNode left;
  private TreeNode right;
  
  /**
   * Creates a binary operator tree node.  All three arguments cannot be null.
   * @param operator  is the operator stored in the tree node
   * @param left is the left argument of the operator tree node
   * @param right is the right argument of the operator tree ndoe
   */
  public OperatorNode(Operator operator, TreeNode left, TreeNode right) {
    if (operator == null || left == null || right == null) {
      throw new IllegalArgumentException("No argument can be null");
    }
    op = operator;
    this.left = left;
    this.right = right;
  }
  
  public TreeNode getLeft() {
    return left;
  }
  
  public TreeNode getRight() {
    return right;
  }
  
  public Operator getOp() {
    return op;
  }
  
  /**
    * @param visitor accumulates data from this tree node in its visit() method.
   * @throws InvalidExpressionException for division by zero
   */
  public void accept(Visitor visitor) throws InvalidExpressionException {
    visitor.visit(this);
  }
}
