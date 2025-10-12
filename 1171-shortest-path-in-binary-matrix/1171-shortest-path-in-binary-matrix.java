class Pair {
    int x;
    int y;
    int cost;

    public Pair(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int count = 0;
        Queue<Pair> pq = new LinkedList<>();

        if (grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0) {
            return -1;
        }

        pq.add(new Pair(0, 0, 0));
        int[][] dist = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int x = curr.x;
            int y = curr.y;
            int cost = curr.cost;

            if (x == grid.length - 1 && y == grid[0].length - 1) {
                return cost + 1;
            }

            int[] dx = { 0, 0, 1, -1, 1, -1, -1, 1 };
            int[] dy = { 1, -1, 0, 0, -1, 1, -1, 1 };

            for (int i = 0; i < 8; i++) {
                int tx = x + dx[i];
                int ty = y + dy[i];

                if (tx < grid.length && tx >= 0 && ty >= 0 && ty < grid[0].length && grid[tx][ty] == 0) {
                    if (cost + 1 < dist[tx][ty]) {
                        dist[tx][ty] = cost + 1;
                        pq.add(new Pair(tx, ty, cost + 1));

                    }
                }
            }
        }
        return -1;
    }
}