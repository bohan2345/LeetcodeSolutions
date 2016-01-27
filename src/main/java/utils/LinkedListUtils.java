package utils;

/**
 * <p>
 * Created by Bohan Zheng on 1/27/2016.
 *
 * @author Bohan Zheng
 */
public class LinkedListUtils {
    public static String serialize(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val).append(',');
            head = head.next;
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static ListNode constructLinkedList(int... nums) {
        ListNode head = new ListNode(0);
        ListNode node = head;
        for (int n : nums) {
            node.next = new ListNode(n);
            node = node.next;
        }
        return head.next;
    }
}
