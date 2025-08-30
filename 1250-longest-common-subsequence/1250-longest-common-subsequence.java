class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        int res = solve(text1, text2 , 0 , 0 , dp);
        return res;
    }

    int solve(String str1, String str2 , int i , int j, int[][] dp)
    {
        if(i>=str1.length() || j>=str2.length()){
            return 0;
        }
        if(dp[i][j] != -1) return dp[i][j];
        int take = 0;
        if(str1.charAt(i) == str2.charAt(j)){
            take = 1 + solve(str1 , str2 , i+1 , j+1 , dp);
        }

        int notTake = Math.max(solve(str1, str2 , i+1 , j , dp) , solve(str1 , str2 , i , j+1 , dp));

        return dp[i][j] =Math.max(take, notTake);
    }
}