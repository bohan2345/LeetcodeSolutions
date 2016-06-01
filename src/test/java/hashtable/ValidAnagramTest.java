package hashtable;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * <p>
 * Created by Bohan Zheng on 3/6/16.
 *
 * @author Bohan Zheng
 */
public class ValidAnagramTest {
    @Test
    public void test() {
        ValidAnagram test = new ValidAnagram();
        assertTrue(test.isAnagram2("ab", "ba"));
    }

    @Test
    public void test2() {
        ValidAnagram test = new ValidAnagram();
        assertFalse(test.isAnagram2("aaaaaa", "bbbbbb"));
    }
}