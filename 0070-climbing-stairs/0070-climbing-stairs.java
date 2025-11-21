class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        int ans = solve(n, dp);
        return ans;
    }

    int solve(int steps , int[] dp)
    {
        
        if(steps<0){
            return 0;
        }

        if(steps==0){
            return 1;
        }
        if(dp[steps] != -1){
            return dp[steps];
        }
        int one = solve(steps - 1 , dp);
        int two = solve(steps - 2 , dp);

        return dp[steps]= one+two;
    }
}