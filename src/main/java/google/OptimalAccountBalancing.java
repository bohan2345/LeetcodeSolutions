package google;

import java.util.HashMap;
import java.util.Map;

public class OptimalAccountBalancing {
    public int minTransfers(int[][] transactions) {
        int[] debts = getDebts(transactions);
        return dfs(debts, 0, 0);
    }

    private int[] getDebts(int[][] transactions) {
        Map<Integer, Integer> debtMap = new HashMap<>();
        for (int[] transaction : transactions) {
            debtMap.put(transaction[0], debtMap.getOrDefault(transaction[0], 0) - transaction[2]);
            debtMap.put(transaction[1], debtMap.getOrDefault(transaction[1], 0) + transaction[2]);
        }
        int[] debts = new int[debtMap.size()];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : debtMap.entrySet()) {
            debts[i] = entry.getValue();
            i++;
        }
        return debts;
    }

    private int dfs(int[] debts, int current, int numOfTransaction) {
        if (current == debts.length) {
            return numOfTransaction;
        }
        if (debts[current] == 0) {
            return dfs(debts, current + 1, numOfTransaction);
        }
        int min = Integer.MAX_VALUE;
        for (int i = current + 1; i < debts.length; i++) {
            if ((debts[current] ^ debts[i]) < 0) { // When two numbers have different sign, their XOR is less than 0.
                debts[i] += debts[current];
                min = Math.min(min, dfs(debts, current + 1, numOfTransaction + 1));
                debts[i] -= debts[current];
            }
        }
        return min;
    }

//    public int result = Integer.MAX_VALUE;
//
//    public int minTransfers(int[][] transactions) {
//        if (transactions == null || transactions.length == 0 || transactions[0] == null || transactions[0].length == 0)
//            return 0;
//
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < transactions.length; i++) {
//            int p1 = transactions[i][0];
//            int p2 = transactions[i][1];
//            int money = transactions[i][2];
//            map.put(p1, map.getOrDefault(p1, 0) - money);
//            map.put(p2, map.getOrDefault(p2, 0) + money);
//        }
//
//
//        dfs(map, transactions[0][0], 0);
//        return result;
//    }
//
//    private void dfs(Map<Integer, Integer> map, int current, int count) {
//        boolean allClear = true;
//        for (Integer p : map.keySet()) {
//            if (map.get(p) == 0 || p == current) {
//                continue;
//            }
//            allClear = false;
//            int money = map.get(current);
//            if ((money ^ map.get(p)) >= 0) {
//                continue;
//            }
//            map.put(current, map.get(current) - money);
//            map.put(p, map.get(p) + money);
//            if (money == 0) {
//                dfs(map, p, count);
//            } else {
//                dfs(map, p, count + 1);
//            }
//            map.put(current, map.get(current) + money);
//            map.put(p, map.get(p) - money);
//
//        }
//
//        if (allClear)
//            result = Math.min(result, count);
//    }
}
