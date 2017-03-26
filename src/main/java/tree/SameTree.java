package tree;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given two binary trees, write a function to check if they are equal or not.
 * <p>
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 * <p>
 * Created by Bohan Zheng on 12/22/2015.
 *
 * @author Bohan Zheng
 */
public class SameTree {
  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    } else if ((p != null && q == null) || (p == null && q != null)) {
      return false;
    }
    Queue<TreeNode> queue1 = new LinkedList<>();
    queue1.offer(p);
    Queue<TreeNode> queue2 = new LinkedList<>();
    queue2.offer(q);
    while (!queue1.isEmpty() && !queue2.isEmpty()) {
      TreeNode node1 = queue1.poll();
      TreeNode node2 = queue2.poll();
      if (node1.val != node2.val) {
        return false;
      }
      if (node1.left != null && node2.left != null) {
        queue1.offer(node1.left);
        queue2.offer(node2.left);
      } else if (node1.left == null && node2.left == null) {
      } else {
        return false;
      }
      if (node1.right != null && node2.right != null) {
        queue1.offer(node1.right);
        queue2.offer(node2.right);
      } else if (node1.right == null && node2.right == null) {
      } else {
        return false;
      }
    }
    return queue1.isEmpty() && queue2.isEmpty();
  }

  public boolean isSameTree2(TreeNode p, TreeNode q) {
//        if (p == null && q == null) {
//            return true;
//        } else if ((p == null && q != null) || (p != null && q == null)) {
//            return false;
//        } else
//            return isSameTree2(p.left, q.left) && isSameTree2(p.right, q.right) && p.val == q.val;
    return p == null && q == null || !(p == null || q == null) &&
        isSameTree2(p.left, q.left) && isSameTree2(p.right, q.right) && p.val == q.val;
  }
}
