package tree;

import utils.TreeNode;

import java.util.Stack;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * <p>
 * Calling next() will return the next smallest number in the BST.
 * <p>
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 * <p>
 * Created by Bohan Zheng on 1/20/2016.
 *
 * @author Bohan Zheng
 */
public class BSTIterator {
  Stack<TreeNode> stack;

  public BSTIterator(TreeNode root) {
    stack = new Stack<>();
    while (root != null) {
      stack.push(root);
      root = root.left;
    }
  }

  /**
   * @return whether we have a next smallest number
   */
  public boolean hasNext() {
    return !stack.isEmpty();
  }

  /**
   * @return the next smallest number
   */
  public int next() {
    TreeNode node = stack.pop();
    int val = node.val;
    node = node.right;
    while (node != null) {
      stack.push(node);
      node = node.left;
    }
    return val;
  }
}
/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */