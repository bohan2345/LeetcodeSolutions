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
        return root == null || isValidBSTHelper(root)[0] == 1;
    }

    /**
     * @param root
     *         root
     * @return {isValid ? 1 : 0, minValue, maxValue}
     */
    public int[] isValidBSTHelper(TreeNode root) {
        if (root == null) {
            return null;
        }
        int[] res = new int[3]; // res[0] if this tree is a BST, res[1] largest num, res[2] smallest num
        int[] left = isValidBSTHelper(root.left);
        int[] right = isValidBSTHelper(root.right);
        if (left != null && right != null) {
            res[0] = (left[0] == 1 && right[0] == 1 && left[2] < root.val && root.val < right[1]) ? 1 : 0;
            res[1] = left[1];
            res[2] = right[2];
        } else if (left == null && right != null) {
            res[0] = (right[0] == 1 && root.val < right[1]) ? 1 : 0;
            res[1] = root.val;
            res[2] = right[2];
        } else if (left != null && right == null) {
            res[0] = (left[0] == 1 && root.val > left[2]) ? 1 : 0;
            res[1] = left[1];
            res[2] = root.val;
        } else {
            res[0] = 1;
            res[1] = root.val;
            res[2] = root.val;
        }
        return res;
    }

    /**
     * solution 2 in-order traversal.
     *
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        return true;
    }
}
