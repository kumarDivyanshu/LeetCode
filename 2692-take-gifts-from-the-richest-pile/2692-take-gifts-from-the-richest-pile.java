class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;
        for (int num : gifts) {
            que.add(num);
        }
        for (int i = 0; i < k; i++) {

            int temp = que.poll();
            int insert = (int) Math.sqrt(temp);
            que.add(insert);

        }
        while(!que.isEmpty())
        {
            sum+= que.poll();
        }
        return sum;
    }
}