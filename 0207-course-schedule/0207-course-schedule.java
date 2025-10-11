class Solution {
    public boolean canFinish(int V, int[][] arr) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<V ;i++)
        {
            graph.add(new ArrayList<>());
        }

        for(int[] edge: arr){
            int from = edge[0];
            int to = edge[1];
            graph.get(from).add(to);
        }

        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];

        for(int i=0;i<V;i++)
        {
            if(!visited[i])
            {
                if(dfs(graph,visited,pathVisited , i)){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean dfs(List<List<Integer>> graph , boolean[] visited, boolean[] pathVisited ,int src)
    {
        visited[src] = true;
        pathVisited[src] = true;

        for(int nebor: graph.get(src)){
            if(!visited[nebor]){
                if(dfs(graph, visited , pathVisited , nebor)){
                    return true;
                }
            }
            else if(pathVisited[nebor]){
                return true;
            }
        }

        pathVisited[src]=false;
        return false;
    }
}