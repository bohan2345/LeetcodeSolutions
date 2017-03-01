package linkedlist;

import utils.ListNode;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * You must do this in-place without altering the nodes' values.
 * <p>
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * <p>
 * Created by Bohan Zheng on 2/2/2016.
 *
 * @author Bohan Zheng
 */
public class ReorderList {
  public void reorderList(ListNode head) {
    // divide
    int length = getLength(head);
    int l = length / 2;
    ListNode node = head;
    while (l > 1) {
      l--;
      node = node.next;
    }
    ListNode head2 = node.next;
    node.next = null;
    // reverse second list
    head2 = new ReverseLinkedList().reverseList(head2);
    // merge
    merge(head, head2);
  }

  private int getLength(ListNode head) {
    int leng = 0;
    while (head != null) {
      head = head.next;
      leng++;
    }
    return leng;
  }

  private void merge(ListNode head1, ListNode head2) {
    ListNode head = head1;
    head1 = head1.next;
    int i = 0;
    ListNode node = head;
    while (head1 != null && head2 != null) {
      if (i % 2 == 0) {
        node.next = head2;
        head2 = head2.next;
      } else {
        node.next = head1;
        head1 = head1.next;
      }
      node = node.next;
      i++;
    }
    node.next = head1 == null ? head2 : head1;
  }
}
