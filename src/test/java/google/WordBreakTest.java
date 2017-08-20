package google;

import google.dp.WordBreak;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * Created by Bohan Zheng on 7/5/2016.
 *
 * @author Bohan Zheng
 */
public class WordBreakTest {
    @Test
    public void test() {
        WordBreak test = new WordBreak();
        Set<String> dic = new HashSet<>();
        dic.add("leet");
        dic.add("code");
        Assert.assertTrue(test.wordBreak("leetcode", dic));
    }

}
