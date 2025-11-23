class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> memo = new HashMap<>();
        return helper(nums, target, 0, 0, memo);
    }

    private int helper(int[] arr, int target, int idx, int sum, Map<String, Integer> memo) {
        if (idx == arr.length) {
            return sum == target ? 1 : 0;
        }

        String key = idx + "," + sum;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int add = helper(arr, target, idx + 1, sum + arr[idx], memo);
        int subtract = helper(arr, target, idx + 1, sum - arr[idx], memo);

        memo.put(key, add + subtract);
        return add + subtract;
    }
}
