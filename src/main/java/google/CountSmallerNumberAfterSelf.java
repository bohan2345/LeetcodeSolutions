package google;

/**
 * nums = [5,2,6,1]
 * return [2,1,1,0]
 * <p>
 * Created by Bohan Zheng on 6/1/2016.
 *
 * @author Bohan Zheng
 */
public class CountSmallerNumberAfterSelf {
    // use a binary search tree, in each node maintain the size the tree under that node.
    // loop nums[] from right to left. when inserting each number nums[i], count the number of node less than nums[i]
    public int[] count(int[] nums) {
        int[] res = new int[nums.length];
        BinarySearchTree bst = new BinarySearchTree();
        for (int i = nums.length - 1; i >= 0; i--) {
            bst.insert(nums[i]);
            res[i] = bst.lessThan(nums[i]);
        }
        return res;
    }

    private class BinarySearchTree {
        private class TreeNode {
            int size;
            int value;
            TreeNode left, right, parent;

            TreeNode(int value) {
                this.size = 1;
                this.value = value;
            }
        }

        TreeNode root;

        private BinarySearchTree() {
            root = new TreeNode(Integer.MAX_VALUE);
        }

        private void insert(int val) {
            TreeNode node = this.root;
            TreeNode newNode = new TreeNode(val);
            newNode.parent = node;
            while (node != null) {
                node.size++;
                if (val < node.value) {
                    if (node.left == null) {
                        node.left = newNode;
                        break;
                    } else {
                        node = node.left;
                    }
                } else if (val > node.value) {
                    if (node.right == null) {
                        node.right = newNode;
                        break;
                    } else {
                        node = node.right;
                    }
                } else {
                    break;
                }
            }
        }

        private int lessThan(int val) {
            TreeNode node = this.root;
            int n = 0;
            while (node != null) {
                if (val > node.value) {
                    n += 1;
                    if (node.left != null)
                        n += node.left.size;
                    node = node.right;
                } else if (val < node.value) {
                    node = node.left;
                } else {
                    if (node.left != null)
                        n += node.left.size;
                    break;
                }
            }
            return n;
        }
    }
}
