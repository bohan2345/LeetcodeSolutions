package google;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * <p>
 * Created by Bohan Zheng on 7/6/2016.
 *
 * @author Bohan Zheng
 */
public class ArraySortTest {
    @Test
    public void test() {
        RandomArray randomArray = new RandomArray();
        for (int i = 0; i < 10; i++) {
            int[] nums = randomArray.randomArray(10);
//            Arrays.stream(nums).forEach(System.out::print);
//            System.out.println("");
            int[] expected = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
            ArraySort test = new ArraySort();
            test.mergeSort(nums);
            assertArrayEquals(expected, nums);
        }
    }

    @Test
    public void test2() {
        RandomArray randomArray = new RandomArray();
        for (int i = 0; i < 10; i++) {
            int[] nums = randomArray.randomArray(10);
//            Arrays.stream(nums).forEach(System.out::print);
//            System.out.println("");
            int[] expected = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
            ArraySort test = new ArraySort();
            test.heapSort(nums);
            assertArrayEquals(expected, nums);
        }
    }

    @Test
    public void test3() {
        RandomArray randomArray = new RandomArray();
        for (int i = 0; i < 10; i++) {
            int[] nums = randomArray.randomArray(10);
//            Arrays.stream(nums).forEach(System.out::print);
//            System.out.println("");
            int[] expected = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
            ArraySort test = new ArraySort();
            test.quickSort(nums);
            assertArrayEquals(expected, nums);
        }
    }
}
