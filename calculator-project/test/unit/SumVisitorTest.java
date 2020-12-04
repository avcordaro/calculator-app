package unit;

import static org.junit.Assert.assertEquals;

import calc.model.InvalidExpressionException;
import calc.model.visitor.LeafNode;
import calc.model.visitor.Minus;
import calc.model.visitor.Operator;
import calc.model.visitor.OperatorNode;
import calc.model.visitor.Plus;
import calc.model.visitor.SumVisitor;
import calc.model.visitor.Times;

import org.junit.Test;

/**
 * Dave's JUnit testing for the SumVisitor class.
 * @author Dave Cohen
 */
public class SumVisitorTest {
  
  private LeafNode threeLeaf = new LeafNode(3);
  private LeafNode fourLeaf = new LeafNode(4);
  private Operator plus = Plus.getInstance();
  private Operator minus = Minus.getInstance();
  private Operator times = Times.getInstance();

  @Test
  public void testLeaf() {
    SumVisitor sum = new SumVisitor();
    threeLeaf.accept(sum);
    assertEquals(sum.getAnswer(), 3, 0.001);
  }

  @Test
  public void testNode() throws InvalidExpressionException {
    SumVisitor sum = new SumVisitor();
    OperatorNode node = new OperatorNode(plus, threeLeaf, fourLeaf);
    node.accept(sum);
    assertEquals(sum.getAnswer(), 7, 0.001);
  }

  @Test
  public void testTree() throws InvalidExpressionException {
    SumVisitor sum = new SumVisitor();
    OperatorNode node = new OperatorNode(plus, threeLeaf, fourLeaf);
    OperatorNode parent = new OperatorNode(plus, threeLeaf, node);
    parent = new OperatorNode(plus, parent, fourLeaf);
    parent.accept(sum);
    assertEquals(sum.getAnswer(), 14, 0.001);
  }
  
  @Test
  public void testHardTree() throws InvalidExpressionException {
    SumVisitor sum = new SumVisitor();
    OperatorNode node = new OperatorNode(plus, threeLeaf, fourLeaf);
    OperatorNode parent = new OperatorNode(times, node, node);
    parent = new OperatorNode(minus, parent, fourLeaf);
    parent.accept(sum);
    assertEquals(sum.getAnswer(), 45, 0.001);
  }
}
