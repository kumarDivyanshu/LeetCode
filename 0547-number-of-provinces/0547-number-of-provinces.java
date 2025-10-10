class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count=0;
        int V = isConnected.length;
        boolean[] visited = new boolean[V+1];
        // for(int i=0; i< V ;i++){
        //     if(!visited[i]){
        //         count++;
        //         dfs(i , isConnected , visited);
        //     }
        // }
        // return count;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                count++;
                q.add(i);
                visited[i] = true;
                while (!q.isEmpty()) {
                    int curr = q.poll();
                    for (int j = 0; j < V; j++) {
                        if (isConnected[curr][j] == 1 && !visited[j]) {
                            q.add(j);
                            visited[j] = true;
                        }
                    }
                }
            }
        }
        return count;

    }

    public void dfs(int start, int[][] isConnected , boolean[] visited){
        if(visited[start] == true) return;

        visited[start] = true;
        for(int i=0; i<isConnected[start].length ; i++){
            if(isConnected[start][i] == 1){
                dfs(i , isConnected , visited);
            }
        }
    }
}