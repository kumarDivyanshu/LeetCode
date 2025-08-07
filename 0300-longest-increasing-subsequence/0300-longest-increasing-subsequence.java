class Solution {
    public int lengthOfLIS(int[] nums) {
        // int n = nums.length;
        // int prevIndex = -1;
        // int[][] dp = new int[n][n+1];
        // for(int [] arr: dp){
        //     Arrays.fill(arr,-1);
        // }
        // return solve(n-1, prevIndex, nums, dp);

        List<Integer> arr = new ArrayList<>();

        for(int num  : nums)
        {
            int index = Collections.binarySearch(arr, num);

            // If not found, binarySearch returns (-(insertion point) - 1)
            if (index < 0) {
                index = -index - 1;
            }

            if(index==arr.size()){
                arr.add(num);
            }
            else{
                arr.set(index , num);
            }
        }
        return arr.size();

    }

    public int solve(int curr , int prev ,int[] nums, int [][]dp){
        if(curr<0){
            return 0;
        }
        if(dp[curr][prev+1]!= -1) return dp[curr][prev+1];

        int take=0;
        if(prev == -1 || nums[curr] < nums[prev]  )
        {
            take = 1 + solve(curr - 1 , curr , nums, dp);
        }

     
        int notTake = solve(curr-1 , prev , nums, dp);
        return dp[curr][prev+1]=Math.max(take, notTake);
    }
}