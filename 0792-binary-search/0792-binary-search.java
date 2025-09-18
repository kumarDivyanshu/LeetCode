class Solution {
    public int search(int[] nums, int target) {
        int idx =-1;

        int n= nums.length;
        int left=0;
        int right = n-1;
        while(left <= right)
        {
            int mid = (left+right)/2;
            if(nums[mid] == target){
                return mid;
            }

            else if(nums[mid] > target){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return idx;
    }

    public int find(int[] nums, int target, int left, int right) {
        if (left > right) return -1; 

        int mid = left + (right - left) / 2;

        if (nums[mid] == target) return mid;
        else if (nums[mid] > target) 
            return find(nums, target, left, mid - 1);
        else 
            return find(nums, target, mid + 1, right);
    }
}
