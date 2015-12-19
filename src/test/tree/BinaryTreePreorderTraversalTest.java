package test.tree;

import main.tree.BinaryTreePreorderTraversal;
import main.utils.BinaryTreeUtils;
import main.utils.TreeNode;
import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Test;

import static org.junit.Assert.assertThat;

/**
 * <p>
 * Created by Bohan Zheng on 12/18/15.
 *
 * @author Bohan Zheng
 */
public class BinaryTreePreorderTraversalTest {
    @Test
    public void test() {
        BinaryTreePreorderTraversal test = new BinaryTreePreorderTraversal();
        TreeNode root = BinaryTreeUtils.constructBinaryTree(1, 2, 3);
        assertThat(test.preorderTraversal(root), IsIterableContainingInOrder.contains(1, 2, 3));
    }
}