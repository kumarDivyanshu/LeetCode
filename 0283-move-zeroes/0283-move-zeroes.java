class Solution {
    public void moveZeroes(int[] nums) {
        
        int left=0;
        int right=0;
        int n=nums.length;
        
        while(left<n && right<n){
            if(nums[left]==0 && nums[right]==0){
                right++;
            }
            else if(nums[left]==0 && nums[right]!=0){
                swap(left, right , nums);
                left++;
                right++;
            }
            else{
                left++;
                right++;
            }
        }
        
    }

    void swap(int a, int b, int[] nums){
        int temp = nums[a];
        nums[a]= nums[b];
        nums[b] = temp;
    }
}