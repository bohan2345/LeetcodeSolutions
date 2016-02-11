package linkedlist;

import static org.junit.Assert.*;

import org.junit.Test;
import utils.LinkedListUtils;
import utils.ListNode;

/**
 * <p>
 * Created by Bohan Zheng on 2/11/2016.
 *
 * @author Bohan Zheng
 */
public class PalindromeLinkedListTest {
    @Test
    public void test() {
        PalindromeLinkedList test = new PalindromeLinkedList();
        ListNode head = LinkedListUtils.constructLinkedList(1, 2, 3, 2, 1);
        assertTrue(test.isPalindrome(head));
    }

    @Test
    public void test2() {
        PalindromeLinkedList test = new PalindromeLinkedList();
        ListNode head = LinkedListUtils.constructLinkedList(1, 2, 3, 3, 2, 1);
        assertTrue(test.isPalindrome(head));
    }
}
