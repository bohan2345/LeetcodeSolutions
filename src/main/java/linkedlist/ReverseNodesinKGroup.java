package linkedlist;

import utils.ListNode;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 * <p>
 * For example,
 * Given this linked list: 1->2->3->4->5<br>
 * For k = 2, you should return: 2->1->4->3->5<br>
 * For k = 3, you should return: 3->2->1->4->5
 * <p>
 * Created by Bohan Zheng on 2/2/2016.
 *
 * @author Bohan Zheng
 */
public class ReverseNodesinKGroup {
  public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null || k > getLength(head)) {
      return head;
    }
    ListNode prev = new ListNode(0);
    prev.next = head;
    int i = 1;
    while (i < k) {
      ListNode next = head.next;
      head.next = next.next;
      next.next = prev.next;
      prev.next = next;
      i++;
    }
    head.next = reverseKGroup(head.next, k);
    return prev.next;
  }

  private int getLength(ListNode head) {
    int leng = 0;
    while (head != null) {
      head = head.next;
      leng++;
    }
    return leng;
  }
}
