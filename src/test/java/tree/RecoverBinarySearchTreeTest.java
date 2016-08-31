package tree;

import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Test;
import utils.BinaryTreeUtils;
import utils.TreeNode;

import static org.junit.Assert.assertThat;

/**
 * <p>
 * Created by Bohan Zheng on 12/29/15.
 *
 * @author Bohan Zheng
 */
public class RecoverBinarySearchTreeTest {
  @Test
  public void test() {
    RecoverBinarySearchTree test = new RecoverBinarySearchTree();
    TreeNode root = BinaryTreeUtils.constructBinaryTree(1, 2, 3);
    test.recoverTree(root);
//        System.out.print(BinaryTreeUtils.serializeBinaryTree(root));
    assertThat(BinaryTreeUtils.serializeBinaryTree(root), IsIterableContainingInOrder.contains("2", "1", "3"));
  }
}