package test.tree;

import main.tree.SymmetricTree;
import main.utils.BinaryTreeUtils;
import main.utils.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * <p>
 * Created by Bohan Zheng on 12/21/2015.
 *
 * @author Bohan Zheng
 */
public class SymmetricTreeTest {
    @Test
    public void test() {
        TreeNode root = BinaryTreeUtils.constructBinaryTree(1, 2, 2, 3, 4, 4, 3);
        SymmetricTree test = new SymmetricTree();
        assertTrue(test.isSymmetric(root));
    }

    @Test
    public void test2() {
        TreeNode root = BinaryTreeUtils.constructBinaryTree(1, 2, 2, 0, 3, 0, 3);
        SymmetricTree test = new SymmetricTree();
        assertFalse(test.isSymmetric(root));
    }

    @Test
    public void test3() {
        TreeNode root = BinaryTreeUtils.constructBinaryTree(1, 2, 2, 3, 4, 4, 3);
        SymmetricTree test = new SymmetricTree();
        assertTrue(test.isSymmetric2(root));
    }
}
