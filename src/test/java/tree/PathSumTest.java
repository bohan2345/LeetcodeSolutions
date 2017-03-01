package tree;

import org.junit.Test;
import utils.BinaryTreeUtils;
import utils.TreeNode;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * <p>
 * Created by Bohan Zheng on 12/28/15.
 *
 * @author Bohan Zheng
 */
public class PathSumTest {
  @Test
  public void test() {
    PathSum test = new PathSum();
    TreeNode root = BinaryTreeUtils.constructBinaryTree(5, 4, 8, 11, 13, 4, 7, 2, 0, 0, 0, 1);
    assertTrue(test.hasPathSum(root, 22));
  }

  @Test
  public void test2() {
    PathSum test = new PathSum();
    TreeNode root = BinaryTreeUtils.constructBinaryTree(1, 2);
    assertFalse(test.hasPathSum(root, 0));
  }
}