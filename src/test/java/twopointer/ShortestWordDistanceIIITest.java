package twopointer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 1/17/17.
 *
 * @author Bohan Zheng
 */
public class ShortestWordDistanceIIITest {
    @Test
    public void test() {
        ShortestWordDistanceIII test = new ShortestWordDistanceIII();
        String[] words = {"a", "b", "c", "d", "b"};
        assertEquals(1, test.shortestWordDistance(words, "b", "d"));
    }

    @Test
    public void test2() {
        ShortestWordDistanceIII test = new ShortestWordDistanceIII();
        String[] words = {"a", "b", "c", "d", "b"};
        assertEquals(3, test.shortestWordDistance(words, "b", "b"));
    }

    @Test
    public void test3() {
        ShortestWordDistanceIII test = new ShortestWordDistanceIII();
        String[] words = {"a", "b"};
        assertEquals(1, test.shortestWordDistance(words, "a", "b"));
    }

    @Test
    public void test4() {
        ShortestWordDistanceIII test = new ShortestWordDistanceIII();
        String[] words = {"a", "b"};
        assertEquals(1, test.shortestWordDistance(words, "b", "a"));
    }
}