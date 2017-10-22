package google;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReplaceStringGame {
    private Map<String, Boolean> cache = new HashMap<>();

    public boolean replaceStringGame(String a, List<String[]> rules) {

        if (cache.containsKey(a)) {
            return cache.get(a);
        }

        for (String[] rule : rules) {
            String origin = rule[0];
            String target = rule[1];

            int index = 0;
            while (a.indexOf(origin, index) != -1) {
                StringBuilder sb = new StringBuilder();
                int pos = a.indexOf(origin);
                sb.append(a.substring(0, pos));
                sb.append(target);
                sb.append(a.substring(pos + origin.length()));

                if (!replaceStringGame(sb.toString(), rules)) {
                    cache.put(a, true);
                    return true;
                }
                index++;
            }

        }
        cache.put(a, false);
        return false;
    }
}
