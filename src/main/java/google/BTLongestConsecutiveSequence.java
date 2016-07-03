package google;

import utils.TreeNode;

/**
 * Given a binary tree, find the length of the longest consecutive sequence path.
 * The path refers to any sequence of nodes from some starting node to any node in
 * the tree along the parent-child connections. The longest consecutive path need
 * to be from parent to child (cannot be the reverse).
 * For example,
 * #  1
 * #   \
 * #    3
 * #   / \
 * #  2   4
 * #       \
 * #        5
 * Longest consecutive sequence path is 3-4-5, so return 3.
 * #  2
 * #   \
 * #    3
 * #   /
 * #  2
 * # /
 * #1
 * Longest consecutive sequence path is 2-3,not 3-2-1, so return 2
 * <p>
 * Created by Bohan Zheng on 7/3/16.
 *
 * @author Bohan Zheng
 */
public class BTLongestConsecutiveSequence {
    public int longestConsecutive(TreeNode root) {
        int[] max = {0};
        if (root != null) {
            dfs(root, max, 1);
        }
        return max[0];
    }

    private void dfs(TreeNode root, int[] max, int length) {
        if (length > max[0]) {
            max[0] = length;
        }
        if (root.left != null) {
            if (root.left.val == root.val + 1)
                dfs(root.left, max, length + 1);
            else {
                dfs(root.left, max, 1);
            }
        }
        if (root.right != null) {
            if (root.right.val == root.val + 1)
                dfs(root.right, max, length + 1);
            else {
                dfs(root.right, max, 1);
            }
        }
    }
}
