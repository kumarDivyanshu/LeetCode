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
    private boolean isValid(int row, int col, int rowMax, int colMax) {
        if (row < 0 || col < 0 || row >= rowMax || col >= colMax) {
            return false;
        } else {
            return true;
        }
    }

    public int largestIsland(int[][] grid) {
        int count=0;
        int n= grid.length;
        int m = grid[0].length;
        DisjointSet ds = new DisjointSet(n*n);

         for(int i=0; i< n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1)
                {
                    int[] dx ={1,-1,0,0};
                    int[] dy = {0,0,1,-1};
                    for(int x=0;x<4;x++){
                        int newRow = i + dx[x];
                        int newCol = j + dy[x];

                        if(isValid(newRow, newCol , n , m) && grid[newRow][newCol] == 1){
                            int nodeNo = i * n + j;
                            int adjNodeNo = newRow * n + newCol; 
                            ds.unionBySize(nodeNo , adjNodeNo);
                        }
                        
                    }
                }

            }
         }

        int max = 0;

        for(int i=0;i< n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 0){
                Set<Integer> components = new HashSet<>();
                int[] dx ={1,-1,0,0};
                int[] dy = {0,0,1,-1};
                for(int x=0;x<4;x++){
                    int newRow = i + dx[x];
                    int newCol = j + dy[x];
                    if(isValid(newRow, newCol , n , m) && grid[newRow][newCol] == 1){
                        int adjNodeNo = newRow * n + newCol;
                        components.add(ds.findUltParent(adjNodeNo));
                    }
                    int sizeTotal = 0;
                    for(Integer parent: components){
                        sizeTotal += ds.size[parent];
                    }
                    max = Math.max(max , sizeTotal + 1);
                }
            }
        } 

        
        
    }
    for(int cellNo=0 ; cellNo<n*n ;cellNo++){
            max = Math.max(max , ds.size[ds.findUltParent(cellNo)]);
        }
    return max;
}
}