package linkedlist;

import utils.ListNode;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * <p>
 * Created by Bohan Zheng on 2/2/2016.
 *
 * @author Bohan Zheng
 */
public class SortList {
  public ListNode sortList(ListNode head) {
    if (head == null) {
      return null;
    }
    if (head.next == null) {
      return head;
    }
    // divide
    int length = getLength(head);
    int mid = length / 2;
    ListNode node = head;
    while (mid > 1) {
      mid--;
      node = node.next;
    }
    ListNode node2 = node.next;
    node.next = null;
    ListNode head1 = sortList(head);
    ListNode head2 = sortList(node2);
    // combine
    return combine(head1, head2);
  }

  private int getLength(ListNode head) {
    int leng = 0;
    while (head != null) {
      head = head.next;
      leng++;
    }
    return leng;
  }

  private ListNode combine(ListNode head1, ListNode head2) {
    ListNode head = new ListNode(0);
    ListNode node = head;
    while (head1 != null && head2 != null) {
      if (head1.val > head2.val) {
        node.next = head2;
        head2 = head2.next;
      } else {
        node.next = head1;
        head1 = head1.next;
      }
      node = node.next;
    }
    node.next = head1 == null ? head2 : head1;
    return head.next;
  }
}
