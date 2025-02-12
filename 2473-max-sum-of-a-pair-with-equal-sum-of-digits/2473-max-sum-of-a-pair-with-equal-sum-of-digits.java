import java.util.*;

class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, Integer> temp = new HashMap<>();
        int max = -1;
        
        for (int num : nums) {
            int sum = 0;
            int temp1 = num;
            
            while (temp1 != 0) {
                sum += temp1 % 10;
                temp1 /= 10;
            }
            
            if (temp.containsKey(sum)) {
                max = Math.max(max, temp.get(sum) + num);
                temp.put(sum, Math.max(temp.get(sum), num));
            } else {
                temp.put(sum, num);
            }
        }
        
        return max;
    }
}