class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int n= coins.length;
        int[][] dp = new int [n+1][amount+1];

        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        int ans = solve(n-1 , coins , amount, dp);
        if(ans==100000000){
            ans = -1;
        }

        return ans;
        
    }

    int solve(int idx , int[] coins , int amount, int[][] dp){
        if (idx == 0) {
            if (amount % coins[0] == 0){
                return amount / coins[0];
            } 
            else{
                return 100000000; 
            }
            
        }
        if(dp[idx][amount] != -1) return dp[idx][amount];
        int take=100000000;
        if(coins[idx] <= amount){
            take = 1 + solve(idx , coins , amount - coins[idx], dp);
        }

        int notTake = solve(idx -1, coins , amount, dp);

        return dp[idx][amount] = Math.min(take , notTake);
    }
}