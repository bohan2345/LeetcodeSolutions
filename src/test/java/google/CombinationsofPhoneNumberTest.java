package google;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * Created by Bohan Zheng on 7/10/16.
 *
 * @author Bohan Zheng
 */
public class CombinationsofPhoneNumberTest {
    @Test
    public void test() {
        CombinationsofPhoneNumber test = new CombinationsofPhoneNumber();
        Set<String> dic = new HashSet<>();
        dic.add("target");
        dic.add("tar");
        dic.add("ta");
        dic.add("get");
        Assert.assertEquals("800target12", test.findAllCombinations("80082743812", dic).get(0));
    }
}
