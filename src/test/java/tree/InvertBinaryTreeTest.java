package tree;

import tree.InvertBinaryTree;
import utils.BinaryTreeUtils;
import utils.TreeNode;
import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;

/**
 * <p>
 * Created by Bohan Zheng on 1/4/2016.
 *
 * @author Bohan Zheng
 */
public class InvertBinaryTreeTest {
    @Test
    public void test() {
        InvertBinaryTree test = new InvertBinaryTree();
        List<String> expected = Arrays.asList("2", "3", "1");
        TreeNode root = BinaryTreeUtils.constructBinaryTree(2, 1, 3);
        test.invertTree(root);
        assertThat(BinaryTreeUtils.serializeBinaryTree(root), IsIterableContainingInOrder.contains(expected.toArray()));
    }
}
