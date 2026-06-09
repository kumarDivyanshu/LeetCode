class Solution {
    public void nextPermutation(int[] nums) {
        int index = -1;
        for(int i=nums.length-2 ; i>=0 ; i--){
            if(nums[i] < nums[i+1]){
                index = i;
                break;
            }
        }
        if(index == -1)
        {
            reverse(nums,0,nums.length-1);
            return;
        }
        
        for(int i=nums.length-1 ;i>index ;i--){
            if(nums[i] > nums[index]){
                //swap
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                break;
            }
        }
        reverse(nums, index + 1 , nums.length-1);
        return;
    }

    private void reverse(int nums[], int left , int right)
    {
        // int left = 0;
        // int right = nums.length-1;
        while(left < right){
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;

            right--;
            left++;
        }

    }
}