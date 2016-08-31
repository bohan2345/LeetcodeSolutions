package tree;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * For example, this binary tree is symmetric:
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * But the following is not:
 * 1
 * / \
 * 2   2
 * \   \
 * 3   3
 * <p>
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 * <p>
 * Created by Bohan Zheng on 12/21/2015.
 *
 * @author Bohan Zheng
 */
public class SymmetricTree {
  public boolean isSymmetric(TreeNode root) {
    return root == null || isSymmetric(root.left, root.right);
  }

  private boolean isSymmetric(TreeNode left, TreeNode right) {
//        if ((left == null && right == null) || (isLeafNode(left) && isLeafNode(right) && left.val == right.val)) {
//            return true;
//        } else if ((left == null && right != null) || (left != null && right == null) || left.val != right.val) {
//            return false;
//        } else {
//            return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
//        }

    // above is the original version, this is simplified version
    return (left == null && right == null) ||
        (isLeafNode(left) && isLeafNode(right) && left.val == right.val) ||
        !(left == null || right == null || left.val != right.val) &&
            isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
  }

  private boolean isLeafNode(TreeNode node) {
    return node != null && node.left == null && node.right == null;
  }

  public boolean isSymmetric2(TreeNode root) {
    if (root == null) {
      return true;
    }
    Queue<TreeNode> leftTree = new LinkedList<>();
    if (root.left != null)
      leftTree.offer(root.left);
    Queue<TreeNode> rightTree = new LinkedList<>();
    if (root.right != null)
      rightTree.offer(root.right);
    while (!leftTree.isEmpty() && !rightTree.isEmpty()) {
      TreeNode leftNode = leftTree.poll();
      TreeNode rightNode = rightTree.poll();
      if (leftNode.val != rightNode.val) {
        return false;
      }
      if (leftNode.left != null && rightNode.right != null) {
        leftTree.add(leftNode.left);
        rightTree.add(rightNode.right);
      } else if (leftNode.left == null && rightNode.right == null) {
      } else {
        return false;
      }
      if (leftNode.right != null && rightNode.left != null) {
        leftTree.add(leftNode.right);
        rightTree.add(rightNode.left);
      } else if (leftNode.right == null && rightNode.left == null) {
      } else {
        return false;
      }
    }
    return leftTree.isEmpty() && rightTree.isEmpty();
  }
}
