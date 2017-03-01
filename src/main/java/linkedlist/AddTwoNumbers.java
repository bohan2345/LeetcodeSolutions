package linkedlist;

import utils.ListNode;

/**
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order
 * and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * <p>
 * Created by Bohan Zheng on 2/17/2016.
 *
 * @author Bohan Zheng
 */
public class AddTwoNumbers {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    return add(l1, l2, 0);
  }

  private ListNode add(ListNode l1, ListNode l2, int carry) {
    if (l1 == null && l2 == null && carry == 0) {
      return null;
    }
    int n = carry;
    ListNode ln1 = null, ln2 = null;
    if (l1 != null) {
      n += l1.val;
      ln1 = l1.next;
    }
    if (l2 != null) {
      n += l2.val;
      ln2 = l2.next;
    }
    carry = n / 10;
    n = n % 10;
    ListNode head = new ListNode(n);
    head.next = add(ln1, ln2, carry);
    return head;
  }
}
