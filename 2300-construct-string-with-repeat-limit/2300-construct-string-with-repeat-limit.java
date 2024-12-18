class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        
        StringBuilder res = new StringBuilder();
        int curr = 25; 
        int next = 25;
        
        while (curr >= 0) {
            int rep = repeatLimit;
            while (rep > 0 && freq[curr] > 0) {
                res.append((char) (curr + 'a'));
                rep--;
                freq[curr]--;
            }
            
            if (freq[curr] > 0) {
                next = -1;
                for (int j = curr - 1; j >= 0; j--) {
                    if (freq[j] > 0) {
                        next = j;
                        break;
                    }
                }
                
                if (next == -1) {
                    break;
                }
                
                res.append((char) (next + 'a'));
                freq[next]--;
            } else {
                curr--;
            }
        }
        
        return res.toString();
    }
}
