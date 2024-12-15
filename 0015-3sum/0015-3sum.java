class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        Set<List<Integer>> temp = new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            int left =i+1;
            int right = nums.length -1;
            while(left<right)
            {
                int sum = nums[i]+nums[left]+nums[right];

                if(sum==0)
                {
                    temp.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;
                }

                else if(sum>0)
                {
                    right--;
                }
                else{
                    left++;
                }
            }
        }
        list.addAll(temp);
        return list;
    }
}