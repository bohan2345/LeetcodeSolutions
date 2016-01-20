package utils;

import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * <p>
 * Created by Bohan Zheng on 12/6/15.
 *
 * @author Bohan Zheng
 */
public class BinaryTreeUtilsTest {

    @Test
    public void testSerializeBinaryTree() {
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

    @Test
    public void testConstructBinaryTree() {
        BinaryTreeUtils test = new BinaryTreeUtils();
        List<String> nodes = Arrays.asList("1", "2", "3", "4", "#", "5");
        TreeNode root = test.constructBinaryTree(nodes);
        assertThat(test.serializeBinaryTree(root), IsIterableContainingInOrder.contains("1", "2", "3", "4", "#", "5"));
    }

    @Test
    public void testConstructBinaryTree2() {
        BinaryTreeUtils test = new BinaryTreeUtils();
        List<String> nodes = Arrays.asList("1", "#", "2", "#", "3", "#", "4", "#", "5");
        TreeNode root = test.constructBinaryTree(nodes);
        assertThat(test.serializeBinaryTree(root), IsIterableContainingInOrder.contains("1", "#", "2", "#", "3", "#", "4", "#", "5"));
    }

    @Test
    public void testSeriallize() {
        TreeNode root = BinaryTreeUtils.constructBinaryTree(1,2,3);
        String actual = BinaryTreeUtils.serialize(root);
        assertEquals("1,2,3", actual);
        TreeNode newRoot = BinaryTreeUtils.deserialize(actual);
        assertEquals(1, newRoot.val);
        assertEquals(2, newRoot.left.val);
        assertEquals(3, newRoot.right.val);
    }
}
