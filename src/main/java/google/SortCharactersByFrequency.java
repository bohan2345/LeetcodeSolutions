package google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        List<Character>[] frequencySortList = new List[s.length()];
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            if (frequencySortList[entry.getValue() - 1] == null) {
                frequencySortList[entry.getValue() - 1] = new ArrayList<>();
            }
            frequencySortList[entry.getValue() - 1].add(entry.getKey());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = frequencySortList.length - 1; i >= 0; i--) {
            if (frequencySortList[i] == null) {
                continue;
            }
            for (char c : frequencySortList[i]) {
                for (int j = 0; j <= i; j++) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}
