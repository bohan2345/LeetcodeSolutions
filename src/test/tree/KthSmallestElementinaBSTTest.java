package test.tree;

import main.tree.KthSmallestElementinaBST;
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
public class KthSmallestElementinaBSTTest {
    @Test
    public void test() {
        TreeNode root = BinaryTreeUtils.constructBinaryTree(4, 2, 5, 1, 3);
        KthSmallestElementinaBST test = new KthSmallestElementinaBST();
        assertEquals(1, test.kthSmallest(root, 1));
    }

    @Test
    public void test2() {
        TreeNode root = BinaryTreeUtils.constructBinaryTree(4, 2, 5, 1, 3);
        KthSmallestElementinaBST test = new KthSmallestElementinaBST();
        assertEquals(3, test.kthSmallest(root, 3));
    }
}
