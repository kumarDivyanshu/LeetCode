class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        int n = intervals.length;
        Arrays.sort(intervals , (a,b) -> a[0] - b[0]);
        int[] curr = intervals[0];

        int i=1;
        
        while(i<n){
            if(intervals[i][0] <= curr[1])
            {
                curr[1] = Math.max(intervals[i][1], curr[1]);
            }
            else{
                ans.add(curr);
                curr = intervals[i];
            }
            i++;
        }

        ans.add(curr);

        return ans.toArray(new int[ans.size()][]);
    }
}