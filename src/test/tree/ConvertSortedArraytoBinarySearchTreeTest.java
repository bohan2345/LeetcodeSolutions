package test.tree;

import main.tree.ConvertSortedArraytoBinarySearchTree;
import main.tree.ValidateBinarySearchTree;
import main.utils.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * <p>
 * Created by Bohan Zheng on 1/5/2016.
 *
 * @author Bohan Zheng
 */
public class ConvertSortedArraytoBinarySearchTreeTest {
    @Test
    public void test() {
        ConvertSortedArraytoBinarySearchTree test = new ConvertSortedArraytoBinarySearchTree();
        int[] array = new int[]{1, 2, 3, 4, 5};
        TreeNode root = test.sortedArrayToBST(array);
        ValidateBinarySearchTree validator = new ValidateBinarySearchTree();
        assertTrue(validator.isValidBST(root));
    }
}
