package tree;

import utils.TreeNode;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * <p>
 * <p>
 * Created by Bohan Zheng on 1/4/2016.
 *
 * @author Bohan Zheng
 */
public class LowestCommonAncestorofaBinaryTree {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return null;
    }
    if (root.equals(p)) {
      return p;
    }
    if (root.equals(q)) {
      return q;
    }
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    if (left != null && right != null) {
      return root;
    } else if (left == null && right == null) {
      return null;
    } else if (left == null) {
      return right;
    } else {
      return left;
    }
  }
}
