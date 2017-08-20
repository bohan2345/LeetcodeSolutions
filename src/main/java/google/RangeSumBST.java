package google;

import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * Created by Bohan Zheng on 7/9/16.
 *
 * @author Bohan Zheng
 */
public class RangeSumBST {
    Map<TreeNode, Integer> cache = new HashMap<>();

    public int rangeSum(TreeNode root, int max, int min) {
        if (root == null) {
            return 0;
        }
        if (cache.containsKey(root)) {
            return cache.get(root);
        }
        int sum = 0;
        if (root.val <= max && root.val >= min) {
            sum = rangeSum(root.left, max, min) + rangeSum(root.right, max, min) + root.val;
        } else if (root.val < min) {
            sum = rangeSum(root.right, max, min);
        } else {
            sum = rangeSum(root.left, max, min);
        }
        cache.put(root, sum);
        return sum;
    }
}
