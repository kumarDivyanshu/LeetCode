class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int ans=0;
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length+1];
        for(int[] arr: dp){
            Arrays.fill(arr,-1);
        }
        ans = solve(0,0, obstacleGrid, dp);
        return ans;
    }

    int solve(int i ,int j , int[][] grid , int[][] dp)
    {
        if(i>=grid.length || j>=grid[0].length || grid[i][j] ==1){
            return 0;
        }
        if(i== grid.length-1 && j== grid[0].length-1){
            return 1;
        }
        if(dp[i][j] != -1) return dp[i][j];

        int right = solve(i , j+1 , grid, dp);
        int down = solve(i+1 , j, grid, dp);
        
        return dp[i][j]=right+down;
    }
}