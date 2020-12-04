package unit;

import static org.junit.Assert.assertEquals;

import calc.model.visitor.LeafNode;

import org.junit.Test;

/**
 * Dave's JUnit testing for the LeafNode class.
 * @author Dave Cohen
 */
public class LeafNodeTest {
  
  @Test
  public void test() {
    LeafNode leaf = new LeafNode(5);
    assertEquals(leaf.getValue(), 5);
  }
  
}
