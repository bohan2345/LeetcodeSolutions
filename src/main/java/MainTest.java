import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <br>
 * Created by Bohan Zheng on 9/10/2015.
 *
 * @author Bohan Zheng
 */
public class MainTest {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 2);
        map.put("d", 2);

        for (String str : new MainTest().test(map, 2))
            System.out.println(str);

        Map<Integer, List<String>> newMap = new MainTest().test2(map);
        for (Map.Entry<Integer, List<String>> entry : newMap.entrySet()) {
            for (String str : entry.getValue())
                System.out.print(str);
            System.out.println("");
        }
    }

    public List<String> test(HashMap<String, Integer> map, int a) {
        return map.entrySet().stream()
                .filter(pair -> pair.getValue().equals(a))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public Map<Integer, List<String>> test2(HashMap<String, Integer> map) {
        Map<Integer, List<String>> result = new HashMap<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (result.containsKey(entry.getValue())) {
                result.get(entry.getValue()).add(entry.getKey());
            } else {
                ArrayList<String> strs = new ArrayList<>();
                strs.add(entry.getKey());
                result.put(entry.getValue(), strs);
            }
        }
        return result;
    }
}