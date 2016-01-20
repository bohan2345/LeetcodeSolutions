package tree;

import utils.TreeNode;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * <p>
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * <p>
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
 * How would you optimize the kthSmallest routine?
 * <p>
 * Created by Bohan Zheng on 1/4/2016.
 *
 * @author Bohan Zheng
 */
public class KthSmallestElementinaBST {
    public int kthSmallest(TreeNode root, int k) {
        int[] kth = new int[]{k};
        int[] val = new int[1];
        inOrder(root, kth, val);
        return val[0];
    }

    private void inOrder(TreeNode root, int[] k, int[] val) {
        if (root == null) {
            return;
        }
        inOrder(root.left, k, val);
        if (k[0] == 1) {
            val[0] = root.val;
            k[0]--;
            return;
        }
        k[0]--;
        inOrder(root.right, k, val);
    }

    /**
     * Follow up Method: Augmented  Tree Data Structure.
     * The idea is to maintain rank of each node. We can keep track of elements in a subtree of any node
     * while building the tree. Since we need K-th smallest element, we can maintain number of elements
     * of left subtree in every node.
     * Assume that the root is having N nodes in its left subtree. If K = N + 1, root is K-th node.
     * If K < N, we will continue our search (recursion) for the Kth smallest element in the left subtree of root.
     * If K > N + 1, we continue our search in the right subtree for the (K – N – 1)-th smallest element.
     * Note that we need the count of elements in left subtree only.
     * Time complexity: O(h) where h is height of tree.
     */
}
