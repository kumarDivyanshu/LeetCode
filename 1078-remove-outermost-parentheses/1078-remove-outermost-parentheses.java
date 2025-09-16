class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        int i=0;
        int j=0;
        int sum =0;

        while(j<s.length())
        {
            if(s.charAt(j) == '(')
            {
                sum++;
            }
            else sum--;
            if(sum == 0){
                
                ans.append(s.substring(i+1 , j));
                i = j+1;
            }
            j++;
        }
        return ans.toString();
    }
}