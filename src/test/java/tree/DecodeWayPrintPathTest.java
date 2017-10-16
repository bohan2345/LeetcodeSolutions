package tree;

import org.junit.Test;
import string.DecodeWayPrintPath;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;

public class DecodeWayPrintPathTest {
    @Test
    public void test() {
        DecodeWayPrintPath test = new DecodeWayPrintPath();

        List<String> res = test.decodeWay("1234");

        assertThat(res).containsExactly("1,2,3,4,", "1,23,4,", "12,3,4,");
    }

    @Test
    public void test2() {
        DecodeWayPrintPath test = new DecodeWayPrintPath();

        List<String> res = test.decodeWay("1021");

        assertThat(res).containsExactly("10,2,1,", "10,21,");
    }

    @Test
    public void test3() {
        DecodeWayPrintPath test = new DecodeWayPrintPath();

        List<String> res = test.decodeWay("021");

        assertThat(res).isEmpty();
    }
}
