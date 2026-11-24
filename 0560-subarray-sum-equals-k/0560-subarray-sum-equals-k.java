class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int prefix = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        for(int i=0;i< nums.length ; i++)
        {
            prefix += nums[i];
            int find = prefix - k;
            if(map.containsKey(find))
            {
                count += map.get(find);
            }
            map.put(prefix , map.getOrDefault(prefix,0) + 1 );
        }
        return count;
    }
}