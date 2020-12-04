package calc.model.visitor;

import calc.model.InvalidExpressionException;

/**
 * This visitor will visit any node of an expression tree and descend the tree, 
 * calculating the expression, which is stored in its answer field.
 * @author Dave Cohen
 */
public class SumVisitor implements Visitor {
  
  private float answer;
  
  public SumVisitor() {
    answer = 0;
  }
  
  /**
   * If we are visiting an operator node then we need to visit the two children.
   * We use the answers obtained from the two children and apply the operator at this node to them.
   * @throws InvalidExpressionException for division by zero
   */
  public void visit(OperatorNode node) throws InvalidExpressionException {
    // Visit left child and store the answer.
    node.getLeft().accept(this);
    float saveleft = answer;
    
    // Visit right child.
    node.getRight().accept(this);
    
    // Use the children's value to calculate the value for this node.
    answer = node.getOp().eval(saveleft, answer);
  }
  
  /**
   * If we are visiting a leaf then the answer is set to the leaf's value.
   */
  public void visit(LeafNode node) {
    answer = node.getValue();
  }
  
  public float getAnswer() {
    return answer;
  }
}
