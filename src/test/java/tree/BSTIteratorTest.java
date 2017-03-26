package tree;

import org.junit.Test;
import utils.BinaryTreeUtils;
import utils.TreeNode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * <p>
 * Created by Bohan Zheng on 1/20/2016.
 *
 * @author Bohan Zheng
 */
public class BSTIteratorTest {
  @Test
  public void test() {
    TreeNode root = BinaryTreeUtils.constructBinaryTree(4, 2, 6, 1, 3, 5);
    BSTIterator iterator = new BSTIterator(root);
    assertEquals(1, iterator.next());
    assertEquals(2, iterator.next());
    assertEquals(3, iterator.next());
    assertEquals(4, iterator.next());
    assertEquals(5, iterator.next());
    assertEquals(6, iterator.next());
    assertFalse(iterator.hasNext());
  }
}
