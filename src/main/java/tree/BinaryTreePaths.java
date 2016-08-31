package tree;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.<p>
 * For example, given the following binary tree:
 * <p>
 * 1
 * / \
 * 2   3
 * \
 * 5
 * All root-to-leaf paths are:
 * ["1->2->5", "1->3"]
 * <p>
 * Created by Bohan Zheng on 1/19/2016.
 *
 * @author Bohan Zheng
 */
public class BinaryTreePaths {
  public List<String> binaryTreePaths(TreeNode root) {
    List<String> res = new ArrayList<>();
    if (root != null) {
      findPathHelper(root, new ArrayList<>(), res);
    }
    return res;
  }

  private void findPathHelper(TreeNode root, List<String> tmpPath, List<String> paths) {
    tmpPath.add(Integer.toString(root.val));
    if (root.left == null && root.right == null) {
      paths.add(buildPath(tmpPath));
      tmpPath.remove(tmpPath.size() - 1);
      return;
    }
    if (root.left != null) {
      findPathHelper(root.left, tmpPath, paths);
    }
    if (root.right != null) {
      findPathHelper(root.right, tmpPath, paths);
    }
    tmpPath.remove(tmpPath.size() - 1);
  }

  private String buildPath(List<String> path) {
    if (path == null || path.size() == 0) {
      return "";
    }
    StringBuilder sb = new StringBuilder(path.get(0));
    for (int i = 1; i < path.size(); i++) {
      sb.append("->").append(path.get(i));
    }
    return sb.toString();
  }
}
