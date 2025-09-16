class Solution {
    public int minOperations(String s) {
        int maxOps = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int ops = (26 - (c - 'a')) % 26;  // distance from c to 'a' in cyclic alphabet
            maxOps = Math.max(maxOps, ops);
        }

        return maxOps;
    }
}
