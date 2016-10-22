package string;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Test;

import static org.junit.Assert.assertThat;

/**
 * <p>
 * Created by Bohan Zheng on 4/27/2016.
 *
 * @author Bohan Zheng
 */
public class GenerateParenthesesTest {
    @Test
    public void test() {
        GenerateParentheses test = new GenerateParentheses();
        String[] expected = {"((()))", "(()())", "(())()", "()(())", "()()()"};
        assertThat(test.generateParenthesis(3), IsIterableContainingInAnyOrder.containsInAnyOrder(expected));
    }
}
