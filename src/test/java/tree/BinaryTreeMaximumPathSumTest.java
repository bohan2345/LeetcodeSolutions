package tree;

import org.junit.Test;
import utils.BinaryTreeUtils;
import utils.TreeNode;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 1/19/2016.
 *
 * @author Bohan Zheng
 */
public class BinaryTreeMaximumPathSumTest {
    @Test
    public void testMaxPathFromRoot() {
        BinaryTreeMaximumPathSum test = new BinaryTreeMaximumPathSum();
        TreeNode root = BinaryTreeUtils.constructBinaryTree(1, -2, -3);
        assertEquals(1, test.maxPathFromRoot(root, new int[]{Integer.MIN_VALUE}));
    }

    @Test
    public void test() {
        BinaryTreeMaximumPathSum test = new BinaryTreeMaximumPathSum();
        TreeNode root = BinaryTreeUtils.constructBinaryTree(2, 1, 3);
        assertEquals(6, test.maxPathSum(root));
    }

    @Test
    public void test2() {
        BinaryTreeMaximumPathSum test = new BinaryTreeMaximumPathSum();
        TreeNode root = BinaryTreeUtils.constructBinaryTree(-3);
        assertEquals(-3, test.maxPathSum(root));
    }

    @Test
    public void test3() {
        BinaryTreeMaximumPathSum test = new BinaryTreeMaximumPathSum();
        TreeNode root = BinaryTreeUtils.constructBinaryTree(2, -3);
        assertEquals(2, test.maxPathSum(root));
    }
}
