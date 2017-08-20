package tree;

import google.BTLongestConsecutiveSequence;
import org.junit.Test;
import utils.BinaryTreeUtils;
import utils.TreeNode;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 7/3/16.
 *
 * @author Bohan Zheng
 */
public class BTLongestConsecutiveSequenceTest {
    @Test
    public void test() {
        BTLongestConsecutiveSequence test = new BTLongestConsecutiveSequence();
        TreeNode root = BinaryTreeUtils.deserialize("1,#,3,2,4,#,#,5,5,6");
        assertEquals(4, test.longestConsecutive(root));
    }
}