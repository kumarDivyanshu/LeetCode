class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n+1][m+1];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        int res = solve(0,0, n,m, grid , dp);
        return res;
    }

    int solve(int i, int j, int n , int m , int[][] grid, int[][] dp)
    {
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(i==n-1 && j==m-1){
            return grid[i][j];
        }
        if(i>=n || j>= m){
            return 1000000;
        }

        int right = grid[i][j] + solve(i , j+1 , n,m,grid,dp);

        int down = grid[i][j] + solve(i+1 , j , n , m, grid, dp);

        return dp[i][j]=Math.min(right, down);

    }
}