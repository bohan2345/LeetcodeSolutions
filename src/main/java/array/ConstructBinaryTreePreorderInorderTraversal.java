package array;


import utils.TreeNode;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * <p>
 * Created by Bohan Zheng on 11/27/2015.
 *
 * @author Bohan Zheng
 */
public class ConstructBinaryTreePreorderInorderTraversal {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder.length == 0 || inorder.length != preorder.length) {
      return null;
    }
    return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
  }

  private TreeNode build(int[] preorder, int pstart, int pend, int[] inorder, int istart, int iend) {
    if (pstart > pend) {
      return null;
    }
    TreeNode root = new TreeNode(preorder[pstart]);
    int p = istart;
    for (; p <= iend; p++) {
      if (inorder[p] == preorder[pstart]) {
        break;
      }
    }
    root.left = build(preorder, pstart + 1, pstart + p - istart, inorder, istart, p - 1);
    root.right = build(preorder, pstart + p - istart + 1, pend, inorder, p + 1, iend);
    return root;
  }
}
