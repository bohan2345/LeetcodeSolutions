package tree;

import tree.BinaryTreeZigzagLevelOrderTraversal;
import utils.BinaryTreeUtils;
import utils.TreeNode;
import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;

/**
 * <p>
 * Created by Bohan Zheng on 1/12/2016.
 *
 * @author Bohan Zheng
 */
public class BinaryTreeZigzagLevelOrderTraversalTest {
    @Test
    public void test() {
        BinaryTreeZigzagLevelOrderTraversal test = new BinaryTreeZigzagLevelOrderTraversal();
        TreeNode root = BinaryTreeUtils.constructBinaryTree(1, 2, 3, 4, 5, 6, 7);
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(1));
        expected.add(Arrays.asList(3, 2));
        expected.add(Arrays.asList(4, 5, 6, 7));
        assertThat(test.zigzagLevelOrder(root), IsIterableContainingInOrder.contains(expected.toArray()));
    }
}
