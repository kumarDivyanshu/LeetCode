class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int org_color = image[sr][sc];
        if (org_color == color) return image;
        // boolean[][] visited = new boolean[image.length+1][image[0].length+1];
        dfs(image,sr,sc,color,org_color);
        return image;
    }

    int[] dr={-1,1,0,0};
    int[] dc={0,0,-1,1};
    public void dfs(int[][] image, int sr, int sc, int color , int org_color)
    {
        if(sr<0 || sc<0 || sr>=image.length || sc>=image[0].length || image[sr][sc]!=org_color )
        {
            return;
        }
        image[sr][sc] = color;
        // visited[sr][sc] = true;
        for(int i=0;i<4;i++)
        {
            int tr = sr + dr[i];
            int tc = sc + dc[i];
            dfs(image,tr,tc, color , org_color);
            
        }
    }
}