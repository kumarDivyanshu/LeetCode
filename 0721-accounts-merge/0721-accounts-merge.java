class DisjointSet {
    int[] rank;
    int[] parent;
    int[] size;

    public DisjointSet(int n) {
        rank = new int[n + 1];
        parent = new int[n + 1];
        size = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            rank[i] = 1;
            size[i] = 1;
            parent[i] = i;
        }
    }

    public int findUltParent(int node) {
        if (node == parent[node]) {
            return node;
        }
        return parent[node] = findUltParent(parent[node]);
    }

    public boolean find(int u, int v) {
        int ult_u = findUltParent(u);
        int ult_v = findUltParent(v);

        return ult_u == ult_v;

    }

    public void unionByRank(int u, int v) {
        int ult_u = findUltParent(u);
        int ult_v = findUltParent(v);

        if (ult_u == ult_v)
            return;
        if (rank[ult_u] < rank[ult_v]) {
            parent[ult_u] = ult_v;
        } else if (rank[ult_u] > rank[ult_v]) {
            parent[ult_v] = ult_u;
        } else {
            parent[ult_u] = ult_v;
            rank[ult_v]++;
        }
    }

    public void unionBySize(int u, int v) {
        int ult_u = findUltParent(u);
        int ult_v = findUltParent(v);
        if (ult_u == ult_v)
            return;

        if (size[ult_u] < size[ult_v]) {
            parent[ult_u] = ult_v;
            size[ult_v] += size[ult_u];
        } else {
            parent[ult_v] = ult_u;
            size[ult_u] += size[ult_v];
        }
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String,Integer> map = new HashMap<>();
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        for(int i=0;i<n;i++){
            for(int j=1; j<accounts.get(i).size() ;j++){
                String mail = accounts.get(i).get(j);
                if(map.containsKey( mail) == false){
                    map.put(mail, i );
                }
                else{
                    ds.unionByRank(i, map.get(mail));
                }
            }
        }
        // Step 2: Group emails by ultimate parent
        List<List<String>> mergedMails = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            mergedMails.add(new ArrayList<>());
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String mail = entry.getKey();
            int owner = ds.findUltParent(entry.getValue());
            mergedMails.get(owner).add(mail);
        }

        // Step 3: Build final answer
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (mergedMails.get(i).size() == 0) continue;
            Collections.sort(mergedMails.get(i));
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0)); // name
            for (String mail : mergedMails.get(i)) {
                temp.add(mail);
            }
            ans.add(temp);
        }

        return ans;

    }
}