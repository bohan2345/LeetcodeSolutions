package tree;

import tree.LowestCommonAncestorofaBinaryTree;
import utils.BinaryTreeUtils;
import utils.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 1/4/2016.
 *
 * @author Bohan Zheng
 */
public class LowestCommonAncestorofaBinaryTreeTest {
    @Test
    public void test() {
        TreeNode root = BinaryTreeUtils.constructBinaryTree(6, 2, 8, 1, 4, 7, 9, 0, 0, 3, 5);
        LowestCommonAncestorofaBinaryTree test = new LowestCommonAncestorofaBinaryTree();
        assertEquals(root.right, test.lowestCommonAncestor(root, root.right.right, root.right.left));
    }
}
