package linkedlist;

import utils.ListNode;

/**
 * Given a singly linked list, determine if it is a palindrome.
 * <p>
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 * <p>
 * Created by Bohan Zheng on 2/11/2016.
 *
 * @author Bohan Zheng
 */
public class PalindromeLinkedList {
  public boolean isPalindrome(ListNode head) {
    if (head == null) {
      return true;
    }
    int leng = getLength(head);
    int i = leng / 2;
    ListNode d2 = head;
    while (i > 1) {
      i--;
      d2 = d2.next;
    }
    ListNode head2 = d2.next;
    d2.next = null;
    head2 = reverseList(head2);
    while (head != null && head2 != null) {
      if (head.val != head2.val) {
        return false;
      }
      head = head.next;
      head2 = head2.next;
    }

    return head2 == null || head2.next == null;
  }

  private ListNode reverseList(ListNode head) {
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

  private int getLength(ListNode head) {
    int leng = 0;
    while (head != null) {
      head = head.next;
      leng++;
    }
    return leng;
  }
}
