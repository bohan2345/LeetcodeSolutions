package tree;

import utils.TreeNode;

/**
 * Given a binary tree, determine if it is height-balanced.<p>
 * For this problem, a height-balanced binary tree is defined as a binary tree in
 * which the depth of the two subtrees of every node never differ by more than 1.
 * <p>
 * Created by Bohan Zheng on 1/5/2016.
 *
 * @author Bohan Zheng
 */
public class BalancedBinaryTree {
  public boolean isBalanced(TreeNode root) {
    return helper(root) >= 0;
  }

  private int helper(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left, right;
    left = helper(root.left);
    right = helper(root.right);
    if (left >= 0 && right >= 0 && Math.abs(left - right) <= 1) {
      return Math.max(left, right) + 1;
    } else {
      return -1;
    }
  }
}
