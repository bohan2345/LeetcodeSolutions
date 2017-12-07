package fb;

import java.util.*;

public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap<>(); // Map user email to user name.
        Map<String, Set<String>> emailGraph = new HashMap<>(); // Map each email to the same users other email.

        for (List<String> account : accounts) {
            // first element in account is the user name;
            String userName = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                emailToName.put(email, userName);
                // Map email with other emails in this account.
                Set<String> otherEmails = emailGraph.getOrDefault(email, new HashSet<>());
                for (int j = 1; j < account.size(); j++) {
                    if (j != i) {
                        otherEmails.add(account.get(j));
                    }
                }
                emailGraph.put(email, otherEmails);
            }
        }
        Set<String> visited = new HashSet<>();
        Stack<String> stk = new Stack<>();
        List<List<String>> res = new ArrayList<>();
        for (String email : emailGraph.keySet()) {
            if (visited.contains(email)) {
                continue;
            }
            List<String> emailOfSameUser = new ArrayList<>();

            // DFS for all emails belong to same user.
            stk.push(email);
            visited.add(email);
            while (!stk.isEmpty()) {
                String otherEmail = stk.pop();
                emailOfSameUser.add(otherEmail);
                for (String neighbor : emailGraph.get(otherEmail)) {
                    if (!visited.contains(neighbor)) {
                        stk.push(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
            Collections.sort(emailOfSameUser);
            // Add user name for this email owner.
            emailOfSameUser.add(0, emailToName.get(email));
            res.add(emailOfSameUser);
        }
        return res;
    }
}
