class Solution {
    int[][] grid;
    int m, n, m1, n1;
    public int numEnclaves(int[][] grid) {
        m = grid.length;
        m1 = m - 1;
        n = grid[0].length;
        n1 = n - 1;
        int total = 0;
        this.grid = grid;
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1) {
                dfs(i, 0);
            }
            if (grid[i][n1] == 1) {
                dfs(i, n1);
            }
        }
        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 1) {
                dfs(0, j);
            }
            if (grid[m1][j] == 1) {
                dfs(m1, j);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                total += grid[i][j];
            }
        }
        return total;
    }

    void dfs(int i, int j) {
        grid[i][j] = 0;
        if (i > 0 && grid[i - 1][j] == 1) {
            dfs(i - 1, j);
        }
        if (i < m1 && grid[i + 1][j] == 1) {
            dfs(i + 1, j);
        }
        if (j > 0 && grid[i][j - 1] == 1) {
            dfs(i, j - 1);
        }
        if (j < n1 && grid[i][j + 1] == 1) {
            dfs(i, j + 1);
        }
    }
}