package google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Example1
 * input = {{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}}
 * return {"JFK", "MUC", "LHR", "SFO", "SJC"}
 * <p>
 * Created by Bohan Zheng on 5/19/2016.
 *
 * @author Bohan Zheng
 */
public class BuildTravalRoute {
  private class City {
    String name;
    City next;
    boolean isOrigin = true;

    City(String name) {
      this.name = name;
    }
  }

  public List<String> buildRoute(List<List<String>> cities) {
    Map<String, City> map = new HashMap<>();
    for (List<String> city : cities) {
      String from = city.get(0);
      String to = city.get(1);
      City fromCity;
      if (map.containsKey(from)) {
        fromCity = map.get(from);
      } else {
        fromCity = new City(from);
        map.put(from, fromCity);
      }
      City toCity;
      if (map.containsKey(to)) {
        toCity = map.get(to);
      } else {
        toCity = new City(to);
        map.put(to, toCity);
      }
      fromCity.next = toCity;
      toCity.isOrigin = false;
    }

    List<String> res = new ArrayList<>();
    City head = null;
    for (String city : map.keySet()) {
      if (map.get(city).isOrigin) {
        head = map.get(city);
        break;
      }
    }
    while (head != null) {
      res.add(head.name);
      head = head.next;
    }
    return res;
  }

}
