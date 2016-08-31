package tree;

import utils.TreeNode;

/**
 * Given a binary tree, find the maximum path sum.
 * <p>
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree
 * along the parent-child connections. The path does not need to go through the root.
 * <p>
 * For example:
 * Given the below binary tree,
 * <p>
 * 1
 * / \
 * 2   3
 * Return 6.
 * <p>
 * Created by Bohan Zheng on 1/14/2016.
 *
 * @author Bohan Zheng
 */
public class BinaryTreeMaximumPathSum {
  public int maxPathSum(TreeNode root) {
    int[] max = {Integer.MIN_VALUE};
    maxPathFromRoot(root, max);
    return max[0];
  }

  public int maxPathFromRoot(TreeNode root, int[] max) {
    if (root == null) {
      return 0;
    }
    int leftPath = Math.max(maxPathFromRoot(root.left, max), 0);
    int rightPath = Math.max(maxPathFromRoot(root.right, max), 0);
    max[0] = Math.max(max[0], root.val + leftPath + rightPath);

    return Math.max(leftPath, rightPath) + root.val;
  }
}