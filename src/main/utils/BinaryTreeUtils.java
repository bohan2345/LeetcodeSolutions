package main.utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * utility class to simplify test for binary tree
 * <p>
 * Created by Bohan Zheng on 11/27/2015.
 *
 * @author Bohan Zheng
 */
public class BinaryTreeUtils {
    public static List<String> serializeBinaryTree(TreeNode root) {
        List<String> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                res.add("#");
                continue;
            }
            res.add(Integer.toString(node.val));
            queue.offer(node.left);
            queue.offer(node.right);
        }
        for (int i = res.size() - 1; i >= 0; i--) {
            if (!res.get(i).equals("#")) {
                break;
            }
            res.remove(i);
        }
        return res;
    }

    public static TreeNode constructBinaryTree(List<String> nodes) {
        Queue<String> queue = new LinkedList<>(nodes);
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(queue.poll()));
        nodeQueue.offer(root);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            if (queue.isEmpty()) {
                break;
            }
            String leftVal = queue.poll();
            if (leftVal != null && !leftVal.equals("#")) {
                node.left = new TreeNode(Integer.valueOf(leftVal));
                nodeQueue.offer(node.left);
            }
            String rightVal = queue.poll();
            if (rightVal != null && !rightVal.equals("#")) {
                node.right = new TreeNode(Integer.valueOf(rightVal));
                nodeQueue.offer(node.right);
            }
        }
        return root;
    }

    public static TreeNode constructBinaryTree(int... nums) {
        List<String> nodes = new ArrayList<>(nums.length);
        for (int n : nums) {
            nodes.add(Integer.toString(n));
        }
        return constructBinaryTree(nodes);
    }
}
