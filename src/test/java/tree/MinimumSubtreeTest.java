package tree;

import org.junit.Test;
import utils.BinaryTreeUtils;
import utils.TreeNode;

import static org.junit.Assert.assertEquals;

/**
 * Created by bohan on 2/4/2017.
 *
 * @author Bohan Zheng
 */
public class MinimumSubtreeTest {
  @Test
  public void test() {
    MinimumSubtree test = new MinimumSubtree();
    TreeNode root = BinaryTreeUtils.deserialize("1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16");
    assertEquals(9, test.findSubtree(root).val);
  }
}
