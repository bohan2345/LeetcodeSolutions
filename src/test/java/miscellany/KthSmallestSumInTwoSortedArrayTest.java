package miscellany;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 11/23/16.
 *
 * @author Bohan Zheng
 */
public class KthSmallestSumInTwoSortedArrayTest {
    @Test
    public void test() {
        int[] A = {1, 7, 11};
        int[] B = {2, 4, 6};
        KthSmallestSumInTwoSortedArray test = new KthSmallestSumInTwoSortedArray();
        assertEquals(3, test.find(A, B, 1));
    }

    @Test
    public void test2() {
        int[] A = {1, 7, 11};
        int[] B = {2, 4, 6};
        KthSmallestSumInTwoSortedArray test = new KthSmallestSumInTwoSortedArray();
        assertEquals(7, test.find(A, B, 3));
    }
}