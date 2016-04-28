package string;

import static org.junit.Assert.*;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
