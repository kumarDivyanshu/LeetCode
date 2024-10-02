class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int cpy[] = new int[arr.length];
        int rank[] = new int[arr.length];
        int curr =1;

        
        for(int i=0;i<arr.length;i++)
        {
            cpy[i]=arr[i];
        }
        Arrays.sort(cpy);
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<arr.length;i++)
        {
            if(map.get(cpy[i])==null)
            {
                map.put(cpy[i],curr);
                curr++;
            }
        }
        for(int i=0;i<arr.length;i++)
        {
            rank[i]=map.get(arr[i]);
        }

        return rank;

        


    }
}