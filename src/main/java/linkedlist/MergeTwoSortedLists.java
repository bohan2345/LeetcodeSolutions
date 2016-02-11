package linkedlist;

import utils.ListNode;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing
 * together the nodes of the first two lists.
 * <p>
 * Created by Bohan Zheng on 2/11/2016.
 *
 * @author Bohan Zheng
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0);
        ListNode node = newHead;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                node.next = l2;
                l2 = l2.next;
            } else {
                node.next = l1;
                l1 = l1.next;
            }
            node = node.next;
        }
        node.next = l1 == null ? l2 : l1;
        return newHead.next;
    }
}
