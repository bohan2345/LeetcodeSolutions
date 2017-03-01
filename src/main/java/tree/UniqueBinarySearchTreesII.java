package tree;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * <p>
 * For example,
 * Given n = 3, your program should return all 5 unique BST.
 * <p>
 * Created by Bohan Zheng on 12/23/15.
 *
 * @author Bohan Zheng
 */
public class UniqueBinarySearchTreesII {
  public List<TreeNode> generateTrees(int n) {
    if (n == 0)
      return new ArrayList<>();
    return generateTrees(1, n);
  }

  public List<TreeNode> generateTrees(int left, int right) {
    List<TreeNode> res = new ArrayList<>();
    if (left > right) {
      res.add(null);
      return res;
    }
    for (int i = left; i <= right; i++) {
      List<TreeNode> leftTrees = generateTrees(left, i - 1);
      List<TreeNode> rightTrees = generateTrees(i + 1, right);
      for (TreeNode leftNode : leftTrees) {
        for (TreeNode rightNode : rightTrees) {
          TreeNode root = new TreeNode(i);
          root.left = leftNode;
          root.right = rightNode;
          res.add(root);
        }
      }
    }
    return res;
  }
}
