class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToParent = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();

        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                emailToParent.put(account.get(i), account.get(i));
                emailToName.put(account.get(i), name);
            }
        }

        for (List<String> account : accounts) {
            String parent = find(emailToParent, account.get(1));
            for (int i = 2; i < account.size(); i++) {
                emailToParent.put(find(emailToParent, account.get(i)), parent);
            }
        }

        Map<String, TreeSet<String>> groups = new HashMap<>();
        for (String email : emailToParent.keySet()) {
            String parent = find(emailToParent, email);
            groups.computeIfAbsent(parent, k -> new TreeSet<>()).add(email);
        }

        List<List<String>> result = new ArrayList<>();
        for (TreeSet<String> group : groups.values()) {
            List<String> merged = new ArrayList<>();
            merged.add(emailToName.get(group.first()));
            merged.addAll(group);
            result.add(merged);
        }

        return result;
    }

    private String find(Map<String, String> emailToParent, String email) {
        if (!emailToParent.get(email).equals(email)) {
            emailToParent.put(email, find(emailToParent, emailToParent.get(email)));
        }
        return emailToParent.get(email);
    }
}
