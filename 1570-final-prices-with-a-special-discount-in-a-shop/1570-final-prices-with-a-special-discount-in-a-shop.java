class Solution {
    public int[] finalPrices(int[] prices) {
        int arr[] = new int[prices.length];
        int count=0;
        for (int i = 0; i < prices.length; i++) {
            arr[i] = prices[i];

            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    arr[i] -= prices[j];
                    break;
                }
            }
        }
        return arr;
    }
}