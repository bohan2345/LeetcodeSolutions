package backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingOffers {
    private Map<String, Integer> cache = new HashMap<>();

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        String key = getKey(needs);
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        int totalPrice = Integer.MAX_VALUE;
        for (int i = 0; i < special.size(); i++) {
            List<Integer> offer = special.get(i);
            List<Integer> newNeeds = new ArrayList<>();
            boolean validOffer = true;
            for (int j = 0; j < offer.size() - 1; j++) {
                int n = needs.get(j) - offer.get(j);
                if (n < 0) {
                    validOffer = false;
                    break;
                }
                newNeeds.add(n);
            }
            if (validOffer) {
                totalPrice = Math.min(shoppingOffers(price, special, newNeeds) + offer.get(offer.size() - 1), totalPrice);
            }
        }
        int price2 = 0;
        for (int i = 0; i < needs.size(); i++) {
            price2 += needs.get(i) * price.get(i);
        }
        totalPrice = Math.min(totalPrice, price2);
        cache.put(key, totalPrice);
        return totalPrice;
    }

    private String getKey(List<Integer> needs) {
        StringBuilder sb = new StringBuilder();
        for (int n : needs) {
            sb.append(n);
        }
        return sb.toString();
    }
}
