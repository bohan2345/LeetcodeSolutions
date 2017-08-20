package linkedlist;

import org.junit.Assert;
import org.junit.Test;
import utils.LinkedListUtils;
import utils.ListNode;

/**
 * Created by bohan on 9/27/2016.
 *
 * @author Bohan Zheng
 */
public class SwapTwoNodeInLinkedlistTest {
    @Test
    public void test() {
        SwapTwoNodeInLinkedlist test = new SwapTwoNodeInLinkedlist();
        ListNode head = LinkedListUtils.constructLinkedList(1, 2, 3, 4, 5, 6, 7, 8);
        ListNode newHead = test.swapNodes(head, 2, 6);
        Assert.assertEquals("1,6,3,4,5,2,7,8", LinkedListUtils.serialize(newHead));
    }

    @Test
    public void test2() {
        SwapTwoNodeInLinkedlist test = new SwapTwoNodeInLinkedlist();
        ListNode head = LinkedListUtils.constructLinkedList(1, 2, 3, 4);
        ListNode newHead = test.swapNodes(head, 2, 4);
        Assert.assertEquals("1,4,3,2", LinkedListUtils.serialize(newHead));
    }

    @Test
    public void test3() {
        SwapTwoNodeInLinkedlist test = new SwapTwoNodeInLinkedlist();
        ListNode head = LinkedListUtils.constructLinkedList(1, 2, 3, 4);
        ListNode newHead = test.swapNodes(head, 1, 2);
        Assert.assertEquals("2,1,3,4", LinkedListUtils.serialize(newHead));
    }
}
