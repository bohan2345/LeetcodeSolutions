package linkedlist;

import utils.ListNode;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * <p>
 * Note: Do not modify the linked list.
 * <p>
 * Created by Bohan Zheng on 2/11/16.
 *
 * @author Bohan Zheng
 */
public class LinkedListCycleII {
  public ListNode detectCycle(ListNode head) {
    if (head == null || head.next == null)
      return null;
    ListNode fast = head.next.next, slow = head.next;
    while (fast != null) {
      if (fast.equals(slow)) {
        break;
      }
      fast = fast.next == null ? null : fast.next.next;
      slow = slow.next;
    }
    if (fast == null) {
      return null;
    }
    slow = head;
    while (!fast.equals(slow)) {
      fast = fast.next;
      slow = slow.next;
    }
    return fast;
  }
}
