class Solution {
    public int f(int ind, int buy, int cap, int[] prices, int n, int[][][] dp) {
        if (ind == n || cap == 0) return 0;

        if (dp[ind][buy][cap] != -1) return dp[ind][buy][cap];

        if (buy == 1) {
            // Option 1: Buy the stock
            // Option 2: Skip buying
            dp[ind][buy][cap] = Math.max(
                -prices[ind] + f(ind + 1, 0, cap, prices, n, dp),
                f(ind + 1, 1, cap, prices, n, dp)
            );
        } else {
            // Option 1: Sell the stock
            // Option 2: Skip selling
            dp[ind][buy][cap] = Math.max(
                prices[ind] + f(ind + 1, 1, cap - 1, prices, n, dp),
                f(ind + 1, 0, cap, prices, n, dp)
            );
        }

        return dp[ind][buy][cap];
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        // 3D DP array [day][buy=0/1][cap=0 to 2]
        int[][][] dp = new int[n][2][3];

        // Initialize with -1
        for (int i = 0; i < n; i++) {
            for (int b = 0; b < 2; b++) {
                for (int c = 0; c < 3; c++) {
                    dp[i][b][c] = -1;
                }
            }
        }

        return f(0, 1, 2, prices, n, dp);
    }
}