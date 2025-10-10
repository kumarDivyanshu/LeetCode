class Pair{
    int x;
    int y;
    int time;
    public Pair(int x, int y, int time){
        this.x = x;
        this.y = y;
        this.time = time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int cnt = 0;
        Queue<Pair> q= new LinkedList<>();
        int[][] visited = new int[grid.length][grid[0].length];
        int cntFresh=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j< grid[0].length ;j++)
            {
                if(grid[i][j] == 2){
                    Pair p = new Pair(i,j,0);
                    q.add(p);
                    visited[i][j] = 2;
                }
                else{
                    visited[i][j]=0;
                }
                if(grid[i][j] == 1){
                    cntFresh++;
                }
            }
        }
        int[] dr ={-1,1,0,0};
        int[] dc ={0,0,1,-1};
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int x =curr.x;
            int y = curr.y;
            int time = curr.time;
            cnt = Math.max(cnt, time);

            for(int i=0;i<4;i++){
                int di = x + dr[i];
                int dj = y + dc[i];

                if(di>=0 && dj>=0 && di<grid.length && dj<grid[0].length && grid[di][dj]==1 && visited[di][dj]!=2){
                    Pair p = new Pair(di,dj,time+1);
                    q.add(p);
                    visited[di][dj] = 2;
                }
            }
        }

        int temp=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j< grid[0].length ;j++)
            {
                if(visited[i][j]!=2 && grid[i][j]==1){
                    return -1;
                }
            }
        }
        return cnt;
    }
}