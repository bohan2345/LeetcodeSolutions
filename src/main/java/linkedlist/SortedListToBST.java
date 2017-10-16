package linkedlist;

import utils.ListNode;
import utils.TreeNode;

public class SortedListToBST {


    public TreeNode sortedListToBST(ListNode head) {
        return helper(head, null);
    }

    private TreeNode helper(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }

        if (head.next == tail) {
            return new TreeNode(head.val);
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow;

        TreeNode leftNode = helper(head, mid);
        TreeNode rightNode = helper(mid.next, tail);

        TreeNode root = new TreeNode(mid.val);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }
}
