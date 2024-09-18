class Solution {
    public String largestNumber(int[] nums) {
        int len = nums.length;

        String[] arr = new String[len];
        for(int i =0;i<len;i++)
        {
            arr[i] = Integer.toString(nums[i]);
        }


        Arrays.sort(arr,new Comparator<String>(){
            public int compare(String a , String b)
            {
                String ab= a+b;
                String ba = b+a;
                return ba.compareTo(ab);
            }
        });

        
        if(arr[0].equals("0"))
        {
            return "0";
        }

        StringBuilder str = new StringBuilder();
        for(String car:arr)
        {
            str.append(car);
        }
        return str.toString();
        
    }
}