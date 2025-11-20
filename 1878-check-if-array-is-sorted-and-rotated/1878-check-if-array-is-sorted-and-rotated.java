class Solution {
    public boolean check(int[] nums) {
        int brk=0;
        int n=nums.length;
        for(int i=1;i<n;i++)
        {
            if(nums[i] < nums[i-1]){
                brk++;
            }
        }
        if(nums[n-1] > nums[0]){
            brk++;
        }
        if(brk>1) return false;

        return true;
    }
}