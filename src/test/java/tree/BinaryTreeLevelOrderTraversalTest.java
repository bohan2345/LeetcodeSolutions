package tree;

import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Test;
import utils.BinaryTreeUtils;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;

/**
 * <p>
 * Created by Bohan Zheng on 12/19/15.
 *
 * @author Bohan Zheng
 */
public class BinaryTreeLevelOrderTraversalTest {
  @Test
  public void test() {
    BinaryTreeLevelOrderTraversal test = new BinaryTreeLevelOrderTraversal();
    TreeNode root = BinaryTreeUtils.constructBinaryTree(3, 9, 20, 0, 0, 15, 7);
    List<List<Integer>> expected = new ArrayList<>();
    expected.add(Arrays.asList(3));
    expected.add(Arrays.asList(9, 20));
    expected.add(Arrays.asList(15, 7));
    assertThat(test.levelOrder(root), IsIterableContainingInOrder.contains(expected.toArray()));
  }
}