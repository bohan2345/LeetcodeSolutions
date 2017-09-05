package tree;

import utils.TreeNode;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * 1.The left subtree of a node contains only nodes with keys less than the node's key.<br>
 * 2.The right subtree of a node contains only nodes with keys greater than the node's key.<br>
 * 3.Both the left and right subtrees must also be binary search trees.
 * <p>
 * Created by Bohan Zheng on 12/18/15.
 *
 * @author Bohan Zheng
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root).isBst;
    }

    private ReturnType isValidBSTHelper(TreeNode root) {
        ReturnType res = new ReturnType();
        if (root == null) {
            res.isBst = true;
            return res;
        }
        if (root.left == null && root.right == null) {
            res.isBst = true;
            res.maxVal = root.val;
            res.minVal = root.val;
            return res;
        } else if (root.left == null) {
            ReturnType right = isValidBSTHelper(root.right);
            res.isBst = right.isBst && root.val < right.minVal;
            res.minVal = root.val;
            res.maxVal = right.maxVal;
            return res;
        } else if (root.right == null) {
            ReturnType left = isValidBSTHelper(root.left);
            res.isBst = left.isBst && root.val > left.maxVal;
            res.minVal = left.minVal;
            res.maxVal = root.val;
            return res;
        } else {
            ReturnType left = isValidBSTHelper(root.left);
            ReturnType right = isValidBSTHelper(root.right);
            res.isBst = left.isBst && right.isBst && root.val > left.maxVal && root.val < right.minVal;
            res.minVal = left.minVal;
            res.maxVal = right.maxVal;
            return res;
        }
    }

    private class ReturnType {
        boolean isBst;
        int maxVal;
        int minVal;
    }

    /**
     * solution 2 in-order traversal.
     */
    public boolean isValidBST2(TreeNode root) {
        return true;
    }
}
