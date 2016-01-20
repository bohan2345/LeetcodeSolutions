package tree;

import utils.TreeNode;

/**
 * <p>
 * Created by Bohan Zheng on 1/4/2016.
 *
 * @author Bohan Zheng
 */
public class MinimumDepthofBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] minHeight = new int[] {Integer.MAX_VALUE};
        dfsHelper(root, 1, minHeight);
        return minHeight[0];
    }

    private void dfsHelper(TreeNode node, int height, int[] minHeight) {
        if (node.left == null && node.right == null) {
            minHeight[0] = Math.min(height, minHeight[0]);
            return;
        }
        height++;
        if (node.left != null) {
            dfsHelper(node.left, height, minHeight);
        }
        if (node.right != null) {
            dfsHelper(node.right, height, minHeight);
        }
    }

    /**
     * solution 2: level order traversal
     */
}
