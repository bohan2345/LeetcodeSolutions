package linkedlist;

import utils.ListNode;

/**
 * Sort a linked list using insertion sort.
 * <p>
 * Created by Bohan Zheng on 2/16/2016.
 *
 * @author Bohan Zheng
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode prev = newHead;
        ListNode min;
        while (head != null) {
            min = removeMin(head);
            insertAfter(prev, min);
            prev = prev.next;
            head = prev.next;
        }
        return newHead.next;
    }

    private void insertAfter(ListNode prev, ListNode node) {
        if (prev.next.equals(node)) {
            return;
        }
        node.next = prev.next;
        prev.next = node;
    }

    private ListNode removeMin(ListNode head) {
        ListNode min = head, prev = new ListNode(0), minPrev = prev;
        prev.next = head;
        while (head != null) {
            minPrev = head.val < min.val ? prev : minPrev;
            min = head.val < min.val ? head : min;
            head = head.next;
            prev = prev.next;
        }
        minPrev.next = min.next;
        return min;
    }
}
