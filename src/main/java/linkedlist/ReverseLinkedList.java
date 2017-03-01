package linkedlist;

import utils.ListNode;

/**
 * Reverse a singly linked list.
 * <p>
 * Created by Bohan Zheng on 2/2/2016.
 *
 * @author Bohan Zheng
 */
public class ReverseLinkedList {
  //iteratively
  public ListNode reverseList(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode dumy = new ListNode(0);
    dumy.next = head;
    while (head.next != null) {
      ListNode next = head.next;
      head.next = next.next;
      next.next = dumy.next;
      dumy.next = next;
    }
    return dumy.next;
  }

  //recursively
  public ListNode reverseList2(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode nextNode = reverseList2(head.next);
    head.next.next = head;
    head.next = null;
    return nextNode;
  }
}
