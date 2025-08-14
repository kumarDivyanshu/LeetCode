class DisjointSet {
    int[] rank;
    int[] parent;
    int[] size;
    public DisjointSet(int n) {
        rank= new int[n+1];
        parent = new int[n+1];
        size = new int[n+1];

        for(int i=0;i<=n;i++){
            rank[i] = 1;
            size[i] = 1;
            parent[i] = i;
        }
    }

    public int findUltParent(int node){
        if(node == parent[node]){
            return node;
        }
        return parent[node] = findUltParent(parent[node]);
    }

    public boolean find(int u, int v) {
        int ult_u = findUltParent(u);
        int ult_v = findUltParent(v);

        return ult_u== ult_v; 
        
    }

    public void unionByRank(int u, int v) {
        int ult_u = findUltParent(u);
        int ult_v = findUltParent(v);

        if(ult_u == ult_v) return;
        if(rank[ult_u] < rank[ult_v]){
            parent[ult_u] = ult_v;
        } 
        else if(rank[ult_u] > rank[ult_v]){
            parent[ult_v] = ult_u;
        }
        else{
            parent[ult_u] = ult_v;
            rank[ult_v]++;
        }
    }

    public void unionBySize(int u, int v) {
        int ult_u = findUltParent(u);
        int ult_v = findUltParent(v);
        if(ult_u == ult_v) return;

        if(size[ult_u] < size[ult_v]){
            parent[ult_u] = ult_v;
            size[ult_v] += size[ult_u];
        }
        else {
            parent[ult_v] = ult_u;
            size[ult_u] += size[ult_v];
        }
    }
}

class Solution {
    public int makeConnected(int n, int[][] connections) {
        int extra = 0;
        DisjointSet ds = new DisjointSet(n);
        for(int i=0;i< connections.length ;i++){
            int u = connections[i][0];
            int v = connections[i][1];

            if(ds.findUltParent(u) == ds.findUltParent(v)){
                extra++;
            }
            else{
               ds.unionByRank(u,v);

            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(ds.parent[i] == i){
                count++;
            }
        }
        int needed = count - 1; // operations needed to connect all components
        return (extra >= needed) ? needed : -1;
    }
}