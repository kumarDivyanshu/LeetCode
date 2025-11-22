class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int ans= Integer.MAX_VALUE;
        Integer[][] dp = new Integer[n][m+1];
        
        for(int i=0;i<n;i++){
            ans = Math.min(ans, solve(0,i, n, m, matrix, dp));
        }
        return ans;
    }

    int solve(int i , int j, int n, int m, int[][] grid, Integer[][] dp ) {
        if( i>= n || j>= m || i<0 || j<0) return 1000000;

        if(i==n-1) return grid[i][j];

        if(dp[i][j] != null) return dp[i][j];
        int Dleft = grid[i][j] + solve(i+1 ,j-1 ,n,m, grid, dp);
        int Ddown = grid[i][j] + solve(i+1 ,j ,n,m, grid, dp);
        int Dright = grid[i][j] + solve(i+1 ,j+1 ,n,m, grid, dp);

        return dp[i][j] =Math.min(Dleft , Math.min(Ddown , Dright));
    }
}
