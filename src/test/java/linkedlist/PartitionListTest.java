package linkedlist;

import static org.junit.Assert.*;

import org.junit.Test;
import utils.LinkedListUtils;
import utils.ListNode;

/**
 * <p>
 * Created by Bohan Zheng on 2/9/2016.
 *
 * @author Bohan Zheng
 */
public class PartitionListTest {
    @Test
    public void test() {
        PartitionList test = new PartitionList();
        ListNode head = LinkedListUtils.constructLinkedList(5, 4, 3, 2, 1);
        assertEquals("2,1,5,4,3", LinkedListUtils.serialize(test.partition(head, 3)));
    }
}