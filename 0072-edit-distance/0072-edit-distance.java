class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(0, 0, word1, word2, dp);
    }

    int solve(int i , int j , String w1 , String w2 , int[][] dp){
           // base case: one string is exhausted
        if (i == w1.length()) {
            return w2.length() - j; // need to insert remaining of w2
        }
        if (j == w2.length()) {
            return w1.length() - i; // need to delete remaining of w1
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
       
        if( w1.charAt(i) == w2.charAt(j) ){
            return solve(i+1 , j+1 , w1, w2, dp);
        }

        int insert = 1+ solve(i+1 , j , w1 , w2, dp);
        int delete = 1+ solve(i , j+1 , w1 , w2, dp);
        int replace = 1+ solve(i+1 , j+1 , w1 , w2, dp);

        return dp[i][j] =Math.min(insert , Math.min(delete, replace));
    }
}