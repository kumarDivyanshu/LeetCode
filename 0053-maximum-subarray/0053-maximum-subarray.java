class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        int startArr=0;
        int endArr=nums.length-1;
        for(int i=0;i<nums.length;i++)
        {
            if(sum==0){
                startArr = i;
            }
            sum += nums[i];
            if(sum > maxSum){
                maxSum = sum;
                endArr = i;
            }
            if(sum < 0){
                sum = 0;
            }

            
        }
        List<Integer> arr = new ArrayList<>();
        for(int i=startArr ; i<=endArr ; i++){
            arr.add(nums[i]);
        }
        System.out.println("Maximum Sum Subarray is: "+arr);
        return maxSum;
    }
}