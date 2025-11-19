class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        Boolean[] dp = new Boolean[s.length()];

        return solve(0 ,s , set , dp);
    }

    boolean solve(int start , String s, HashSet<String> set , Boolean[] dp){
        if(start == s.length()){
            return true;
        }

        if(dp[start] != null) return dp[start];

        for(int end=start +1 ; end<=s.length() ; end++){
            String newString = s.substring(start,end);
            
            if(set.contains(newString) && solve(end , s , set , dp)){
                return dp[start] = true;
            }
        }

        return dp[start] = false;
    }
}