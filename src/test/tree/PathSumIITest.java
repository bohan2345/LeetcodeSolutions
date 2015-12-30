package test.tree;

import main.tree.PathSumII;
import main.utils.BinaryTreeUtils;
import main.utils.TreeNode;
import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;

/**
 * <p>
 * Created by Bohan Zheng on 12/28/15.
 *
 * @author Bohan Zheng
 */
public class PathSumIITest {
    @Test
    public void test() {
        PathSumII test = new PathSumII();
        TreeNode root = BinaryTreeUtils.constructBinaryTree(5, 4, 8, 11, 0, 13, 4, 7, 2, 0, 0, 5, 1);
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(5, 4, 11, 2));
        expected.add(Arrays.asList(5, 8, 4, 5));
        assertThat(test.pathSum(root, 22), IsIterableContainingInAnyOrder.containsInAnyOrder(expected.toArray()));
    }
}