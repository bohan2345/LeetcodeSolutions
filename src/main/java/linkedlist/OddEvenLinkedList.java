package linkedlist;

import utils.ListNode;

/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking
 * about the node number and not the value in the nodes.
 * <p>
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 * <p>
 * Example:
 * Given 1->2->3->4->5->NULL,
 * return 1->3->5->2->4->NULL.
 * <p>
 * Note:
 * The relative order inside both the even and odd groups should remain as it was in the input.
 * The first node is considered odd, the second node even and so on ...
 * <p>
 * Created by Bohan Zheng on 2/11/2016.
 *
 * @author Bohan Zheng
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        int i = 0;
        ListNode head1 = new ListNode(0), head2 = new ListNode(0);
        ListNode newHead = head1, newHead2 = head2;
        ListNode node = head;
        while (node != null) {
            ListNode next = node.next;
            node.next = null;
            if (i % 2 == 0) {
                head1.next = node;
                head1 = head1.next;
            } else {
                head2.next = node;
                head2 = head2.next;
            }
            node = next;
            i++;
        }
        head1.next = newHead2.next;
        return newHead.next;
    }
}
