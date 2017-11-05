import java.util.ArrayList;
import java.util.List;

/**
 * <br>
 * Created by Bohan Zheng on 9/10/2015.
 *
 * @author Bohan Zheng
 */
public class MainTest {
    class Node {
        Node left;
        Node right;
        int val;
        int size;

        Node(int val, int size) {
            this.val = val;
            this.size = size;
        }
    }

    int sum = 0;
    public List<Integer> countSmaller(int[] nums) {
        Node root = new Node(nums[0], 1);
        List<Integer> result = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            sum = 0;
            result.add(insert(root, nums[i]));
        }
        return result;
    }

    private int insert(Node root, int num) {
        if (root.val == num) {
            root.size++;
            return (root.left == null ? 0 : root.left.size) + sum;
        } else if (root.val < num) {
            sum += root.size - (root.right == null ? 0 : root.right.size);
            root.size++;
            if (root.right == null) {
                Node n = new Node(num, 1);
                root.right = n;
                return sum;
            }
            return insert(root.right, num);
        } else { // root.val > num
            root.size++;
            if (root.left == null) {
                Node n = new Node(num, 1);
                root.left = n;
                return sum;
            }
            return insert(root.left, num);
        }
    }
}