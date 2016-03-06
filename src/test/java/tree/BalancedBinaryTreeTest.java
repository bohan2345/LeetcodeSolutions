package tree;

import org.junit.Test;
import utils.BinaryTreeUtils;
import utils.TreeNode;

import static org.junit.Assert.assertTrue;

/**
 * <p>
 * Created by Bohan Zheng on 1/6/2016.
 *
 * @author Bohan Zheng
 */
public class BalancedBinaryTreeTest {
    @Test
    public void test() {
        BalancedBinaryTree test = new BalancedBinaryTree();
        TreeNode root = BinaryTreeUtils.constructBinaryTree(1, 1, 1, 1, 1);
        assertTrue(test.isBalanced(root));
    }

    @Test
    public void test2() {
        BalancedBinaryTree test = new BalancedBinaryTree();
        TreeNode root = BinaryTreeUtils.constructBinaryTree(1);
        assertTrue(test.isBalanced(root));
    }

    @Test
    public void test3() {
        BalancedBinaryTree test = new BalancedBinaryTree();
        TreeNode root = BinaryTreeUtils.constructBinaryTree(1, 1, 1, 1, 1, 0, 0, 1);
        assertTrue(!test.isBalanced(root));
    }
}
