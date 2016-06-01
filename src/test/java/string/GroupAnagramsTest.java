package string;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * Created by Bohan Zheng on 5/2/2016.
 *
 * @author Bohan Zheng
 */
public class GroupAnagramsTest {
    @Test
    public void test() {
        GroupAnagrams test = new GroupAnagrams();
        List<List<String>> expected = new ArrayList<>();
        expected.add(Arrays.asList("ate", "eat", "tea"));
        expected.add(Arrays.asList("nat", "tan"));
        expected.add(Arrays.asList("bat"));
        List<List<String>> actual = test.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        Assert.assertEquals(expected.size(), actual.size());
    }
}
