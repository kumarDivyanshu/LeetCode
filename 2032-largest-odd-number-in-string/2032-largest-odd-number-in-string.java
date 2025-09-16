class Solution {
    public String largestOddNumber(String num) {
        // StringBuilder sb = new StringBuilder();
        for(int i=num.length()-1; i>=0 ;i--)
        {
            if(Integer.valueOf(num.charAt(i)) %2 != 0)
            {
                return num.substring(0, i+1);
            }
        }
        return "";
    }
}