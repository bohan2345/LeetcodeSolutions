package google;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
    List<Integer> x = new ArrayList<>();
    x.iterator();
    dic.add("target");
    dic.add("tar");
    dic.add("ta");
    dic.add("get");
    Assert.assertThat(test.findAllCombinations("80082743812", dic),
        IsIterableContainingInAnyOrder.containsInAnyOrder("800ta743812", "800tar43812", "800target12", "800827get12"));
  }
}
