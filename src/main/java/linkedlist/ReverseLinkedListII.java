package linkedlist;

import utils.ListNode;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * <p>
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * return 1->4->3->2->5->NULL.
 * <p>
 * Created by Bohan Zheng on 2/2/2016.
 *
 * @author Bohan Zheng
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode prev = new ListNode(0);
        prev.next = head;
        ListNode node = head;
        ListNode dumy = prev;
        int i = 1;
        while (i < n) {
            i++;
            if (i <= m) {
                prev = node;
                node = node.next;
                continue;
            }
            ListNode tmp = prev.next;
            prev.next = node.next;
            node.next = node.next.next;
            prev.next.next = tmp;
        }
        return dumy.next;
    }
}
