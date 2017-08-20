package string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 4/26/2016.
 *
 * @author Bohan Zheng
 */
public class LengthOfLastWordTest {
    @Test
    public void test() {
        LengthofLastWord test = new LengthofLastWord();
        assertEquals(5, test.lengthOfLastWord("Hello World     "));
    }
}
