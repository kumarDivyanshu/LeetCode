class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;

        int low = 0;
        int mid = 0;
        int high = n-1;

        for(int i = 0 ;i < n ;i++){
            if(nums[mid] == 0){
                swap(low , mid , nums);
                low++;
                mid++;
            }

            else if(nums[mid] == 2){
                swap(mid , high , nums);
                // mid++;
                high--;
            }
            
            else{
                mid++;
            }
        }
    }

    void swap(int a , int b , int[] nums){
        int temp = nums[a];
        nums[a]= nums[b];
        nums[b] = temp;
    }
}