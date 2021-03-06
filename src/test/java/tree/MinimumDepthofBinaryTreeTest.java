package tree;

import org.junit.Test;
import utils.BinaryTreeUtils;
import utils.TreeNode;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 1/4/2016.
 *
 * @author Bohan Zheng
 */
public class MinimumDepthofBinaryTreeTest {
    @Test
    public void test() {
        TreeNode root = BinaryTreeUtils.constructBinaryTree(1, 2, 3, 4, 5);
        MinimumDepthofBinaryTree test = new MinimumDepthofBinaryTree();
        assertEquals(2, test.minDepth(root));
    }

    @Test
    public void test2() {
        TreeNode root = BinaryTreeUtils.constructBinaryTree(1);
        MinimumDepthofBinaryTree test = new MinimumDepthofBinaryTree();
        assertEquals(1, test.minDepth(root));
    }
}
