package main.tree;

import main.utils.TreeNode;

import java.util.Stack;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * <p>
 * Recover the tree without changing its structure.
 * <p>
 * Note:
 * A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 * <p>
 * Created by Bohan Zheng on 12/29/15.
 *
 * @author Bohan Zheng
 */
public class RecoverBinarySearchTree {
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode next = root.left;
        int count = 0;
        TreeNode last = null, a = root, b = root;
        while (!stack.isEmpty() || next != null) {
            if (next != null) {
                stack.push(next);
                next = next.left;
            } else {
                TreeNode node = stack.pop();
                if (last != null && last.val > node.val) {
                    if (count == 0) {
                        a = last;
                        b = node;
                        count++;
                    } else {
                        b = node;
                        break;
                    }
                }
                last = node;
                next = node.right;
            }
        }
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }
}
