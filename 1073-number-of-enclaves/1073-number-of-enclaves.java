class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];



        for(int i=0;i<n;i++){
            if(grid[i][0] == 1 && !visited[i][0])
            {
                dfs(grid , i , 0 , visited);
            }
            if(grid[i][m-1]==1 && !visited[i][m-1]){
                dfs(grid, i, m-1 , visited);
            }
        }

        for(int j=0;j<m;j++){
            if(grid[0][j]==1 && !visited[0][j]){
                dfs(grid,0,j,visited);
            }
            if(grid[n-1][j]==1 && !visited[n-1][j]){
                dfs(grid , n-1 , j , visited);
            }
        }
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    cnt++;
                }
            }
        }
//JUST FOR CHECKING

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }
        
        return cnt;
    }

    int[] dr = {1,-1,0,0};
    int[] dc = {0,0,1,-1};
    void dfs(int[][] grid , int sr , int sc , boolean[][] visited)
    {
        if(sr<0 || sr>=grid.length || sc<0 || sc>=grid[0].length || grid[sr][sc] != 1 || visited[sr][sc])
        {
            return;
        }

        visited[sr][sc]=true;

        for(int i=0;i<4;i++){
            int tr= sr + dr[i];
            int tc = sc + dc[i];

            dfs(grid , tr, tc , visited);
        }
         return;
    }
}