package tree;

import tree.BinaryTreeInorderTraversal;
import utils.BinaryTreeUtils;
import utils.TreeNode;
import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Test;

import static org.junit.Assert.assertThat;

/**
 * <p>
 * Created by Bohan Zheng on 12/18/15.
 *
 * @author Bohan Zheng
 */
public class BinaryTreeInorderTraversalTest {
    @Test
    public void test() {
        BinaryTreeInorderTraversal test = new BinaryTreeInorderTraversal();
        TreeNode root = BinaryTreeUtils.constructBinaryTree(1, 2, 3);
        assertThat(test.inorderTraversal(root), IsIterableContainingInOrder.contains(2, 1, 3));
    }
}