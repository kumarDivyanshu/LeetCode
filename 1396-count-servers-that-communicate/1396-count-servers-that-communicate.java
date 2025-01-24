class Solution {
    public int countServers(int[][] grid) {
        int row= grid.length;
        int col = grid[0].length;
        int[] rowcnt = new int[row];
        int[] colcnt = new int[col];
        int total =0;
        for(int i=0;i<row;i++)
        {
            for(int j=0; j<col; j++)
            {
                if(grid[i][j]==1)
                {
                    rowcnt[i]++;
                    colcnt[j]++;
                    total++;
                }
            }
        }
        
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(grid[i][j] == 1 && rowcnt[i] == 1 && colcnt[j] == 1)
                {
                    total--;
                }
            }
        }
        return total;
    }
}