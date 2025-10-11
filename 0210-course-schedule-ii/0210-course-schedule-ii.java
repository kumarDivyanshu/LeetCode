class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        Stack<Integer> st = new Stack<>();
        for(int i=0; i< prerequisites.length ;i++)
        {
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];

            graph.get(to).add(from);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];
        for(int i=0;i<numCourses ;i++){
            if(!visited[i])
            {
                if(dfs(graph,visited , pathVisited, i , st)){
                    return new int[0];
                }

            }
        }
        int[] ans = new int[numCourses];
        for(int i=numCourses-1; i>=0 ;i--){
            ans[i] = st.pop();
        }

        return ans;
       
    }

    public boolean dfs(List<List<Integer>> graph,boolean[] visited, boolean[] pathVisited , int src ,Stack<Integer> st)
    {
        visited[src] = true;
        pathVisited[src] =true;

        for(int nebor : graph.get(src)){
            if(!visited[nebor]){
                if(dfs(graph,visited , pathVisited, nebor, st)){
                    return true;
                }
            }
            else if(pathVisited[nebor]){
                return true;
            }
        } 
        st.push(src);
        pathVisited[src] = false;
        return false;
    }
}