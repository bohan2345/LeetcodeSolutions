package tree;

import utils.TreeNode;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that
 * adding up all the values along the path equals the given sum.
 * <p>
 * Created by Bohan Zheng on 12/28/15.
 *
 * @author Bohan Zheng
 */
public class PathSum {
  public boolean hasPathSum(TreeNode root, int sum) {
    return root != null && dfsHelper(root, sum, 0);
  }

  private boolean dfsHelper(TreeNode node, int sum, int tmpSum) {
    if (node.left == null && node.right == null) {
      return sum == (tmpSum + node.val);
    } else if (node.left == null) {
      return dfsHelper(node.right, sum, tmpSum + node.val);
    } else if (node.right == null) {
      return dfsHelper(node.left, sum, tmpSum + node.val);
    } else {
      return dfsHelper(node.left, sum, tmpSum + node.val) || dfsHelper(node.right, sum, tmpSum + node.val);
    }
  }
}
