package backtrack;

import java.util.ArrayList;
import java.util.List;

public class ShoppingOffers {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int totalPrice = 0;
        for (int i = 0; i < needs.size(); i++) {
            totalPrice += needs.get(i) * price.get(i);
        }
        for (int i = 0; i < special.size(); i++) {
            List<Integer> offer = special.get(i);
            List<Integer> newNeeds = new ArrayList<>();
            boolean validOffer = true;
            for (int j = 0; j < offer.size() - 1; j++) {
                int n = needs.get(j) - offer.get(j);
                if (n < 0) {
                    validOffer = false;
                }
                newNeeds.add(n);
            }
            if (validOffer) {
                totalPrice = Math.min(shoppingOffers(price, special, newNeeds) + offer.get(offer.size() - 1), totalPrice);
            }
        }
        return totalPrice;
    }
}
