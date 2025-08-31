class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Integer[][] dp = new Integer[m][n];  
        return solve(0, 0, grid, dp);
    }

    int solve(int i, int j, int[][] grid, Integer[][] dp) {
        int m = grid.length;
        int n = grid[0].length;

        // Base case: reached bottom-right cell
        if (i == m - 1 && j == n - 1) {
            return grid[i][j];
        }

        if (i >= m || j >= n) {
            return Integer.MAX_VALUE;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        int right = solve(i, j + 1, grid, dp);
        int down = solve(i + 1, j, grid, dp);

        int minPath = Math.min(right, down);

        // If both paths are invalid, return MAX_VALUE
        if (minPath == Integer.MAX_VALUE) {
            return dp[i][j] = Integer.MAX_VALUE;
        }

        return dp[i][j] = grid[i][j] + minPath;
    }
}
