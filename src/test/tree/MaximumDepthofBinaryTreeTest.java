package test.tree;

import main.tree.MaximumDepthofBinaryTree;
import main.utils.BinaryTreeUtils;
import main.utils.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 1/4/2016.
 *
 * @author Bohan Zheng
 */
public class MaximumDepthofBinaryTreeTest {
    @Test
    public void test() {
        TreeNode root = BinaryTreeUtils.constructBinaryTree(1, 2, 3, 4, 5);
        MaximumDepthofBinaryTree test = new MaximumDepthofBinaryTree();
        assertEquals(3, test.maxDepth(root));
    }
}
