package google;

import org.junit.Assert;
import org.junit.Test;

/**
 * <p>
 * Created by Bohan Zheng on 7/1/16.
 *
 * @author Bohan Zheng
 */
public class UniqueWordAbbreviationTest {
    @Test
    public void test() {
        String[] dic = {"deer", "door", "cake", "card"};
        UniqueWordAbbreviation test = new UniqueWordAbbreviation(dic);
        Assert.assertFalse(test.isUnique("dear"));
        Assert.assertTrue(test.isUnique("cart"));
        Assert.assertFalse(test.isUnique("cane"));
        Assert.assertTrue(test.isUnique("make"));
        Assert.assertFalse(test.isUnique("deer"));
    }
}