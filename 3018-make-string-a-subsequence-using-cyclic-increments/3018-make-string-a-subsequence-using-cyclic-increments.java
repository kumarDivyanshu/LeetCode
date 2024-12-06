class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int n1=str1.length();
        int n2=str2.length();
        int diff=n1-n2;
        int j=0;
        if(n1<n2)
        {
            return false;
        }
        for(int i=0;i<n1 && j<n2;i++)
        {
            if( (str2.charAt(j)-str1.charAt(i)+26)%26<=1)
            {
                j++;
            }
            else if(diff>0)
            {
                diff--;
            }
            else
            {
                return false;
            }
        }
        return true;
    }
}