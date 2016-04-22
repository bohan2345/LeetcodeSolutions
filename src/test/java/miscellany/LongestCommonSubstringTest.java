package miscellany;

import static org.junit.Assert.*;

import miscellany.LongestCommonSubstring;
import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Created by Bohan Zheng on 4/18/2016.
 *
 * @author Bohan Zheng
 */
public class LongestCommonSubstringTest {
    @Test
    public void test() {
        LongestCommonSubstring test = new LongestCommonSubstring();
        List<String> expected = new ArrayList<>();
        expected.add("aba");
        expected.add("bab");
        assertThat(test.commonSubstring("ababd", "tbaba"), IsIterableContainingInAnyOrder.containsInAnyOrder(expected.toArray()));
    }
}
