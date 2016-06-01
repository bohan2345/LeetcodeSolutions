package linkedlist;

import utils.ListNode;

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * <p>
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 * <p>
 * Created by Bohan Zheng on 2/2/2016.
 *
 * @author Bohan Zheng
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        k %= length;
        if (k == 0) {
            return head;
        }
        int n = length - k;
        ListNode node = head;
        while (n > 1) {
            node = node.next;
            n--;
        }
        ListNode newHead = node.next;
        node.next = null;
        tail.next = head;
        return newHead;
    }
}