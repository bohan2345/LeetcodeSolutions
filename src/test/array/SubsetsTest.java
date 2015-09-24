package test.array;

import main.array.Subsets;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * <br>
 * Created by Bohan Zheng on 9/3/2015.
 *
 * @author Bohan Zheng
 */
public class SubsetsTest {
    Subsets test = new Subsets();

    @Test
    public void test() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> expected = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        List<Integer> l3 = new ArrayList<>();
        List<Integer> l4 = new ArrayList<>();
        List<Integer> l5 = new ArrayList<>();
        List<Integer> l6 = new ArrayList<>();
        List<Integer> l7 = new ArrayList<>();

        l1.add(1);

        l2.add(2);

        l3.add(3);

        l4.add(1);
        l4.add(2);

        l5.add(1);
        l5.add(3);

        l6.add(2);
        l6.add(3);

        l7.add(1);
        l7.add(2);
        l7.add(3);

        expected.add(l);
        expected.add(l1);
        expected.add(l2);
        expected.add(l3);
        expected.add(l4);
        expected.add(l5);
        expected.add(l6);
        expected.add(l7);

        List<List<Integer>> actual = test.subsets(nums);
        assertTrue(expected.containsAll(actual) && actual.containsAll(expected));
    }
}
