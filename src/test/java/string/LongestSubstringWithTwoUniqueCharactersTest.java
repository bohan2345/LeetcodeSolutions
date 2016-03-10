package string;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * <p>
 * Created by Bohan Zheng on 3/9/2016.
 *
 * @author Bohan Zheng
 */
public class LongestSubstringWithTwoUniqueCharactersTest {
    @Test
    public void test() {
        LongestSubstringWithTwoUniqueCharacters test = new LongestSubstringWithTwoUniqueCharacters();
        assertEquals("ab", test.maxSubString2UniqueChars("ab"));
    }
}
