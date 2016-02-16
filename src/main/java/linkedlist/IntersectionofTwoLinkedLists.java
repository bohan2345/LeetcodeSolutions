package linkedlist;

import utils.ListNode;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * <p>
 * For example, the following two linked lists:
 * A:          a1 → a2
 *                      ↘
 *                        c1 → c2 → c3
 *                      ↗
 * B:     b1 → b2 → b3
 * begin to intersect at node c1.
 * <p>
 * Notes:
 *   -If the two linked lists have no intersection at all, return null.
 *   -The linked lists must retain their original structure after the function returns.
 *   -You may assume there are no cycles anywhere in the entire linked structure.
 *   -Your code should preferably run in O(n) time and use only O(1) memory.
 * <p>
 * Created by Bohan Zheng on 2/16/2016.
 *
 * @author Bohan Zheng
 */
public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = getLength(headA), lengthB = getLength(headB);
        int n = 0;
        if (lengthA > lengthB) {
            headA = moveForward(headA, lengthA - lengthB);
        } else {
            headB = moveForward(headB, lengthB - lengthA);
        }
        while (headA != null && headB != null) {
            if (headA.equals(headB)) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    private ListNode moveForward(ListNode head, int n) {
        while (n > 0) {
            n--;
            head = head.next;
        }
        return head;
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
