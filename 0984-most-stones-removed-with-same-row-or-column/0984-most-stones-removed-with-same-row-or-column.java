class DisjointSet{
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    DisjointSet(int n){
        for(int i=0;i<=n ;i++){
            size.add(1);
            parent.add(i);
        }
    }

    int ultParent(int node){
        if(node == parent.get(node)){
            return node;
        }

        int ulP = ultParent(parent.get(node));
        parent.set(node, ulP);
        return parent.get(node);
    }


    void unionBySize(int u , int v){
        int ultU = ultParent(u);
        int ultV = ultParent(v);
        
        if(ultU == ultV) return;

        if(size.get(ultU) < size.get(ultV)){
            parent.set(ultU, ultV);
            size.set(ultV , size.get(ultU) + size.get(ultV));
        }
         else {
    parent.set(ultV, ultU);
    size.set(ultU, size.get(ultU) + size.get(ultV));
}
    }
}


class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;

        // Max coordinates: 0 <= x,y <= 10000
        // Map rows as 0..10000
        // Map columns as 10001..20000
        DisjointSet ds = new DisjointSet(20005);

        Set<Integer> uniqueNodes = new HashSet<>();

        for(int[] stone : stones) {
            int row = stone[0];
            int col = stone[1] + 10001;  // shift column to avoid overlap

            ds.unionBySize(row, col);

            uniqueNodes.add(row);
            uniqueNodes.add(col);
        }

        int components = 0;
        for(int node : uniqueNodes) {
            if(ds.ultParent(node) == node) components++;
        }

        // Remove = total stones - components
        return n - components;
    }
}