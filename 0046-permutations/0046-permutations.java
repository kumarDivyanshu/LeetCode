class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lst = new ArrayList<>();
        List<Integer> templst = new ArrayList<>();
        backtrack(nums,lst,templst);
        return lst;
    }

    public static void backtrack(int nums[], List<List<Integer>> lst, List<Integer> templst )
    {
        if(templst.size()== nums.length)
        {
            lst.add(new ArrayList<>(templst));
        }


        for(int num:nums)
        {
            if(templst.contains(num))
            {
                continue;
            }
            templst.add(num);

            backtrack(nums,lst,templst);

            templst.remove(templst.size()-1);
        }
    }
}