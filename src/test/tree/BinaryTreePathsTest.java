package test.tree;

import main.tree.BinaryTreePaths;
import main.utils.BinaryTreeUtils;
import main.utils.TreeNode;
import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;

/**
 * <p>
 * Created by Bohan Zheng on 1/19/2016.
 *
 * @author Bohan Zheng
 */
public class BinaryTreePathsTest {
    @Test
    public void test() {
        TreeNode root = BinaryTreeUtils.constructBinaryTree(1, 2, 3, 0, 5);
        BinaryTreePaths test = new BinaryTreePaths();
        List<String> expected = Arrays.asList("1->2->5", "1->3");
        assertThat(test.binaryTreePaths(root), IsIterableContainingInAnyOrder.containsInAnyOrder(expected.toArray()));
    }
}
