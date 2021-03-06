package backtrack;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;

public class ShoppingOffersTest {
    @Test
    public void test() {
        ShoppingOffers test = new ShoppingOffers();
        //[2,5], [[3,0,5],[1,2,10]], [3,2]
        List<Integer> price = ImmutableList.of(2, 5);
        List<List<Integer>> offer = ImmutableList.of(ImmutableList.of(3, 0, 5), ImmutableList.of(1, 2, 10));
        List<Integer> need = ImmutableList.of(3, 2);

        int totalPrice = test.shoppingOffers(price, offer, need);

        assertThat(totalPrice).isEqualTo(14);
    }

    @Test
    public void test2() {
        ShoppingOffers test = new ShoppingOffers();
        //[2,3,4], [[1,1,0,4],[2,2,1,9]], [1,2,1]
        List<Integer> price = ImmutableList.of(2, 3, 4);
        List<List<Integer>> offer = ImmutableList.of(ImmutableList.of(1, 1, 0, 4), ImmutableList.of(2, 2, 1, 9));
        List<Integer> need = ImmutableList.of(1, 2, 1);

        int totalPrice = test.shoppingOffers(price, offer, need);

        assertThat(totalPrice).isEqualTo(11);
    }
}
