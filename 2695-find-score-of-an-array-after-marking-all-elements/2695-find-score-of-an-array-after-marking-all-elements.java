import java.util.*;

class Solution {
    public long findScore(int[] nums) {
        TreeMap<Integer, List<Integer>> treemap = new TreeMap<>();
        boolean[] marked = new boolean[nums.length];

        for (int i = 0; i < nums.length; i++) {
            treemap.putIfAbsent(nums[i], new ArrayList<>());
            treemap.get(nums[i]).add(i);
        }
        long score = 0;
        while (!treemap.isEmpty()) {
            int smallestKey = treemap.firstKey();
            List<Integer> indices = treemap.get(smallestKey);

            for (int index : indices) {
                if (!marked[index]) {
                    score += smallestKey;
                    marked[index] = true;
                    if (index > 0) {
                        marked[index - 1] = true;
                    }
                    if (index < nums.length - 1) {
                        marked[index + 1] = true;
                    }
                }
            }
            treemap.remove(smallestKey);
        }

        return score;
    }
}
