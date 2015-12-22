package main.tree;

import main.utils.TreeNode;

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
        return  (left == null && right == null) ||
                (isLeafNode(left) && isLeafNode(right) && left.val == right.val) ||
                !(left == null || right == null || left.val != right.val) &&
                isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    private boolean isLeafNode(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }
}
