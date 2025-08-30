class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int prev = -1;
        int [][] dp = new int[n][n+1];
        for(int[] row : dp){
            Arrays.fill(row , -1);
        }
        int res = solve(0 , prev , nums , dp);
        return res;
    }

    int solve(int curr, int prev , int[]nums , int[][] dp)
    {
        if(curr >= nums.length){
            return 0;
        }
        if(dp[curr][prev+1] != -1){
            return dp[curr][prev+1];
        }
        int take = 0;
        if(prev == -1 || nums[curr] > nums[prev])
        {
            take = 1 + solve(curr+1 , curr , nums, dp);
        }
        
        int notTake = solve(curr+1 , prev , nums, dp);
        return dp[curr][prev+1]= Math.max(take, notTake);
    }
}