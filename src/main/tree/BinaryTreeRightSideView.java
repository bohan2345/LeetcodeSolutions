package main.tree;

import main.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 * For example:
 * Given the following binary tree,
 * 1            <---
 * /   \
 * 2     3         <---
 * \
 * 5             <---
 * You should return [1, 3, 5]
 * <p>
 * Created by Bohan Zheng on 1/14/2016.
 *
 * @author Bohan Zheng
 */
public class BinaryTreeRightSideView {
    /**
     * level order (BFS)
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int cur = 1, next = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            cur--;
            if (node.left != null) {
                queue.add(node.left);
                next++;
            }
            if (node.right != null) {
                queue.add(node.right);
                next++;
            }
            if (cur == 0) {
                res.add(node.val);
                cur = next;
                next = 0;
            }
        }
        return res;
    }

    /**
     * DFS
     */
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        boolean[] levelBeenSet = new boolean[getTreeHeight(root)];
        dfsHelper(root, res, levelBeenSet, 0);
        return res;
    }

    private int getTreeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getTreeHeight(root.left), getTreeHeight(root.right)) + 1;
    }

    private void dfsHelper(TreeNode root, List<Integer> res, boolean[] levelBeenSet, int level) {
        if (!levelBeenSet[level]) {
            res.add(root.val);
            levelBeenSet[level] = true;
        }
        level++;
        if (root.right != null)
            dfsHelper(root.right, res, levelBeenSet, level);
        if (root.left != null)
            dfsHelper(root.left, res, levelBeenSet, level);
        level--;
    }
}
