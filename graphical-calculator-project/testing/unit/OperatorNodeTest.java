package unit;

import static org.junit.Assert.assertEquals;

import calc.model.visitor.LeafNode;
import calc.model.visitor.OperatorNode;
import calc.model.visitor.Plus;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Dave's JUnit testing for the OperatorNode class.
 * @author Dave Cohen
 */
public class OperatorNodeTest {
  
  @Rule
  public final ExpectedException exception = ExpectedException.none();

  @Test
  public void testNoChildren1() {
    exception.expect(IllegalArgumentException.class);
    new OperatorNode(null, new LeafNode(3), new LeafNode(3));
  }
  
  @Test
  public void testNoChildren2() {
    exception.expect(IllegalArgumentException.class);
    new OperatorNode(Plus.getInstance(), null, new LeafNode(3));
  }
  
  @Test
  public void testNoChildren3() {
    exception.expect(IllegalArgumentException.class);
    new OperatorNode(Plus.getInstance(), new LeafNode(3), null);
  }
  
  @Test
  public void testCreate() {
    LeafNode leftLeaf = new LeafNode(3);
    LeafNode rightLeaf = new LeafNode(4);
    
    OperatorNode node = new OperatorNode(Plus.getInstance(), leftLeaf, rightLeaf);
    assertEquals("Check that the operator is stored correctly", node.getOp(), Plus.getInstance());
    assertEquals("Check that the first argument is stored correctly", node.getLeft(), leftLeaf);
    assertEquals("Check that the second argument is stored correctly", node.getRight(), rightLeaf);
  }
  
  @Test
  public void testChild() {
    LeafNode leftLeaf = new LeafNode(3);
    LeafNode rightLeaf = new LeafNode(4);
    
    OperatorNode node = new OperatorNode(Plus.getInstance(), leftLeaf, rightLeaf);
    OperatorNode parent = new OperatorNode(Plus.getInstance(), node, node);
    assertEquals("Check that the first argument is stored correctly", parent.getLeft(), node);
    assertEquals("Check that the second argument is stored correctly", parent.getRight(), node);
  } 
}