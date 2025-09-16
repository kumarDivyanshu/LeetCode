class Solution {
    public int beautySum(String s) {
        List<String> str = new ArrayList<>();
        int sum =0;
        for(int i=0;i<s.length();i++)
        {
            int []arr = new int[26];
            for(int j=i;j<s.length() ; j++){
                // if(i==j) continue;
                // String newStr = s.substring(i,j+1);
                // System.out.println(newStr);
                int pos = s.charAt(j)-'a';
                arr[pos]++;
                int max =-1;
                int min = Integer.MAX_VALUE;
                for(int k=0;k<26;k++){
                    if(arr[k] != 0){
                        max = Math.max(max , arr[k]);
                        min = Math.min(min , arr[k]);
                    }
                }
                // System.out.println(max +" "+ min);
                if(max-min >0){
                    sum += (max-min);
                }
            }
        }
        return sum;

        
    }
}