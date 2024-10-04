class Solution {
    public long dividePlayers(int[] skill) {
        //1,2,3,3,4,5;
        Arrays.sort(skill);
        long sum=0;
        int n= skill.length;
        int abs_skill= skill[0] + skill[n-1];
        
        for(int i=0;i<n/2;i++)
        {
            if(abs_skill != skill[i]+ skill[n-i-1])
            {
                return -1;
            }
            sum += (long) skill[i]*skill[n-i-1];
        }
        return sum;
    }
}