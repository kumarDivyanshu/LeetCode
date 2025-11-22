class DSU {
    int[] parent;
    int[] size;

    public DSU(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) return;

        // union by size
        if (size[pa] < size[pb]) {
            parent[pa] = pb;
            size[pb] += size[pa];
        } else {
            parent[pb] = pa;
            size[pa] += size[pb];
        }
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        int ans=0;
        
        int n= grid.length;
        int m = grid[0].length;
        DSU ds = new DSU(n*m+1);
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}}; // 4 directions

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == '1') {
                    int index = i * m + j;

                    for (int[] d : dirs) {
                        int ni = i + d[0];
                        int nj = j + d[1];

                        if (ni >= 0 && ni < n && nj >= 0 && nj < m 
                            && grid[ni][nj] == '1') {

                            int adjIndex = ni * m + nj;
                            ds.union(index, adjIndex);
                        }
                    }
                }
            }
        }

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == '1') {
                    int id = i * m + j;
                    set.add(ds.find(id));
                }
            }
        }

        return set.size();
    }
}