package string;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;

/**
 * <p>
 * Created by Bohan Zheng on 3/29/2016.
 *
 * @author Bohan Zheng
 */
public class RestoreIPAddressTest {
    @Test
    public void test() {
        RestoreIPAddress test = new RestoreIPAddress();
        List<String> expected = new ArrayList<>();
        expected.add("255.255.11.135");
        expected.add("255.255.111.35");
        assertThat(test.restoreIpAddresses("25525511135"),
                IsIterableContainingInAnyOrder.containsInAnyOrder(expected.toArray()));
    }

    @Test
    public void test2() {
        RestoreIPAddress test = new RestoreIPAddress();
        List<String> expected = new ArrayList<>();
        expected.add("0.0.0.0");
        assertThat(test.restoreIpAddresses("0000"),
                IsIterableContainingInAnyOrder.containsInAnyOrder(expected.toArray()));
    }

    @Test
    public void test3() {
        RestoreIPAddress test = new RestoreIPAddress();
        List<String> expected = new ArrayList<>();
        expected.add("0.10.0.10");
        expected.add("0.100.1.0");
        assertThat(test.restoreIpAddresses("010010"),
                IsIterableContainingInAnyOrder.containsInAnyOrder(expected.toArray()));
    }
}
