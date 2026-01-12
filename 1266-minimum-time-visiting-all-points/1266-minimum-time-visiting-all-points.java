class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int cnt =0;
        int n = points.length;
        
        for(int i=1;i<n;i++){
            int Ix = points[i - 1][0];
            int Iy = points[i - 1][1];
            int x = points[i][0];
            int y = points[i][1];
            int dx = Math.abs(x - Ix);
            int dy = Math.abs(y - Iy);

            cnt += Math.max(dx , dy);
        }

        return cnt;
    }
}