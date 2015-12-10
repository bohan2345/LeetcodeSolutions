package test.utils;

import main.utils.BinaryTreeUtils;
import main.utils.TreeNode;
import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Test;

import static org.junit.Assert.assertThat;

/**
 * <p>
 * Created by Bohan Zheng on 12/6/15.
 *
 * @author Bohan Zheng
 */
public class BinaryTreeUtilsTest {

    @Test
    public void test() {
        BinaryTreeUtils test = new BinaryTreeUtils();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node4.right = node5;
        assertThat(test.serializeBinaryTree(node1), IsIterableContainingInOrder.contains("1", "2", "3", "#", "#", "4", "#", "#", "5"));
    }
}
