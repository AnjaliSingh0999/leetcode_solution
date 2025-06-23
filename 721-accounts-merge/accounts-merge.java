import java.util.*;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap<>();
        UnionFind uf = new UnionFind();

      
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                emailToName.put(account.get(i), name);
                uf.union(account.get(1), account.get(i)); 
            }
        }

  
        Map<String, TreeSet<String>> components = new HashMap<>();
        for (String email : emailToName.keySet()) {
            String root = uf.find(email);
            components.computeIfAbsent(root, x -> new TreeSet<>()).add(email);
        }

      
        List<List<String>> res = new ArrayList<>();
        for (String root : components.keySet()) {
            List<String> merged = new ArrayList<>();
            merged.add(emailToName.get(root));  
            merged.addAll(components.get(root));  
            res.add(merged);
        }

        return res;
    }
 
    class UnionFind {
        Map<String, String> parent = new HashMap<>();
 
        public String find(String x) {
            parent.putIfAbsent(x, x);
            if (!parent.get(x).equals(x)) {
                parent.put(x, find(parent.get(x)));
            }
            return parent.get(x);
        }

      
        public void union(String x, String y) {
            String rootX = find(x);
            String rootY = find(y);
            if (!rootX.equals(rootY)) {
                parent.put(rootX, rootY);
            }
        }
    }
}
