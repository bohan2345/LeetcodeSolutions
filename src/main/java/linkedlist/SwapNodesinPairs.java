package linkedlist;

import utils.ListNode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * <p>
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 * <p>
 * Created by Bohan Zheng on 1/26/2016.
 *
 * @author Bohan Zheng
 */
public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dumyNode = new ListNode(0);
        dumyNode.next = head;

        ListNode prev = dumyNode;
        ListNode a = head;
        while (a != null && a.next != null) {
            ListNode b = a.next;
            a.next = b.next;
            b.next = a;
            prev.next = b;
            prev = a;
            a = a.next;
        }
        return dumyNode.next;
    }
}
