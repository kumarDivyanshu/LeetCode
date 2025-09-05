class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        
        for(int i =0 ;i<=60 ; i++)
        {
            long sum = (long)num1 - (long) i*num2;
            if(sum < 0) continue;
            if(sum < i) continue;
            int ones = Long.bitCount(sum);
            if(ones <= i) return i;
        }
        return -1;
    }
}