//import java.util.*;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> parent = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();

        // Initialize Union-Find structure
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                parent.put(email, email);  // Initially, each email is its own parent
                emailToName.put(email, name); // Map email to the account holder's name
            }
        }

        // Union emails in the same account
        for (List<String> account : accounts) {
            String firstEmail = account.get(1); // Representative email
            for (int i = 2; i < account.size(); i++) {
                union(firstEmail, account.get(i), parent);
            }
        }

        // Find connected components (emails with the same root parent)
        Map<String, List<String>> components = new HashMap<>();
        for (String email : parent.keySet()) {
            String root = find(email, parent);
            components.putIfAbsent(root, new ArrayList<>());
            components.get(root).add(email);
        }

        // Prepare the final result
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : components.entrySet()) {
            List<String> emails = entry.getValue();
            Collections.sort(emails); // Sort emails
            String name = emailToName.get(entry.getKey()); // Get the name from any email in the group
            List<String> account = new ArrayList<>();
            account.add(name);
            account.addAll(emails);
            result.add(account);
        }

        return result;
    }

    private void union(String email1, String email2, Map<String, String> parent) {
        String root1 = find(email1, parent);
        String root2 = find(email2, parent);
        if (!root1.equals(root2)) {
            parent.put(root1, root2); // Merge two components
        }
    }

    private String find(String email, Map<String, String> parent) {
        if (!parent.get(email).equals(email)) {
            parent.put(email, find(parent.get(email), parent)); // Path compression
        }
        return parent.get(email);
    }
}
