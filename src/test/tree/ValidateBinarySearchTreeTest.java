package test.tree;

import main.tree.ValidateBinarySearchTree;
import main.utils.BinaryTreeUtils;
import main.utils.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * <p>
 * Created by Bohan Zheng on 12/18/15.
 *
 * @author Bohan Zheng
 */
public class ValidateBinarySearchTreeTest {
    @Test
    public void test() {
        ValidateBinarySearchTree test = new ValidateBinarySearchTree();
        TreeNode root = BinaryTreeUtils.constructBinaryTree(2, 1, 3);
        assertTrue(test.isValidBST(root));
    }
}