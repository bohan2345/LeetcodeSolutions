package google;

import org.junit.Assert;
import org.junit.Test;
import utils.BinaryTreeUtils;
import utils.TreeNode;

/**
 * <p>
 * Created by Bohan Zheng on 7/9/16.
 *
 * @author Bohan Zheng
 */
public class RangeSumBSTTest {
    @Test
    public void test() {
        TreeNode root = BinaryTreeUtils.deserialize("4,2,6,1,3,5,7");
        RangeSumBST test = new RangeSumBST();
        Assert.assertEquals(13, test.rangeSum(root, 7, 6));
    }

    @Test
    public void test2() {
        TreeNode root = BinaryTreeUtils.deserialize("4,2,6,1,3,5,7");
        RangeSumBST test = new RangeSumBST();
        Assert.assertEquals(22, test.rangeSum(root, 7, 4));
    }

    @Test
    public void test3() {
        Assert.assertTrue("a".compareTo("b") > 0);
    }
}
