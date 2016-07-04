package google;

import org.junit.Test;
import utils.BinaryTreeUtils;
import utils.TreeNode;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 7/4/16.
 *
 * @author Bohan Zheng
 */
public class LowestCommonAncestorofaBinarySearchTreeIITest {
    @Test
    public void test() {
        TreeNode root = BinaryTreeUtils.deserialize("37,-34,-48,#,-100,-100,48,#,#,#,#,-54,#,-71,-22,#,#,#,8");
        LowestCommonAncestorofaBinarySearchTreeII test = new LowestCommonAncestorofaBinarySearchTreeII();
        TreeNode node1 = new TreeNode(-100);
        TreeNode node2 = new TreeNode(-71);
        assertEquals(-48, test.commonAncestor(root, node1, node2).val);
    }
}