class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int x = grid.length;
        int size = x * x;
        int arr[] = new int[size + 1]; 
        
        for (int i = 0; i < x; i++) { 
            for (int j = 0; j < x; j++) { 
                arr[grid[i][j]]++; 
            }
        }
        
        int missing = -1, duplicate = -1;
   
        for (int i = 1; i <= size; i++) {
            if (arr[i] == 0) {
                missing = i;
            } 
            if (arr[i] == 2) {
                duplicate = i;
            }
        }

        return new int[]{duplicate, missing};
    }
}
