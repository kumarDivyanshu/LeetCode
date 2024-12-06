class Solution {
    public String addSpaces(String s, int[] spaces) {
        int i=0;
        int j=0;

        StringBuilder res = new StringBuilder();

        for(int x=0;x<s.length();x++)
        {
            if(i < spaces.length && x == spaces[i])
            {
                res.append(" ");
                i++;
            }
            res.append(s.charAt(x));
        }
        return res.toString();
    }
}