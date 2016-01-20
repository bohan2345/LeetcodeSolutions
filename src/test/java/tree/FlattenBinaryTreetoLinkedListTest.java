package tree;

import tree.FlattenBinaryTreetoLinkedList;
import utils.BinaryTreeUtils;
import utils.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 1/5/2016.
 *
 * @author Bohan Zheng
 */
public class FlattenBinaryTreetoLinkedListTest {
    @Test
    public void test() {
        FlattenBinaryTreetoLinkedList test = new FlattenBinaryTreetoLinkedList();
        TreeNode root = BinaryTreeUtils.constructBinaryTree(1, 2, 5, 3, 4, 0, 6);
        test.flatten(root);
        assertEquals("1,#,2,#,3,#,4,#,5,#,6", BinaryTreeUtils.serialize(root));
    }
}
