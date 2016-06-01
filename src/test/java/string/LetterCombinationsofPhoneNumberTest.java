package string;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Test;

import static org.junit.Assert.assertThat;

/**
 * <p>
 * Created by Bohan Zheng on 5/5/2016.
 *
 * @author Bohan Zheng
 */
public class LetterCombinationsofPhoneNumberTest {
    @Test
    public void test() {
        LetterCombinationsofPhoneNumber test = new LetterCombinationsofPhoneNumber();
        String[] expected = {"ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"};
        assertThat(test.letterCombinations("23"), IsIterableContainingInAnyOrder.containsInAnyOrder(expected));
    }
}
