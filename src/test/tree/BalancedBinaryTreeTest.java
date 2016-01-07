package test.tree;

import main.tree.BalancedBinaryTree;
import main.utils.BinaryTreeUtils;
import main.utils.TreeNode;
import org.junit.Test;

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
