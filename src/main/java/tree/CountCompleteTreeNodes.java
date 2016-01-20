package tree;

import utils.TreeNode;

/**
 * Given a complete binary tree, count the number of nodes.
 * <p>
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled,
 * and all nodes in the last level are as far left as possible. It can have between 1 and 2^h nodes inclusive at the last level h.
 * <p>
 * Created by Bohan Zheng on 1/5/2016.
 *
 * @author Bohan Zheng
 */
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);
        if (leftHeight == rightHeight) {
            return (1 << (rightHeight + 1)) - 1;
        } else {
            return (1 << (rightHeight + 1)) - 1 + numOfNodesAtLastLvl(root, leftHeight + 1);
        }
    }

    /**
     * count the total number of nodes in the last level
     *
     * @param root
     *         root of the tree
     * @param height
     *         total height the tree
     * @return total number of nodes in the last level
     */
    public int numOfNodesAtLastLvl(TreeNode root, int height) {
        int maxNum = (1 << (height - 1));
        int left = 0, right = maxNum - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nodeExists(root, mid, height)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    /**
     * check if Node exists for the given path
     *
     * @param root
     *         root of the tree
     * @param val
     *         path, encoded in decemal value, this value will be decoded into binary as 0 go left and 1 go right
     * @param height
     *         height of the tree
     * @return true if node exists
     */
    public boolean nodeExists(TreeNode root, int val, int height) {
        for (int i = height - 2; i >= 0; --i) {
            if ((val & (1 << i)) > 0) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return root != null;
    }

    private int getLeftHeight(TreeNode root) {
        int height = 0;
        while (root.left != null) {
            root = root.left;
            height++;
        }
        return height;
    }

    private int getRightHeight(TreeNode root) {
        int height = 0;
        while (root.right != null) {
            root = root.right;
            height++;
        }
        return height;
    }

    //TLE
    public int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);
        return leftHeight == rightHeight ? (1 << (leftHeight + 1)) - 1 : countNodes2(root.left) + countNodes2(root.right) + 1;
    }
}
