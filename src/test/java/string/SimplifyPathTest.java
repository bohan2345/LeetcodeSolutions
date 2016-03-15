package string;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * <p>
 * Created by Bohan Zheng on 3/14/2016.
 *
 * @author Bohan Zheng
 */
public class SimplifyPathTest {
    @Test
    public void test() {
        SimplifyPath test = new SimplifyPath();
        assertEquals("/c", test.simplifyPath("/a/./////b/../../c/"));
    }

    @Test
    public void test2() {
        SimplifyPath test = new SimplifyPath();
        assertEquals("/", test.simplifyPath("/../"));
    }

    @Test
    public void test3() {
        SimplifyPath test = new SimplifyPath();
        assertEquals("/abc/...", test.simplifyPath("/abc/..."));
    }
}
