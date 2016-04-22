package miscellany;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * <p>
 * Created by Bohan Zheng on 3/22/2016.
 *
 * @author Bohan Zheng
 */
public class KMPAlgorithmTest {
    @Test
    public void test() {
        KMPAlgorithm test = new KMPAlgorithm();
        String pattern = "ABCDABD";
//        System.out.println(pattern.substring(2,5));
        assertEquals(15, test.findMatch("ABC ABCDAB ABCDABCDABDE", pattern));
    }
    @Test
    public void test2() {
        KMPAlgorithm test = new KMPAlgorithm();
        String pattern = "a";
//        System.out.println(pattern.substring(2,5));
        assertEquals(0, test.findMatch("a", pattern));
    }
}
