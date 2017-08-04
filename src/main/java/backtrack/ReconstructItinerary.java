package backtrack;

import java.util.*;

public class ReconstructItinerary {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, List<String>> ticketMap = new HashMap<>();
        for (String[] ticket : tickets) {
            List<String> t = ticketMap.getOrDefault(ticket[0], new ArrayList<>());
            t.add(ticket[1]);
            ticketMap.putIfAbsent(ticket[0], t);
        }
        for (Map.Entry<String, List<String>> entry : ticketMap.entrySet()) {
            Collections.sort(entry.getValue());
        }
        Map<String, Set<Integer>> usedTickets = new HashMap<>();
        List<String> res = new ArrayList<>();
        res.add("JFK");
        helper("JFK", ticketMap, usedTickets, tickets.length, res);
        return res;
    }

    private boolean helper(
            String from,
            Map<String, List<String>> ticketMap,
            Map<String, Set<Integer>> usedTickets,
            int totalTicketsNumber,
            List<String> res) {
        if (res.size() == totalTicketsNumber + 1) {
            return true;
        }
        if (!ticketMap.containsKey(from)) {
            return false;
        }
        List<String> nexts = ticketMap.get(from);
        for (int i = 0; i < nexts.size(); i++) {
            String next = nexts.get(i);
            if (usedTickets.containsKey(from) && usedTickets.get(from).contains(i)) {
                continue;
            }
            Set<Integer> used = usedTickets.getOrDefault(from, new HashSet<>());
            used.add(i);
            usedTickets.putIfAbsent(from, used);
            res.add(next);
            if (!helper(next, ticketMap, usedTickets, totalTicketsNumber, res)) {
                used.remove(i);
                res.remove(res.size() - 1);
            } else {
                return true;
            }
        }
        return false;
    }
}
