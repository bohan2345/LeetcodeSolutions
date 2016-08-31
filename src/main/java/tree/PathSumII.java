package tree;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * <p>
 * Created by Bohan Zheng on 12/28/15.
 *
 * @author Bohan Zheng
 */
public class PathSumII {
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) {
      return res;
    }
    dfsHelper(root, sum, 0, res, new ArrayList<>());
    return res;
  }

  private void dfsHelper(TreeNode node, int sum, int tmpSum, List<List<Integer>> res, List<Integer> path) {
    path.add(node.val);
    tmpSum += node.val;
    if (node.left == null && node.right == null) {
      if (tmpSum == sum) {
        res.add(new ArrayList<>(path));
      }
    } else if (node.left == null) {
      dfsHelper(node.right, sum, tmpSum, res, path);
    } else if (node.right == null) {
      dfsHelper(node.left, sum, tmpSum, res, path);
    } else {
      dfsHelper(node.left, sum, tmpSum, res, path);
      dfsHelper(node.right, sum, tmpSum, res, path);
    }
    path.remove(path.size() - 1);
  }
}
