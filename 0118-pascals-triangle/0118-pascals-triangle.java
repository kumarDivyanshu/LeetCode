class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i=0;i<numRows;i++){
            List<Integer> temp = genRow(i+1);
            ans.add(temp);
        }

        return ans;
    }

    private List<Integer> genRow(int n){
        List<Integer> row = new ArrayList<>();
        Integer ans = 1;
        row.add(ans);
        for(int j=1;j<n;j++){
            ans = ans * (n-j);
            ans = ans / j;

            row.add(ans);
        }
        return row;
    }
}