package google.dp;

import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * The thief has found himself a new place for his thievery again. There is only one entrance
 * to this area, called the "root." Besides the root, each house has one and only one parent
 * house. After a tour, the smart thief realized that "all houses in this place forms a binary tree".
 * It will automatically contact the police if two directly-linked houses were broken into on the same night.
 * <p>
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 * Example 1:
 * 3
 * / \
 * 2   3
 * \   \
 * 3   1
 * Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * Example 2:
 * 3
 * / \
 * 4   5
 * / \   \
 * 1   3   1
 * Maximum amount of money the thief can rob = 4 + 5 = 9.
 * <p>
 * Created by Bohan Zheng on 6/21/2016.
 *
 * @author Bohan Zheng
 */
public class HouseRobberIII {
    private Map<TreeNode, Integer> map = new HashMap<>();
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (map.containsKey(root)) {
            return map.get(root);
        }
        int sum1 = root.val;
        int sum2 = 0;
        if (root.left != null) {
            sum2 += rob(root.left);
            if (root.left.left != null) {
                sum1 += rob(root.left.left);
            }
            if (root.left.right != null) {
                sum1 += rob(root.left.right);
            }
        }
        if (root.right != null) {
            sum2 += rob(root.right);
            if (root.right.left != null) {
                sum1 += rob(root.right.left);
            }
            if (root.right.right != null) {
                sum1 += rob(root.right.right);
            }
        }
        int sum = Math.max(sum1, sum2);
        map.put(root, sum);
        return sum;
    }
}
