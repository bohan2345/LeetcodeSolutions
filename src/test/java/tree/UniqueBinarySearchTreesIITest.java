package tree;

import org.junit.Test;
import utils.BinaryTreeUtils;
import utils.TreeNode;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 12/23/15.
 *
 * @author Bohan Zheng
 */
public class UniqueBinarySearchTreesIITest {
    @Test
    public void test() {
        UniqueBinarySearchTreesII test = new UniqueBinarySearchTreesII();
        TreeNode root1 = BinaryTreeUtils.constructBinaryTree(1, 0, 2);
        TreeNode root2 = BinaryTreeUtils.constructBinaryTree(2, 1);
        List<TreeNode> nodes = test.generateTrees(2);
        assertEquals("total number of BST is wrong", 2, nodes.size());
//        assertThat(BinaryTreeUtils.serializeBinaryTree(root1), IsIterableContainingInOrder.contains(BinaryTreeUtils.serializeBinaryTree(nodes.get(0)).toArray()));
//        assertThat(BinaryTreeUtils.serializeBinaryTree(root2), IsIterableContainingInOrder.contains(BinaryTreeUtils.serializeBinaryTree(nodes.get(1)).toArray()));
    }
}