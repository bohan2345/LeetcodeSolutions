package linkedlist;

import utils.ListNode;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * <p>
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * <p>
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 * <p>
 * Created by Bohan Zheng on 2/9/2016.
 *
 * @author Bohan Zheng
 */
public class PartitionList {
  public ListNode partition(ListNode head, int x) {
    ListNode head1 = new ListNode(0);
    ListNode head2 = new ListNode(0);
    ListNode node1 = head1, node2 = head2;
    while (head != null) {
      ListNode next = head.next;
      head.next = null;
      if (head.val < x) {
        node1.next = head;
        node1 = node1.next;
      } else {
        node2.next = head;
        node2 = node2.next;
      }
      head = next;
    }
    node1.next = head2.next;
    head2.next = null;
    return head1.next;
  }
}
