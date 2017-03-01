package tree;

import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Test;
import utils.BinaryTreeUtils;
import utils.TreeNode;

import static org.junit.Assert.assertThat;

/**
 * <p>
 * Created by Bohan Zheng on 12/19/15.
 *
 * @author Bohan Zheng
 */
public class BinaryTreePostorderTrabersalTest {
  @Test
  public void test() {
    BinaryTreePostorderTraversal test = new BinaryTreePostorderTraversal();
    TreeNode root = BinaryTreeUtils.constructBinaryTree(1, 2, 3, 4, 5, 0, 0, 0, 0, 6);
    assertThat(test.postorderTraversal(root), IsIterableContainingInOrder.contains(4, 6, 5, 2, 3, 1));
  }
}