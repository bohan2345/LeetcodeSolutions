package tree;

import utils.TreeNode;

/**
 * <p>
 * Created by Bohan Zheng on 1/4/2016.
 *
 * @author Bohan Zheng
 */
public class MaximumDepthofBinaryTree {
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int[] maxHeight = new int[1];
    dfsHelper(root, 1, maxHeight);
    return maxHeight[0];
  }

  private void dfsHelper(TreeNode node, int height, int[] maxHeight) {
    if (node.left == null && node.right == null) {
      maxHeight[0] = Math.max(height, maxHeight[0]);
      return;
    }
    height++;
    if (node.left != null) {
      dfsHelper(node.left, height, maxHeight);
    }
    if (node.right != null) {
      dfsHelper(node.right, height, maxHeight);
    }
  }

  /**
   * solution 2: level order traversal
   */
}
