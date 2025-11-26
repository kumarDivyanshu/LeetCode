class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n= rooms.size();
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0]= true;

        while(!q.isEmpty()){
            int currRoom = q.poll();
            for(int keys: rooms.get(currRoom))
            {
                if(!visited[keys])
                {
                    q.add(keys);
                    visited[keys]= true;
                }
            }
        }

        for(int i=0;i<n;i++){
            if(visited[i] == false){
                return false;
            }
        }
        return true;
    }
}