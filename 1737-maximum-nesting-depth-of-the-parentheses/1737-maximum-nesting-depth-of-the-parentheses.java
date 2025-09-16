class Solution {
    public int maxDepth(String s) {
        int max =0;
        int sum = 0;

        for(char c : s.toCharArray())
        {
            if(c == '(')
            {
                sum++;
                max =Math.max(max , sum);
            }
            else if(c == ')'){
                sum--;

            }

        } 
        return max;
    }
}