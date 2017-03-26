package array;

import utils.TreeNode;

/**
 * <p>
 * Created by Bohan Zheng on 11/27/2015.
 *
 * @author Bohan Zheng
 */
public class ConstructBinaryTreeInorderPostorderTraversal {
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    if (postorder.length == 0 || inorder.length != postorder.length) {
      return null;
    }
    return build(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
  }

  private TreeNode build(int[] postorder, int pstart, int pend, int[] inorder, int istart, int iend) {
    if (pstart > pend) {
      return null;
    }
    TreeNode root = new TreeNode(postorder[pend]);
    int p = istart;
    for (; p <= iend; p++) {
      if (inorder[p] == postorder[pend]) {
        break;
      }
    }
    root.left = build(postorder, pstart, pstart + p - istart - 1, inorder, istart, p - 1);
    root.right = build(postorder, pstart + p - istart, pend - 1, inorder, p + 1, iend);
    return root;
  }
}
