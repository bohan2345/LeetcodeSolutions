package string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <p>
 * Created by Bohan Zheng on 4/18/2016.
 *
 * @author Bohan Zheng
 */
public class LongestSubstringWithoutRepeatingCharactersTest {
    @Test
    public void test() {
        LongestSubstringWithoutRepeatingCharacters test = new LongestSubstringWithoutRepeatingCharacters();
        assertEquals(3, test.lengthOfLongestSubstring("abcabcbb"));
    }

    @Test
    public void test2() {
        LongestSubstringWithoutRepeatingCharacters test = new LongestSubstringWithoutRepeatingCharacters();
        assertEquals(1, test.lengthOfLongestSubstring("bbbbb"));
    }

    @Test
    public void test3() {
        LongestSubstringWithoutRepeatingCharacters test = new LongestSubstringWithoutRepeatingCharacters();
        assertEquals(3, test.lengthOfLongestSubstring("pwwkew"));
    }
}
