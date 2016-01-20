package tree;

import tree.BinaryTreeRightSideView;
import utils.BinaryTreeUtils;
import utils.TreeNode;
import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Test;

import static org.junit.Assert.assertThat;

/**
 * <p>
 * Created by Bohan Zheng on 1/14/2016.
 *
 * @author Bohan Zheng
 */
public class BinaryTreeRightSideViewTest {
    @Test
    public void test() {
        BinaryTreeRightSideView test = new BinaryTreeRightSideView();
        TreeNode root = BinaryTreeUtils.constructBinaryTree(1, 2, 3, 5);
        assertThat(test.rightSideView(root), IsIterableContainingInOrder.contains(1, 3, 5));
    }

    @Test
    public void testDFS() {
        BinaryTreeRightSideView test = new BinaryTreeRightSideView();
        TreeNode root = BinaryTreeUtils.constructBinaryTree(1, 2, 3, 5);
        assertThat(test.rightSideView2(root), IsIterableContainingInOrder.contains(1, 3, 5));
    }
}
