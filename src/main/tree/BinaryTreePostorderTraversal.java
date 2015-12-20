package main.tree;

import main.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <p>
 * Created by Bohan Zheng on 12/18/15.
 *
 * @author Bohan Zheng
 */
public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode prev = null;
        while (!stack.isEmpty()) {
            TreeNode curr = stack.peek();
            if (prev == null || curr.equals(prev.left) || curr.equals(prev.right)) {
                // moving down the tree
                if (curr.left != null) {
                    stack.push(curr.left);
                } else if (curr.right != null) {
                    stack.push(curr.right);
                } else {
                    res.add(curr.val);
                    stack.pop();
                }
            } else if (prev.equals(curr.left)) {
                // moving up from left
                if (curr.right == null) {
                    stack.pop();
                    res.add(curr.val);
                } else {
                    stack.push(curr.right);
                }
            } else if (prev.equals(curr.right)) {
                // moving up from right
                res.add(curr.val);
                stack.pop();
            }
            prev = curr;
        }
        return res;
    }
}
