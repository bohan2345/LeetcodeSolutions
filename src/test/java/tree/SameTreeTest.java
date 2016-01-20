package tree;

import tree.SameTree;
import utils.BinaryTreeUtils;
import utils.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * <p>
 * Created by Bohan Zheng on 12/22/2015.
 *
 * @author Bohan Zheng
 */
public class SameTreeTest {
    @Test
    public void test() {
        SameTree test = new SameTree();
        TreeNode root = BinaryTreeUtils.constructBinaryTree(1, 2, 3);
        TreeNode root2 = BinaryTreeUtils.constructBinaryTree(1, 2, 3);
        assertTrue(test.isSameTree(root, root2));
    }
    
    @Test
    public void test2() {
        SameTree test = new SameTree();
        TreeNode root = BinaryTreeUtils.constructBinaryTree(1, 2, 3);
        TreeNode root2 = BinaryTreeUtils.constructBinaryTree(1, 2, 3);
        assertTrue(test.isSameTree2(root, root2));
    }
}
