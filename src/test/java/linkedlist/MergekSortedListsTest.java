package linkedlist;

import static org.junit.Assert.*;

import org.junit.Test;
import utils.LinkedListUtils;
import utils.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Created by Bohan Zheng on 2/11/2016.
 *
 * @author Bohan Zheng
 */
public class MergekSortedListsTest {
    @Test
    public void test() {
        ListNode l1 = LinkedListUtils.constructLinkedList(1, 4);
        ListNode l2 = LinkedListUtils.constructLinkedList(2);
        ListNode l3 = LinkedListUtils.constructLinkedList(3, 5);
        ListNode[] lists = new ListNode[]{l1, l2, l3};
        MergekSortedLists test = new MergekSortedLists();
        assertEquals("1,2,3,4,5", LinkedListUtils.serialize(test.mergeKLists(lists)));
    }
}
